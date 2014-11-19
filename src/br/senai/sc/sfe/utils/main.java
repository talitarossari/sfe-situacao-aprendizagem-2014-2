package br.senai.sc.sfe.utils;

import br.senai.sc.sfe.dao.PessoaDao;
import br.senai.sc.sfe.entity.Pessoa;

public class main {
	
	public static void main(String[] args) {
		PessoaDao dao = new PessoaDao();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Teste");
		pessoa.setCpf("00000000000");
		pessoa.setAreaAtuacao("Area de atuacao");
		pessoa.setFuncao("Funcao");
		dao.salvar(pessoa);
	}

}
