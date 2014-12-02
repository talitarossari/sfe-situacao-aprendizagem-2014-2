package br.senai.sc.sfe.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the agenda database table.
 * 
 */
@Entity
@Table(name="agenda")
@NamedQuery(name="Agenda.findAll", query="SELECT a FROM Agenda a")
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idAgenda;
	private String ano;
	private String dia;
	private String horario;
	private String mes;
	private Pessoa pessoa;
	private Sala sala;

	public Agenda() {
		pessoa = new Pessoa();
		sala = new Sala();
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Integer getIdAgenda() {
		return this.idAgenda;
	}

	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}


	@Column(nullable=false, length=5)
	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}


	@Column(nullable=false, length=2)
	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}


	@Column(nullable=false, length=20)
	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}


	@Column(nullable=false, length=20)
	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}


	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idPessoa", nullable=true)
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	//bi-directional many-to-one association to Sala
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idSala", nullable=true)
	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}