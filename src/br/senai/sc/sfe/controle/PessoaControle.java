package br.senai.sc.sfe.controle;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.sfe.dao.PessoaDao;
import br.senai.sc.sfe.entity.Pessoa;

public class PessoaControle {

	Pessoa pessoa;
	PessoaDao dao;
	
	public PessoaControle() {
		if(dao == null){
			dao = new PessoaDao(); 
		}
	}

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
	public void remover(int id){
		dao.remover(id);
	}
	
	public List<Pessoa> listar() {
		return dao.listar();
	}
	
	public Pessoa buscarPorId(int id) {
		return dao.buscarPorId(id);
	}
	
	public List<Pessoa> buscarPorNome(String nome) {
		return dao.buscarPorNome(nome);
	}
	public List<Pessoa> buscarPorFuncao(String funcao) {
		return dao.buscarPorFuncao(funcao);
	}
	public List<Pessoa> buscarPorArea(String area) {
		return dao.buscarPorArea(area);
	}
	
}
