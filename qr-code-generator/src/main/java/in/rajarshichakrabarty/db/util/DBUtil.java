package in.rajarshichakrabarty.db.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class DBUtil {

	private static final Logger LOGGER = Logger.getLogger(DBUtil.class);

	private static EntityManagerFactory entityManagerFactory;

	static {
		LOGGER.info("Initializing EntityManagerFactory");
		entityManagerFactory = Persistence.createEntityManagerFactory("QRCodeGenerator");
	}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public static void closeEntityManager(EntityManager entityManager) {
		LOGGER.info("Closing entity manager");
		if (null != entityManager) {
			entityManager.close();
		}
	}
}
