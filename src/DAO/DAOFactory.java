package DAO;

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
			pessoaDAO == new PessoaDaoimp();
		}
		
		return pessoaDAO;
	}
	private static SalaDao salaDAO;	
	private static UsuarioDao usuarioDAO;	
	
}
