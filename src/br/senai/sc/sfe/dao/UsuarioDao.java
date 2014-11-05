package br.senai.sc.sfe.dao;

import br.senai.sc.sfe.entity.Usuario;

public interface UsuarioDao extends dao<Usuario> {

	boolean verificarUsuario(Usuario usuario);
}
