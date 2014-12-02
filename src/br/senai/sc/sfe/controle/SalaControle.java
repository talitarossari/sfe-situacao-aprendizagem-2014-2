package br.senai.sc.sfe.controle;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.sfe.dao.SalaDao;
import br.senai.sc.sfe.entity.Sala;

/**
 * @author nestor_augusto
 *
 */
public class SalaControle {

	Sala sala;
	SalaDao dao;
	/**
	 * Construtor com singleton.
	 */
	public SalaControle() {
		if (dao == null) {
			dao = new SalaDao();
		}
	}
	/**
	 * @param sala
	 * @throws Exception
	 * Esse metodo valida os campos(Vê se eles estao vazios) e salva ou altera a Sala
	 */
	public void salvar(Sala sala) throws Exception {
		if (sala.getLocalizacao() == null
				|| sala.getLocalizacao().trim().isEmpty()) {
			throw new Exception("A localizacao é obrigatória!");
		}
		if (sala.getDescricao() == null || sala.getDescricao().trim().isEmpty()) {
			throw new Exception("A descricao é obrigatória!");
		}
		if (sala.getTipo() == null || sala.getTipo().trim().isEmpty()|| sala.getTipo() == "Selecione") {
			throw new Exception("O tipo de sala é obrigatório!");
		}
		if (sala.getQuantidadeLugares() == null
				|| sala.getQuantidadeLugares().trim().isEmpty()|| sala.getQuantidadeLugares()  == "Selecione") {
			throw new Exception("A quantidade de lugares é obrigatória");
		}
		 else {
			dao.salvar(sala);
		}
	}
	/**
	 * @param id
	 * Esse metodo remove a Sala.
	 */
	public void remover(int id) {
		dao.remover(id);
	}
	/**
	 * @return
	 * Esse metodo lista as Salas.
	 */
	public List<Sala> listar() {
		return dao.listar();
	}
	/**
	 * @param id
	 * @return
	 * Esse metodo busca a sala pelo ID.
	 */
	public Sala buscarPorId(int id) {
		return dao.buscarPorId(id);
	}
	/**
	 * @param localizacao
	 * @return
	 * Esse metodo busca a Sala pela localizacao.
	 */
	public List<Sala> buscarPorLocalizacao(String localizacao) {
		return dao.buscarPorLocalizacao(localizacao);
	}	
	/**
	 * @param tipo
	 * @return
	 * Esse metodo busca a Sala pelo tipo.
	 */
	public List<Sala> buscarPorTipo(String tipo) {
		return dao.buscarPorTipo(tipo);
	}
	/**
	 * @param sala
	 * @return
	 * Esse metodo busca a Sala pela sala.
	 */
	public List<Sala> buscarPorSala(String sala) {
		return dao.buscarPorSala(sala);
	}
	/**
	 * @param lugares
	 * @return
	 * Esse metodo busca a Sala pela quantidade de lugares.
	 */
	public List<Sala> buscarPorLugares(String lugares) {
		return dao.buscarPorLugares(lugares);
	}

	public List<Sala> buscarPorAnoEMes(String ano,String mes) {
		return dao.buscarPorAnoEMes(ano, mes);
	}
	
}
