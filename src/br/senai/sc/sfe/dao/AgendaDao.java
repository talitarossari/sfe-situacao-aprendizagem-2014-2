package br.senai.sc.sfe.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.sfe.entity.Agenda;
import br.senai.sc.sfe.utils.JpaUtils;

/**
 * @author nestor_augusto
 *
 */

/**
 * @author big
 *
 */
public class AgendaDao {

	private EntityManager entityManager;

	/**
	 * Consutor criando instancia
	 * */
	public AgendaDao() {
		JpaUtils.getInstance().createEntityManagerFactory();
		entityManager = JpaUtils.getInstance().getEntityManager();
	}

	/**
	 * @param agenda
	 * @return Agenda Esse metodo salva ou altera o agendamento
	 */
	public Agenda salvar(Agenda agenda) {
		
		
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
			Logger.getLogger(AgendaDao.class.getName()).log(Level.SEVERE, null,
					e);
		} finally {
			entityManager.close();
		}
		return agenda;
	}

	public Agenda editar(Agenda agenda) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(agenda);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			Logger.getLogger(AgendaDao.class.getName()).log(Level.SEVERE, null,
					e);
		} finally {
			entityManager.close();
		}
		return agenda;
	}

	/**
	 * @param id
	 *            Esse metodo remove a agenda.
	 */
	public void remover(int id) {
		try {
			entityManager.getTransaction().begin();
			Agenda agenda = entityManager.find(Agenda.class, id);
			entityManager.remove(agenda);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			Logger.getLogger(AgendaDao.class.getName()).log(Level.SEVERE, null,
					e);
		} finally {
			entityManager.close();
		}
	}

	/**
	 * @return Esse metodo lista as agendas.
	 */
	public List<Agenda> listar() {
		Query query = entityManager.createQuery("From Agenda", Agenda.class);
		return query.getResultList();
	}

	/**
	 * @param id
	 * @return Esse metodo busca a agenda pelo ID.
	 */
	public Agenda buscarPorId(int id) {
		return entityManager.find(Agenda.class, id);
	}

	/**
	 * @param id
	 * @return Esse metodo busca a agenda pela sala(id).
	 */
	public List<Agenda> buscarPorSala(int id) {
		Query query = entityManager.createQuery(
				"From Agenda a where a.sala.idSala = :idSala", Agenda.class);
		query.setParameter("idSala", id);
		return query.getResultList();
	}

	/**
	 * @param idSala
	 * @param idPessoa
	 * @return Esse metodo busca a agenda pela sala(id) e pela Pessoa(id).
	 */
	public List<Agenda> buscarPorSalaAndPessoa(int idSala, int idPessoa) {
		Query query = entityManager
				.createQuery(
						"From Agenda a where a.sala.idSala = :idSala and a.pessoa.idPessoa = :idPessoa",
						Agenda.class);
		query.setParameter("idSala", idSala);
		query.setParameter("idPessoa", idPessoa);
		return query.getResultList();
	}

}
