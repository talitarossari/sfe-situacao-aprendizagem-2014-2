package br.senai.sc.sfe.dao;

import br.senai.sc.sfe.entity.Agenda;
import br.senai.sc.sfe.entity.Pessoa;
import br.senai.sc.sfe.entity.Sala;



public interface AgendaDao2 extends dao<Agenda> {
	
	Agenda buscarPorSala(Sala sala);
	Agenda buscarPorColaborador(Pessoa pessoa);
	
}
