package br.senai.sc.sfe.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.sfe.entity.Pessoa;
import br.senai.sc.sfe.entity.Sala;
import br.senai.sc.sfe.utils.JpaUtils;

public class SalaDao  {

	private EntityManager entityManager;

	public SalaDao() {
		JpaUtils.getInstance().createEntityManagerFactory();
		entityManager = JpaUtils.getInstance().getEntityManager();
	}
	
	/**
	 * Esse metodo salva ou altera a
	 * Sala
	 * */
	public Sala salvar(Sala sala){
		try {
			if (sala.getIdSala() == null) {
				entityManager.persist(sala);
			} else {
				entityManager.merge(sala);
			}
		} catch (Exception e) {
			Logger.getLogger(SalaDao.class.getName()).log(Level.SEVERE, null, e);
		}
		return sala;
	}
	
	/**
	 * Esse metodo remove a Sala.
	 * */
	
	public void remover(int id){
		Sala sala = entityManager.getReference(Sala.class, id);
		entityManager.remove(sala);
	}
	/** 
	 * Esse metodo lista as Salas.
	 * */
	
	public List<Sala> listar() {
		Query query = entityManager.createQuery("From Sala", Sala.class);
		return query.getResultList();
	}
	/** 
	 * Esse metodo busca a sala pelo ID.
	 * */
	
	public Sala buscarPorId(int id) {
		return entityManager.find(Sala.class, id);
	}
	
	/** 
	 * Esse metodo busca a Sala pela localizacao.
	 * */
	public List<Sala> buscarPorLocalizacao(String localizacao) {
		Query query = entityManager.createQuery(
				"From Sala s where s.localizacao LIKE :localizacao", Sala.class);
		query.setParameter("localizacao", localizacao);
		return query.getResultList();
	}
	/** 
	 * Esse metodo busca a Sala pelo tipo.
	 * */
	
	public List<Sala> buscarPorTipo(String tipo) {
		Query query = entityManager.createQuery(
				"From Sala s where s.tipo LIKE :tipo", Sala.class);
		query.setParameter("tipo", tipo);
		return query.getResultList();
	}
	/** 
	 * Esse metodo busca a Sala pela sala.
	 * */
	
	public List<Sala> buscarPorSala(String sala) {
		Query query = entityManager.createQuery(
				"From Sala s where s.sala LIKE :sala", Sala.class);
		query.setParameter("sala", sala);
		return query.getResultList();
	}
	/** 
	 * Esse metodo busca a Sala pela quantidade de lugares.
	 * */
	
	public List<Sala> buscarPorLugares(String lugares) {
		Query query = entityManager.createQuery(
				"From Sala s where s.lugares LIKE :lugares", Sala.class);
		query.setParameter("lugares", lugares);
		return query.getResultList();
	}
}
