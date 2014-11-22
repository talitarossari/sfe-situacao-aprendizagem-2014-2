package br.senai.sc.sfe.controle;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.sfe.dao.SalaDao;
import br.senai.sc.sfe.entity.Sala;

public class SalaControle {

	Sala sala;
	SalaDao dao;

	public SalaControle() {
		if (dao == null) {
			dao = new SalaDao();
		}
	}

	public void salvar(Sala sala) throws Exception {
		if (sala.getDescricao() == null || sala.getDescricao().trim().isEmpty()) {
			throw new Exception("A descricao eh obrigatoria!");
		}
		if (sala.getLocalizacao() == null || sala.getLocalizacao().trim().isEmpty()) {
			throw new Exception("A localizacao eh obrigatoria!");
		}
		if (sala.getQuantidadeLugares() == null || sala.getQuantidadeLugares().trim().isEmpty()) {
			throw new Exception("A quantidade de lugares eh obrigatoria");
		}
		if (sala.getTipo() == null || sala.getTipo().trim().isEmpty()) {
			throw new Exception("O tipo de sala eh obrigatorio!");
		}
		else{
			dao.salvar(sala);
		}
	}
	
	public void remover(int id){
		dao.remover(id);
	}
	
	public List<Sala> listar() {
		return dao.listar();
	}
	
	public Sala buscarPorId(int id) {
		return dao.buscarPorId(id);
	}
	
	public List<Sala> buscarPorLocalizacao(String localizacao) {
		return dao.buscarPorLocalizacao(localizacao);
	}
	
	public List<Sala> buscarPorTipo(String tipo) {
		return dao.buscarPorTipo(tipo);
	}
	
	public List<Sala> buscarPorSala(String sala) {
		return dao.buscarPorSala(sala);
	}
	
	public List<Sala> buscarPorLugares(String lugares) {
		return dao.buscarPorLugares(lugares);
	}

}
