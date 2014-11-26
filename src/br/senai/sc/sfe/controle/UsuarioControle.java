package br.senai.sc.sfe.controle;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.sfe.dao.UsuarioDao;
import br.senai.sc.sfe.entity.Usuario;

/**
 * @author talita_rossari
 *
 */
public class UsuarioControle {

	Usuario usuario;
	UsuarioDao usuarioDao;
	
	/**
	 * Construtor com singleton.
	 * */
	
	public UsuarioControle() {
		if(usuarioDao == null){
			usuarioDao = new UsuarioDao(); 
		}
	}
	
	/**
	 * Esse metodo valida os campos(V� se eles estao vazios) e salva ou altera o Usuario
	 * */
	
	public void salvar(Usuario usuario) throws Exception{
		if(usuario.getLogin()==null|| usuario.getLogin().trim().isEmpty()){
			throw new Exception("O login � obrigat�rio!");
		}
		Integer senha = usuario.getSenha();
		if(senha==null || senha<0){
			throw new Exception("A senha � obrigat�ria");
		}
		else{
		usuarioDao.salvar(usuario);
		}
	}
	
	/**
	 * Esse metodo remove o Usuario.
	 * */
	
	public void remover(int id){
		usuarioDao.remover(id);
	}
	
	/** 
	 * Esse metodo lista os Usuarios.
	 * */
	
	public List<Usuario> listar(){
		return usuarioDao.listar();
	}
	
	/** 
	 * Esse metodo busca o Usuario pelo ID.
	 * */
	
	public Usuario buscarPorId(int id) {
		return usuarioDao.buscarPorId(id);
	}
	
	/** 
	 * Esse metodo verifica se o Usuario Existe
	 * */
	
	public boolean buscarUsuario(String login, int senha){
		return usuarioDao.buscarUsuario(login, senha);
		}
	}

