package br.senai.sc.sfe.controle;

import br.senai.sc.sfe.entity.Usuario;

public class UsuarioControle {

	Usuario usuario;
	
	public void salvar(Usuario usuario) throws Exception{
		if(usuario.getPessoa().getIdPessoa()<0){
			throw new Exception("A pessoa � obrigat�ria!");
		}
		if(usuario.getLogin()==null|| usuario.getLogin().trim().isEmpty()){
			throw new Exception("O login � obrigat�rio!");
		}
		Integer senha = usuario.getSenha();
		if(senha==null || senha<0){
			throw new Exception("A senha � obrigat�ria");
		}

	}
}
