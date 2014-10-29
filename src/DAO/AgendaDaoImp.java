package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Agenda;

import com.mysql.jdbc.Connection;

import conexao.ConnectionManager;

public class AgendaDaoImp implements AgendaDao {
	
	
	private final String INSERT = "insert into equipe (Nome_Equipe, Sigla_Equipe, Id_Tabela, InscFifa) values (?,?,?,?)";
	private final String UPDATE = "update equipe set Nome_Equipe = ?, Sigla_Equipe = ?, Id_Tabela = ?, InscFifa =? where Sigla_Equipe = ?";
	private final String DELETE = "delete from equipe where Sigla_Equipe = ?";
	private final String ALL = "select * from equipe";
	private final String SIGLA = "select * from equipe where Sigla_Equipe = ?";
	
	private static Connection connection;
	public AgendaDaoImp(){
		openConnection();
	}

	@Override
	public Agenda salvar(Agenda e) {
		try{
			
PreparedStatement ps = null;
			
			ps = ConnectionManager.getInstance().getConnection().prepareStatement(INSERT);
			
			ps.setObject(1, e.getSala().getIdSala());
			ps.setObject(2, e.getPessoa().getIdPessoa());
			ps.setObject(3, e.getHorario());
			ps.setObject(4, e.getDia());
			ps.setObject(5, e.getMes());
			ps.setObject(6, e.getAno());
			
			
			ps.executeUpdate();
		} catch (SQLException ex){
			Logger.getLogger(AgendaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		}
		return e;
	}

	@Override
	public void alterar(Agenda e) {
		PreparedStatement ps = null;
		
		try{
			
			ps = connection.prepareStatement(UPDATE);
			
		}catch (SQLException ex) {
			Logger.getLogger(AgendaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void deletar(Agenda e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Agenda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConnectionClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}

}
