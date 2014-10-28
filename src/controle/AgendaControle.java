package controle;

import javax.swing.JOptionPane;

import modelo.Agenda;

/**
 * @author talita_rossari
 *
 */
public class AgendaControle {
	
	Agenda agenda = new Agenda();
	
	/** 
	 * Esse metodo valida os campos(Vê se eles estao vazios) e salva ou altera o agendamento
	 * */
	
	public void salvar(Agenda agenda) throws Exception {
		
		if(agenda.getSala().getIdSala()<0){
			throw new Exception("A sala nao foi selecionada!");
		}
		if(agenda.getPessoa().getIdPessoa()<0){
			throw new Exception("O Colaborador nao foi selecionado!");
		}
		if(agenda.getHorario() == null || agenda.getHorario().trim().isEmpty()){
			throw new Exception("O horario nao foi selecionado!");
		}
		if(agenda.getAno() == null || agenda.getAno().trim().isEmpty()){
			throw new Exception("O ano nao foi selecionado!");
		}
		if(agenda.getMes() == null || agenda.getMes().trim().isEmpty()){
			throw new Exception("O mes nao foi selecionado!");
		}
		if(agenda.getDia() == null || agenda.getDia().trim().isEmpty()){
			throw new Exception("O dia nao foi selecionado!");
		}
		JOptionPane.showMessageDialog(null, "Teste Realizado com sucesso!");
	}

}
