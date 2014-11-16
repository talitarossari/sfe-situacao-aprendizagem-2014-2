package br.senai.sc.sfe.dao;

import br.senai.sc.sfe.entity.Pessoa;

public interface PessoaDao extends dao<Pessoa>{
	Pessoa buscarPessoaPorID(int idPessoa);
}
