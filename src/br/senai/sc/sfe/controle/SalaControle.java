package br.senai.sc.sfe.controle;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.sfe.dao.SalaDao;
import br.senai.sc.sfe.entity.Sala;

public class SalaControle {

	Sala sala;
	SalaDao dao;

	/**
	 * Construtor com singleton.
	 * */

	public SalaControle() {
		if (dao == null) {
			dao = new SalaDao();
		}
	}

	/**
	 * Esse metodo valida os campos(Vê se eles estao vazios) e salva ou altera a
	 * Sala
	 * */

	public void salvar(Sala sala) throws Exception {
		if (sala.getDescricao() == null || sala.getDescricao().trim().isEmpty()) {
			throw new Exception("A descricao eh obrigatoria!");
		}
		if (sala.getLocalizacao() == null
				|| sala.getLocalizacao().trim().isEmpty()) {
			throw new Exception("A localizacao eh obrigatoria!");
		}
		if (sala.getQuantidadeLugares() == null
				|| sala.getQuantidadeLugares().trim().isEmpty()) {
			throw new Exception("A quantidade de lugares eh obrigatoria");
		}
		if (sala.getTipo() == null || sala.getTipo().trim().isEmpty()) {
			throw new Exception("O tipo de sala eh obrigatorio!");
		} else {
			dao.salvar(sala);
		}
	}

	/**
	 * Esse metodo remove a Sala.
	 * */

	public void remover(int id) {
		dao.remover(id);
	}
	
	/** 
	 * Esse metodo lista as Salas.
	 * */

	public List<Sala> listar() {
		return dao.listar();
	}

	/** 
	 * Esse metodo busca a sala pelo ID.
	 * */
	
	public Sala buscarPorId(int id) {
		return dao.buscarPorId(id);
	}
	
	/** 
	 * Esse metodo busca a Sala pela localizacao.
	 * */

	public List<Sala> buscarPorLocalizacao(String localizacao) {
		return dao.buscarPorLocalizacao(localizacao);
	}

	/** 
	 * Esse metodo busca a Sala pelo tipo.
	 * */
	
	public List<Sala> buscarPorTipo(String tipo) {
		return dao.buscarPorTipo(tipo);
	}
	
	/** 
	 * Esse metodo busca a Sala pela sala.
	 * */

	public List<Sala> buscarPorSala(String sala) {
		return dao.buscarPorSala(sala);
	}

	/** 
	 * Esse metodo busca a Sala pela quantidade de lugares.
	 * */
	
	public List<Sala> buscarPorLugares(String lugares) {
		return dao.buscarPorLugares(lugares);
	}

}
