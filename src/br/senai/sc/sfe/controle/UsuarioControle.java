package br.senai.sc.sfe.controle;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.sfe.dao.UsuarioDao;
import br.senai.sc.sfe.entity.Usuario;

public class UsuarioControle {

	Usuario usuario;
	UsuarioDao usuarioDao;
	
	public UsuarioControle() {
		if(usuarioDao == null){
			usuarioDao = new UsuarioDao(); 
		}
	}
	
	public void salvar(Usuario usuario) throws Exception{
		//TODO: Verificar depois
//		if(usuario.getPessoa().getIdPessoa()<0){
//			throw new Exception("A pessoa é obrigatória!");
//		}
		if(usuario.getLogin()==null|| usuario.getLogin().trim().isEmpty()){
			throw new Exception("O login é obrigatório!");
		}
		Integer senha = usuario.getSenha();
		if(senha==null || senha<0){
			throw new Exception("A senha é obrigatória");
		}
		else{
		usuarioDao.salvar(usuario);
		}
	}
	
	public void remover(int id){
		usuarioDao.remover(id);
	}
	
	public List<Usuario> buscarUsuarios(){
		return usuarioDao.listar();
	}
	
	public Usuario buscarPorId(int id) {
		return usuarioDao.buscarPorId(id);
	}
	
	public boolean buscarUsuario(String login, int senha){
		if(usuarioDao.buscarUsuario(login, senha)== true){
			return true;			
		} else {
			return false;
		}
	}
}
