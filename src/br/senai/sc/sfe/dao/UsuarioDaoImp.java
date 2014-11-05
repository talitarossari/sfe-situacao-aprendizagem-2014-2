package br.senai.sc.sfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.senai.sc.sfe.conexao.ConnectionManager;
import br.senai.sc.sfe.entity.Usuario;

public class UsuarioDaoImp implements UsuarioDao {

	private final String INSERT = "INSERT INTO usuarios (login, senha, idPessoa`) VALUES (?, ?, ?);";
	private final String UPDATE = "update usuario set login = ?, senha = ? where idUsuarios = ?";
	private final String DELETE = "delete from usuario where idusuario = ?";
	private final String ALL = "select * from usuario";
	// private final String VERIFICAR = "select * from usuario where dataa = ?";
	private static Connection connection;

	public UsuarioDaoImp() {
		openConnection();
	}

	public Usuario salvar(Usuario e) {
		try {

			PreparedStatement ps = null;

			ps = ConnectionManager.getInstance().getConnection()
					.prepareStatement(INSERT);

			ps.setObject(1, e.getLogin());
			ps.setObject(2, e.getSenha());
			ps.setObject(3, e.getPessoa().getIdPessoa());

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
		return e;
	}

	public void alterar(Usuario e) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(UPDATE);

			ps.setObject(1, e.getLogin());
			ps.setObject(2, e.getSenha());
			ps.setObject(3, e.getIdUsuario());

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
	}

	public void deletar(Usuario e) {
		try {
			PreparedStatement ps = null;
			ps = connection.prepareStatement(DELETE);

			ps.setObject(1, e.getIdUsuario());

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
	}

	public List<Usuario> findAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = connection.prepareStatement(ALL);

			rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getInt("senha"));
				usuarios.add(usuario);
			}

		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
		return usuarios;
	}

	public boolean verificarUsuario(Usuario usuario) { // implementar
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isConnectionClose() {
		try {
			return connection.isClosed();
		} catch (SQLException ex) {
			return false;
		}
	}

	public void openConnection() {
		if (connection == null) {
			connection = ConnectionManager.getInstance().getConnection();
		}

		if (isConnectionClose()) {
			connection = ConnectionManager.getInstance().getConnection();
		}
	}

	public void closeConnection() {
		if (connection != null && !this.isConnectionClose()) {
			ConnectionManager.getInstance().closeConnection(connection);
		}

	}

}
