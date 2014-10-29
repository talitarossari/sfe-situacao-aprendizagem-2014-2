package DAO;

import modelo.Agenda;
import modelo.Pessoa;
import modelo.Sala;



public interface AgendaDao extends dao<Agenda> {
	
	Agenda buscarPorSala(Sala sala);
	Agenda buscarPorColaborador(Pessoa pessoa);
	
}
