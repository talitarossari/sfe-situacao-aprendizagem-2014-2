package DAO;

import modelo.Pessoa;

public interface PessoaDao extends dao<Pessoa>{
      Pessoa buscarPessoaPorID(int idPessoa);
}
