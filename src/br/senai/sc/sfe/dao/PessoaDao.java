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
			if (pessoa.getIdPessoa() == null) {
				entityManager.persist(pessoa);
			} else {
				entityManager.merge(pessoa);
			}
		} catch (Exception e) {
			Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, e);
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
		Query query = entityManager.createQuery(
				"From Pessoa p where p.nome LIKE :nome", Pessoa.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}
	
	
	
	
	
	
	
	
	

}
