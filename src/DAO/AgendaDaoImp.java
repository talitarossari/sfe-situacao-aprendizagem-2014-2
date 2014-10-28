package DAO;

import java.util.List;

import modelo.Agenda;

import com.mysql.jdbc.Connection;

public class AgendaDaoImp implements AgendaDao {
	
	
	private static Connection connection;
	public AgendaDaoImp(){
		openConnection();
	}

	@Override
	public Agenda salvar(Agenda e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Agenda e) {
		// TODO Auto-generated method stub
		
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
