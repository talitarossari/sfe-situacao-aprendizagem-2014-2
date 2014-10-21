package modelo;

public class Agenda {

	private Sala sala;
	private Pessoa pessoa;
	private String horario;
	private String dia;
	private String mes;
	private String ano;
	private String testeSeFoi;

	public Agenda(Sala sala, Pessoa pessoa, String horario, String dia,
			String mes, String ano) {
		super();
		this.sala = sala;
		this.pessoa = pessoa;
		this.horario = horario;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public Agenda() {
		super();
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

}
