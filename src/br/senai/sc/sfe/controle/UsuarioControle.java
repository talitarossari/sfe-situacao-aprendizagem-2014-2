package br.senai.sc.sfe.controle;

import br.senai.sc.sfe.entity.Usuario;

public class UsuarioControle {

	Usuario usuario;
	
	public void salvar(Usuario usuario) throws Exception{
		if(usuario.getPessoa().getIdPessoa()<0){
			throw new Exception("A pessoa é obrigatória!");
		}
		if(usuario.getLogin()==null|| usuario.getLogin().trim().isEmpty()){
			throw new Exception("O login é obrigatório!");
		}
		Integer senha = usuario.getSenha();
		if(senha==null || senha<0){
			throw new Exception("A senha é obrigatória");
		}

	}
}
