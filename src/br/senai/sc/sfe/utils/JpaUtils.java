package br.senai.sc.sfe.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static JpaUtils instance;
	private EntityManagerFactory entityManagerFactory;

	private JpaUtils() {

	}

	public static JpaUtils getInstance() {
		if (instance == null) {
			instance = new JpaUtils();
		}
		return instance;
	}

	public void createEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("SituacaoAprendizagemPU");
		}
	}

	public void closeFactory() {
		entityManagerFactory.close();
	}

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
