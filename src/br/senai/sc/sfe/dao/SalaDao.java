package br.senai.sc.sfe.dao;

import java.util.List;

import br.senai.sc.sfe.entity.Sala;

public interface SalaDao extends dao<Sala> {

	List<Sala> buscarPorId(int idSala);
	
}
