package br.senai.sc.sfe.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.sfe.entity.Pessoa;
import br.senai.sc.sfe.entity.Sala;
import br.senai.sc.sfe.utils.JpaUtils;

/**
 * @author nestor_augusto
 *
 */
public class PessoaDao {

	private EntityManager entityManager;

	/**
	 * Consutor criando instancia
	 */
	
	public PessoaDao() {
		JpaUtils.getInstance().createEntityManagerFactory();
		entityManager = JpaUtils.getInstance().getEntityManager();
	}

	/**
	 * @param pessoa
	 * @return Esse metodo salva ou altera a Pessoa
	 */
	public Pessoa salvar(Pessoa pessoa) {
		
		try {
			entityManager.getTransaction().begin();
				entityManager.persist(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null,
					e);
		} finally {
			entityManager.close();
		}
		return pessoa;
	}

	public Pessoa editar(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null,
					e);
		} finally {
			entityManager.close();
		}
		return pessoa;
	}

	/**
	 * @param id
	 *            Esse metodo remove a pessoa.
	 */
	public void remover(int id) {
		try {
			entityManager.getTransaction().begin();
			Pessoa pessoa = entityManager.getReference(Pessoa.class, id);
			entityManager.remove(pessoa);
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null,
					e);
		} finally {
			entityManager.close();
		}
	}

	/**
	 * @return Esse metodo lista as pessoas.
	 */
	public List<Pessoa> listar() {
		Query query = entityManager.createQuery("From Pessoa", Pessoa.class);
		return query.getResultList();
	}

	/**
	 * @param id
	 * @return Esse metodo busca a pessoa pelo ID.
	 */
	public Pessoa buscarPorId(int id) {
		return entityManager.find(Pessoa.class, id);
	}

	/**
	 * @param nome
	 * @return Esse metodo busca a pessoa pelo nome.
	 */
	public List<Pessoa> buscarPorNome(String nome) {
		Query query = entityManager.createQuery(
				"From Pessoa as p where p.nome LIKE :nome", Pessoa.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}

	/**
	 * @param funcao
	 * @return Esse metodo busca a pessoa pela funcao.
	 */
	public List<Pessoa> buscarPorFuncao(String funcao) {
		Query query = entityManager.createQuery(
				"From Pessoa as p where p.funcao LIKE :funcao", Pessoa.class);
		query.setParameter("funcao", funcao);
		return query.getResultList();
	}

	/**
	 * @param area
	 * @return Esse metodo busca a pessoa pela de atuacao.
	 */
	public List<Pessoa> buscarPorArea(String area) {
		Query query = entityManager.createQuery(
				"From Pessoa as p where p.areaAtuacao LIKE :area", Pessoa.class);
		query.setParameter("area", area);
		return query.getResultList();
	}

}
