package in.rajarshichakrabarty.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;

import in.rajarshichakrabarty.db.model.DBEntity;

public class DaoImpl<T extends DBEntity, I> implements Dao<T, I> {

	private static final Logger LOGGER = Logger.getLogger(DaoImpl.class);
	private EntityManager entityManager;
	private Class<T> entityClass;

	public DaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<T> findAll() {
		CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);
		criteriaQuery.from(this.entityClass);
		TypedQuery<T> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

	@Override
	public T findById(T id) {
		return this.getEntityManager().find(entityClass, id);
	}

	@Override
	public void save(T t) {
		EntityManager entityManager = null;
		EntityTransaction txn = null;

		try {
			entityManager = getEntityManager();
			txn = entityManager.getTransaction();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("EntityTransaction active: " + txn.isActive());
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}

		try {
			txn.begin();
			entityManager.persist(t);
			txn.commit();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			if (txn.isActive()) {
				txn.rollback();
			}

			throw e;
		}

	}

	@Override
	public void remove(T t) {
		EntityManager entityManager = null;
		EntityTransaction txn = null;

		try {
			entityManager = getEntityManager();
			txn = entityManager.getTransaction();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("EntityTransaction active: " + txn.isActive());
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}

		try {
			txn.begin();

			if (t == null) {
				return;
			}

			T entity = findById(t);
			if (entity == null) {
				return;
			}
			entityManager.remove(entity);
			txn.commit();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			txn.rollback();
			throw e;
		}

	}

}
