package DAO;

import modelo.Usuario;

public interface UsuarioDao extends dao<Usuario> {

	 boolean verificarUsuario(Usuario usuario);
}
