package br.senai.sc.sfe.controle;

import java.util.List;

import javax.persistence.EntityManager;

import br.senai.sc.sfe.dao.AgendaDao;
import br.senai.sc.sfe.entity.Agenda;

/**
 * @author talita_rossari
 *
 */

public class AgendaControle {
	
	
	Agenda agenda;
	AgendaDao agendaDao;
	
	/** 
	 * Construtor com singleton.
	 * */
	
	public AgendaControle() {
		if(agendaDao == null){
			agendaDao = new AgendaDao(); 
		}
	}
	
	/** 
	 * Esse metodo valida os campos(Vê se eles estao vazios) e salva ou altera o agendamento
	 * */
	
	public void salvar(Agenda agenda) throws Exception {
		
		if(agenda.getSala().getIdSala()<=0){
			throw new Exception("A sala nao foi selecionada!");
		}
		if(agenda.getPessoa().getIdPessoa()<=0){
			throw new Exception("O Colaborador nao foi selecionado!");
		}
		if(agenda.getHorario() == null || agenda.getHorario().trim().isEmpty() || agenda.getHorario()=="Selecione"){
			throw new Exception("O horario nao foi selecionado!");
		}
		if(agenda.getAno() == null || agenda.getAno().trim().isEmpty() || agenda.getAno() =="Selecione"){
			throw new Exception("O ano nao foi selecionado!");
		}
		if(agenda.getMes() == null || agenda.getMes().trim().isEmpty() || agenda.getMes() =="Selecione"){
			throw new Exception("O mes nao foi selecionado!");
		}
		if(agenda.getDia() == null || agenda.getDia().trim().isEmpty() || agenda.getDia() =="Selecione"){
			throw new Exception("O dia nao foi selecionado!");
		}
		else{
			
		}
	}
	
	/** 
	 * Esse metodo remove a agenda.
	 * */
	
	public void remover(int id){
		agendaDao.remover(id);
	}
	
	/** 
	 * Esse metodo lista as agendas.
	 * */
	
	public List<Agenda> listar() {
		return agendaDao.listar();
	}
	
	/** 
	 * Esse metodo busca a agenda pelo ID.
	 * */
	
	public Agenda buscarPorId(int id) {
		return agendaDao.buscarPorId(id);
	}
	
	/** 
	 * Esse metodo busca a agenda pela sala(id).
	 * */
	
	public List<Agenda> buscarPorSala(int id) {
		return agendaDao.buscarPorSala(id);
	}
	
	/** 
	 * Esse metodo busca a agenda pela sala(id) e pela Pessoa(id).
	 * */
	
	public List<Agenda> buscarPorSalaAndPessoa(int idSala, int idPessoa) {
		return agendaDao.buscarPorSalaAndPessoa(idSala, idPessoa);
	}

}
