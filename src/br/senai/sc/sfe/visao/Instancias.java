package br.senai.sc.sfe.visao;

public class Instancias {

	private static AgendamentoDeSala instanciaAgendamento;
	private static ListarSalas instanciaSala;
	private static ListarColaboradores instanciaColaboradores;
	
	public static AgendamentoDeSala getInstanceAgenda(){
		
		if(instanciaAgendamento==null){
			instanciaAgendamento = new AgendamentoDeSala();
		}
		return instanciaAgendamento;
	}
	
	public static ListarColaboradores getInstanceColaboradores(){
		
		if(instanciaColaboradores==null){
			instanciaColaboradores = new ListarColaboradores();
		}
		return instanciaColaboradores;
	}
	
	
public static ListarSalas getInstanceSala(){
		
		if(instanciaSala==null){
			instanciaSala = new ListarSalas();
		}
		return instanciaSala;
	}
	
}
