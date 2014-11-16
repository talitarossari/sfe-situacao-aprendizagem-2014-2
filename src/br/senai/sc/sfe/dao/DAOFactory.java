package br.senai.sc.sfe.dao;


public abstract class DAOFactory {

	
   private static AgendaDao agendaDAO;
   
   public static AgendaDao getAgendaDao(){
	   if(agendaDAO == null){
		   agendaDAO = new AgendaDaoImp();
	   }
	   if(agendaDAO.isConnectionClose()){
		   agendaDAO.openConnection();
	   }
	   
	   return agendaDAO;
   }
   
	private static PessoaDao pessoaDAO;	
	public static PessoaDao getPessoaDao(){
		if(pessoaDAO == null){
			pessoaDAO = new PessoaDaoImp();
		}
		if(pessoaDAO.isConnectionClose()){
			   pessoaDAO.openConnection();
		   }
		
		
		return pessoaDAO;
	}
	private static SalaDao salaDAO;
	
	public static SalaDao getSalaDao(){
		
		if(salaDAO == null){
			salaDAO = new SalaDaoImp();
		}
		return salaDAO;
		
	}
	
	private static UsuarioDao usuarioDAO;	
	
	public static UsuarioDao getUsuarioDAO(){
		if(usuarioDAO == null){
			usuarioDAO = new UsuarioDaoImp();
		}
		if(usuarioDAO.isConnectionClose()){
			usuarioDAO.openConnection();
		}
		return usuarioDAO;
	}
}
