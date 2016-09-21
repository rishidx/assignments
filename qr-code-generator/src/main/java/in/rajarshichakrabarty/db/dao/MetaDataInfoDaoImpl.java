package in.rajarshichakrabarty.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import in.rajarshichakrabarty.db.model.MetaDataInfo;
import in.rajarshichakrabarty.db.util.DBUtil;

public class MetaDataInfoDaoImpl extends DaoImpl<MetaDataInfo, Integer> implements MetaDataInfoDao {

	private static final Logger LOGGER = Logger.getLogger(MetaDataInfoDaoImpl.class);

	public MetaDataInfoDaoImpl() {
		super(MetaDataInfo.class);
	}

	@Override
	public void saveMetaDataInfo(MetaDataInfo metaDataInfo) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {
			entityManager = DBUtil.getEntityManager();
			entityTransaction = entityManager.getTransaction();
			LOGGER.debug("EntityTransaction active: " + entityTransaction.isActive());
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			throw ex;
		} finally {
			try {
				if (null != entityManager) {
					entityManager.close();
				}
			} catch (Exception ex) {
				LOGGER.error(ex.getMessage(), ex);
				throw ex;
			}
		}

		try {

			entityTransaction.begin();
			entityManager.persist(metaDataInfo);
			entityTransaction.commit();

		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		} finally {
			try {
				if (null != entityTransaction) {
					entityTransaction.rollback();
				}
				if (null != entityManager) {
					entityManager.close();
				}
			} catch (Exception ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		}

	}

	@Override
	public List<MetaDataInfo> getAllMetaDataInfo() {
		List<MetaDataInfo> metaDataInfos = null;

		try {
			metaDataInfos = findAll();
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
		return metaDataInfos;
	}

}
