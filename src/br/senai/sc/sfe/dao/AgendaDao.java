package br.senai.sc.sfe.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.sfe.entity.Agenda;
import br.senai.sc.sfe.utils.JpaUtils;

public class AgendaDao {

	private EntityManager entityManager;

	public AgendaDao() {
		JpaUtils.getInstance().createEntityManagerFactory();
		entityManager = JpaUtils.getInstance().getEntityManager();
	}
	
	public Agenda salvar(Agenda agenda){
		try {
			entityManager.getTransaction().begin();
			if (agenda.getIdAgenda() == null) {
				entityManager.persist(agenda);
			} else {
				entityManager.merge(agenda);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			Logger.getLogger(AgendaDao.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			entityManager.close();
		}
		return agenda;
	}
	
	public void remover(int id){
		Agenda agenda = entityManager.getReference(Agenda.class, id);
		entityManager.remove(agenda);
	}
	
	public List<Agenda> listar() {
		Query query = entityManager.createQuery("From Agenda", Agenda.class);
		return query.getResultList();
	}
	
	public Agenda buscarPorId(int id) {
		return entityManager.find(Agenda.class, id);
	}
	
	public List<Agenda> buscarPorSala(int id) {
		Query query = entityManager.createQuery("From Agenda a where a.sala.idSala = :idSala", Agenda.class);
		query.setParameter("idSala", id);
		return query.getResultList();
	}
	
	public List<Agenda> buscarPorSalaAndPessoa(int idSala, int idPessoa) {
		Query query = entityManager.createQuery(
				"From Agenda a where a.sala.idSala = :idSala and a.pessoa.idPessoa = :idPessoa", Agenda.class);
		query.setParameter("idSala", idSala);
		query.setParameter("idPessoa", idPessoa);
		return query.getResultList();
	}

}
