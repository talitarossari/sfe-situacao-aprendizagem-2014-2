package br.senai.sc.sfe.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */
@Entity
@Table(name="sala")
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idSala;
	private String descricao;
	private String localizacao;
	private String quantidadeLugares;
	private String tipo;
	private List<Agenda> agendas;

	public Sala() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Integer getIdSala() {
		return this.idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}


	@Column(nullable=false, length=30)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Column(nullable=false, length=30)
	public String getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	@Column(nullable=false, length=50)
	public String getQuantidadeLugares() {
		return this.quantidadeLugares;
	}

	public void setQuantidadeLugares(String quantidadeLugares) {
		this.quantidadeLugares = quantidadeLugares;
	}


	@Column(nullable=false, length=50)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	//bi-directional many-to-one association to Agenda
	@OneToMany(mappedBy="sala")
	public List<Agenda> getAgendas() {
		return this.agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public Agenda addAgenda(Agenda agenda) {
		getAgendas().add(agenda);
		agenda.setSala(this);

		return agenda;
	}

	public Agenda removeAgenda(Agenda agenda) {
		getAgendas().remove(agenda);
		agenda.setSala(null);

		return agenda;
	}
	
	public String toString(){
		return getLocalizacao() + " - " + getDescricao();
	}

}