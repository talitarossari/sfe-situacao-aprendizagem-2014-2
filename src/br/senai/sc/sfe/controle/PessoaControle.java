package br.senai.sc.sfe.controle;

import java.util.List;

import br.senai.sc.sfe.dao.DAOFactory;
import br.senai.sc.sfe.dao.PessoaDao;
import br.senai.sc.sfe.entity.Pessoa;

public class PessoaControle {

	Pessoa pessoa;

	public void salvar(Pessoa pessoa) throws Exception {
		if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
			throw new Exception("O nome � obrigatorio!");
		}
		if (pessoa.getFuncao() == null || pessoa.getFuncao().trim().isEmpty()) {
			throw new Exception("A fu��o � obrigatoria!");
		}
		if (pessoa.getAreaAtuacao() == null || pessoa.getAreaAtuacao().trim().isEmpty()) {
			throw new Exception("A �rea de atua��o � obrigat�ria!");
		}
		if(pessoa.getCpf()==null|| pessoa.getCpf().trim().length() < 14){
			throw new Exception("O CPF � obrigat�rio!");
		}
		
		PessoaDao pessoaDao = DAOFactory.getPessoaDao();
		pessoaDao.salvar(pessoa);
		
	}
	public List<Pessoa> lista() {
		PessoaDao pessoaDao = (PessoaDao) DAOFactory.getPessoaDao();
		return pessoaDao.findAll();
	}
	
	public void excluir(Pessoa pessoa) throws Exception{
		if(pessoa == null){
			throw new Exception("E obrigatorio seleciona uma Equipe!");
			
		}
		PessoaDao pessoaDao = DAOFactory.getPessoaDao();
		pessoaDao.deletar(pessoa);
	}
	
	public Pessoa buscarEquipePorSigla(int idPessoa) throws Exception{
		if(idPessoa == 0){
			throw new Exception("� obrigatorio digitar uma Sigla");
		}
		
		PessoaDao equipeDAO = DAOFactory.getPessoaDao();
		Pessoa equipe = equipeDAO.buscarPessoaPorID(idPessoa);
		if(equipe == null){
			throw new Exception("Equipe n�o Cadastrada!!");
			
		}else{
			return equipe;
		}

	}
	
}
