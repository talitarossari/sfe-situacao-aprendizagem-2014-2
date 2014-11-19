package br.senai.sc.sfe.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the agenda database table.
 * 
 */
@Entity
@Table(name = "agenda")
@NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
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
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	public Integer getIdAgenda() {
		return this.idAgenda;
	}

	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}

	@Column(nullable = false, length = 5)
	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Column(nullable = false, length = 2)
	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	@Column(nullable = false, length = 20)
	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Column(nullable = false, length = 20)
	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	// bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name = "idPessoa", nullable = false)
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	// bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name = "idSala", nullable = false)
	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}