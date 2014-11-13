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
import br.senai.sc.sfe.entity.Sala;

public class SalaDaoImp implements SalaDao{

	private final String INSERT = "INSERT INTO sala (localizacao, descricao, tipo, quantidadeLugares, idSala) VALUES (?,?,?,?,?);";
	private final String UPDATE = "update sala set localizacao = ?, descricao = ?, quantidadeLugares = ? where idSala = ?";
	private final String DELETE = "delete from sala where idSala = ?";
	private final String ALL = "select * from sala";
	private final String ID = "select * from sala where idSala = ?";
	private static Connection connection;
	
	public SalaDaoImp() {
		openConnection();
	}

	public Sala salvar(Sala e) {
		try {

			PreparedStatement ps = null;

			ps = ConnectionManager.getInstance().getConnection()
					.prepareStatement(INSERT);

			ps.setObject(1, e.getLocalizacao());
			ps.setObject(2, e.getDescricao());
			ps.setObject(3, e.getTipo());
			ps.setObject(4, e.getQuantidadeLugares());
			ps.setObject(3, e.getIdSala());

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
		return e;
	}
	
	public void alterar(Sala e) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(UPDATE);

			ps.setObject(1, e.getLocalizacao());
			ps.setObject(2, e.getDescricao());
			ps.setObject(3, e.getQuantidadeLugares());
			ps.setObject(3, e.getIdSala());

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
	}

	public void deletar(Sala e) {
		try {
			PreparedStatement ps = null;
			ps = connection.prepareStatement(DELETE);

			ps.setObject(1, e.getIdSala());

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
	}
	
	public List<Sala> findAll() {
		List<Sala> salas = new ArrayList<Sala>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = connection.prepareStatement(ALL);

			rs = ps.executeQuery();

			while (rs.next()) {
				Sala sala = new Sala();
				sala.setIdSala(rs.getInt("idSala"));
				sala.setLocalizacao(rs.getString("localizacao"));
				sala.setDescricao(rs.getString("descricao"));
				sala.setQuantidadeLugares(rs.getInt("quantidadeLugares"));
				salas.add(sala);
				
			}

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
		return salas;
	}
	
	public List<Sala> buscarPorId(int idSala) {
		List<Sala> salas = new ArrayList<Sala>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ps = connection.prepareStatement(ID);
			ps.setObject(1, idSala);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Sala sala = new Sala();
				sala.setIdProduto(rs.getInt("idProduto"));
				sala.setNome(rs.getString("nome"));
				sala.setLocalidadeProduto(rs.getString("localidadeProduto"));
				sala.setQuantidade(rs.getDouble("quantidade"));
				produtos.add(produto);
			}

		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		if (produtos.isEmpty()) {
			return null;
		} else {
			return produtos.get(0);
		}
	}
}
