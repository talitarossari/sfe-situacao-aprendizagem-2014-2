package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Pessoa;
import conexao.ConnectionManager;

public class PessoaDaoimp implements PessoaDao {

	private final String INSERT = "insert into pessoa (nome, cpf, funcao, areaAtuacao) values (?,?,?,?)";
	private final String UPDATE = "update pessoa set nome = ?, cpf = ?, funcao = ?, areaAtuacao where idpessoa = ?";
	private final String DELETE = "delete from pessoa where idpessoa = ?";
	private final String ALL = "select * from pessoa";
	private final String ID = "select * from pessoa where idpessoa = ?";
	private static Connection connection;
	
	public PessoaDaoimp() {
		openConnection();
	}
	
	public Pessoa salvar(Pessoa e){
		try {

			PreparedStatement ps = null;
			
			ps = ConnectionManager.getInstance().getConnection().prepareStatement(INSERT);
			
			ps.setObject(1, e.getNome());
			ps.setObject(2, e.getCpf());
			ps.setObject(3, e.getFuncao());
			ps.setObject(4, e.getAreaAtuacao());
			
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			Logger.getLogger(PessoaDaoimp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		return e;
		}
	
	public void alterar(Pessoa e) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(UPDATE);
			
			ps.setObject(1, e.getNome());
			ps.setObject(2, e.getCpf());
			ps.setObject(3, e.getFuncao());
			ps.setObject(4, e.getAreaAtuacao());
			ps.setObject(5, e.getIdPessoa());
			
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(PessoaDaoimp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
	}

	public void deletar(Pessoa e) {
		try {
			PreparedStatement ps = null;
			ps = connection.prepareStatement(DELETE);

			ps.setObject(1, e.getIdPessoa());
			
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(PessoaDaoimp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
	}
	
	public List<Pessoa> findAll() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ps = connection.prepareStatement(ALL);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setIdPessoa(rs.getInt("idPessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setFuncao(rs.getString("funcao"));
				pessoa.setAreaAtuacao(rs.getString("areaAtuacao"));
				pessoas.add(pessoa);
			}

		} catch (SQLException ex) {
			Logger.getLogger(PessoaDaoimp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		return pessoas;
	} 
	
	public Pessoa buscarPessoaPorID(int idPessoa) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ps = connection.prepareStatement(ID);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setIdPessoa(rs.getInt("idPessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setFuncao(rs.getString("funcao"));
				pessoa.setAreaAtuacao(rs.getString("areaAtuacao"));
				pessoas.add(pessoa);
			}

		} catch (SQLException ex) {
			Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		if (pessoas.isEmpty()) {
			return null;
		} else {
			return pessoas.get(0);
		}
	}
	
	 public boolean isConnectionClose() {
			try {
				return connection.isClosed();
			} catch (SQLException ex) {
				return false;
			}
		}

		public void openConnection() {
			if ( connection == null) {
				connection = ConnectionManager.getInstance().getConnection();
			}
			
			if ( isConnectionClose() ) {
				connection = ConnectionManager.getInstance().getConnection();
			}		
		}

		public void closeConnection() {
			if ( connection != null && !this.isConnectionClose()) {
				ConnectionManager.getInstance().closeConnection(connection);
			}
			
		}
	
}
