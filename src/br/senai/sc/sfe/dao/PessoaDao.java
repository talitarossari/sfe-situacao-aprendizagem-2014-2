package br.senai.sc.sfe.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.sfe.entity.Pessoa;
import br.senai.sc.sfe.utils.JpaUtils;

public class PessoaDao {

	private EntityManager entityManager;

	public PessoaDao() {
		JpaUtils.getInstance().createEntityManagerFactory();
		entityManager = JpaUtils.getInstance().getEntityManager();
	}
	
	public Pessoa salvar(Pessoa pessoa){
		try {
			entityManager.getTransaction().begin();
			if (pessoa.getIdPessoa() == null) {
				entityManager.persist(pessoa);
			} else {
				entityManager.merge(pessoa);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			entityManager.close();
		}
		return pessoa;
	}
	
	public void remover(int id){
		Pessoa pessoa = entityManager.getReference(Pessoa.class, id);
		entityManager.remove(pessoa);
	}
	
	public List<Pessoa> listar() {
		Query query = entityManager.createQuery("From Pessoa", Pessoa.class);
		return query.getResultList();
	}
	
	public Pessoa buscarPorId(int id) {
		return entityManager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> buscarPorNome(String nome) {
		Query query = entityManager.createQuery("From Pessoa p where p.nome LIKE :nome", Pessoa.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}
	public List<Pessoa> buscarPorFuncao(String funcao) {
		Query query = entityManager.createQuery("From Pessoa p where p.funcao LIKE :funcao", Pessoa.class);
		query.setParameter("funcao", funcao);
		return query.getResultList();
	}
	public List<Pessoa> buscarPorArea(String area) {
		Query query = entityManager.createQuery("From Pessoa p where p.areaAtuacao LIKE :area", Pessoa.class);
		query.setParameter("area", area);
		return query.getResultList();
	}

}
