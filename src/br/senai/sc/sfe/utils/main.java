package br.senai.sc.sfe.utils;

import br.senai.sc.sfe.dao.AgendaDao;
import br.senai.sc.sfe.dao.PessoaDao;
import br.senai.sc.sfe.dao.SalaDao;
import br.senai.sc.sfe.entity.Agenda;
import br.senai.sc.sfe.entity.Pessoa;
import br.senai.sc.sfe.entity.Sala;

public class main {
	
	public static void main(String[] args) {
		PessoaDao dao = new PessoaDao();
		SalaDao daoSala = new SalaDao();
		AgendaDao daoAgenda = new AgendaDao();
//		UsuarioDao uDao = new UsuarioDao();
		Pessoa pessoa = new Pessoa();
		Sala sala = new Sala();
		Agenda agenda = new Agenda();
//		Usuario usuario = new Usuario();
		pessoa.setIdPessoa(1);
		pessoa.setNome("Teste2");
		pessoa.setCpf("00000000000");
		pessoa.setAreaAtuacao("Area de atuacao");
		pessoa.setFuncao("Funcao");
		pessoa.getUsuario().setLogin("Talita_Rossari");
		pessoa.getUsuario().setSenha(2201);
 		dao.salvar(pessoa);
		
//		sala.setDescricao("B21");
//		sala.setLocalizacao("Andar 1 - Bloco B");
//		sala.setQuantidadeLugares("50");
//		sala.setTipo("Informatica");
		//daoSala.salvar(sala);
		
		//pessoa = dao.buscarPorId(10);
//		sala = daoSala.buscarPorId(5);
//		agenda.setAno("2013");
//		agenda.setDia("23");
//		agenda.setMes("Fevereiro");
//		agenda.setPessoa(pessoa);
//		agenda.setSala(sala);
//		agenda.setHorario("08h00 - 12h00");
//		daoAgenda.salvar(agenda);
		//daoAgenda.remover(1);
		
		//List<Agenda> agendas = new ArrayList<Agenda>();
		//agendas = daoAgenda.listar();
		
		//for (Agenda agenda2 : agendas) {
		//	System.out.println(agenda2.getPessoa().getNome());
		//}
		
		
	}

}
