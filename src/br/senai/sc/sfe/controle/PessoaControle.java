package br.senai.sc.sfe.controle;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.sfe.dao.PessoaDao;
import br.senai.sc.sfe.entity.Pessoa;

/**
 * @author nestor_augusto
 *
 */
public class PessoaControle {

	Pessoa pessoa;
	PessoaDao dao;
	/**
	 * Construtor com singleton.
	 */
	public PessoaControle() {
		if(dao == null){
			dao = new PessoaDao(); 
		}
	}
	/**
	 * @param pessoa
	 * @throws Exception
	 * Esse metodo valida os campos(Vê se eles estao vazios) e salva ou altera a Pessoa
	 */
	public void salvar(Pessoa pessoa) throws Exception {
		if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
			throw new Exception("O nome é obrigatorio!");
		}
		if (pessoa.getFuncao() == null || pessoa.getFuncao().trim().isEmpty()) {
			throw new Exception("A fução é obrigatoria!");
		}
		if (pessoa.getAreaAtuacao() == null || pessoa.getAreaAtuacao().trim().isEmpty()) {
			throw new Exception("A área de atuação é obrigatória!");
		}
		if(pessoa.getCpf()==null|| pessoa.getCpf().trim().length() < 14){
			throw new Exception("O CPF é obrigatório!");
		}
		
		dao.salvar(pessoa);
		
	}
	/**
	 * @param id
	 * 
	 */
	public void remover(int id){
		dao.remover(id);
	}
	
	/** 
	 * Esse metodo lista as pessoas.
	 * */
	
	public List<Pessoa> listar() {
		return dao.listar();
	}
	
	/** 
	 * Esse metodo busca a pessoa pelo ID.
	 * */
	
	public Pessoa buscarPorId(int id) {
		return dao.buscarPorId(id);
	}
	
	/** 
	 * Esse metodo busca a pessoa pelo nome.
	 * */
	
	public List<Pessoa> buscarPorNome(String nome) {
		return dao.buscarPorNome(nome);
	}
	
	/** 
	 * Esse metodo busca a pessoa pela funcao.
	 * */
	
	public List<Pessoa> buscarPorFuncao(String funcao) {
		return dao.buscarPorFuncao(funcao);
	}
	
	/** 
	 * Esse metodo busca a p pela de atuacao.
	 * */
	
	public List<Pessoa> buscarPorArea(String area) {
		return dao.buscarPorArea(area);
	}
	
}
