package br.senai.sc.sfe.controle;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.sfe.dao.UsuarioDao;
import br.senai.sc.sfe.entity.Usuario;

/**
 * @author nestor_augusto
 *
 */
public class UsuarioControle {

	Usuario usuario;
	UsuarioDao usuarioDao;
	/**
	 * Construtor com singleton.
	 */
	public UsuarioControle() {
		if(usuarioDao == null){
			usuarioDao = new UsuarioDao(); 
		}
	}
	/**
	 * @param usuario
	 * @throws Exception
	 * Esse metodo valida os campos(Vê se eles estao vazios) e salva ou altera o Usuario
	 */
	public void salvar(Usuario usuario) throws Exception{
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
	/**
	 * @param id
	 * Esse metodo remove o Usuario.
	 */
	public void remover(int id){
		usuarioDao.remover(id);
	}
	/**
	 * @return
	 * Esse metodo lista os Usuarios.
	 */
	public List<Usuario> listar(){
		return usuarioDao.listar();
	}	
	/**
	 * @param id
	 * @return
	 * Esse metodo busca o Usuario pelo ID.
	 */
	public Usuario buscarPorId(int id) {
		return usuarioDao.buscarPorId(id);
	}
	/**
	 * @param login
	 * @param senha
	 * @return
	 * Esse metodo verifica se o Usuario Existe
	 */
	public boolean buscarUsuario(String login, int senha){
		return usuarioDao.buscarUsuario(login, senha);
		}
	}

