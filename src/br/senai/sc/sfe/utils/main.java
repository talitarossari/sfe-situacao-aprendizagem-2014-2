package br.senai.sc.sfe.utils;

import br.senai.sc.sfe.dao.PessoaDao;
import br.senai.sc.sfe.dao.UsuarioDao;
import br.senai.sc.sfe.entity.Pessoa;
import br.senai.sc.sfe.entity.Usuario;

public class main {
	
	public static void main(String[] args) {
		PessoaDao dao = new PessoaDao();
//		UsuarioDao uDao = new UsuarioDao();
		Pessoa pessoa = new Pessoa();
//		Usuario usuario = new Usuario();
		pessoa.setNome("Teste");
		pessoa.setCpf("00000000000");
		pessoa.setAreaAtuacao("Area de atuacao");
		pessoa.setFuncao("Funcao");
		pessoa.getUsuario().setLogin("Talita_Rossari");
		pessoa.getUsuario().setSenha(2201);
		dao.salvar(pessoa);
		
	}

}
