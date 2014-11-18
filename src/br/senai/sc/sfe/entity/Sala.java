package br.senai.sc.sfe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSala;
	@Column(unique = true, length = 30, nullable = false)
	private String localizacao;
	@Column(length = 30, nullable = false)
	private String descricao;
	@Column(length = 50, nullable = false)
	private String tipo;
	@Column(length = 50, nullable = false)
	private int quantidadeLugares;

	public Sala() {

	}

	public Sala(int idSala, String localizacao, String descricao, String tipo, int quantidadeLugares) {
		this.idSala = idSala;
		this.localizacao = localizacao;
		this.descricao = descricao;
		this.tipo = tipo;
		this.quantidadeLugares = quantidadeLugares;
	}

	public Integer getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidadeLugares() {
		return quantidadeLugares;
	}

	public void setQuantidadeLugares(int quantidadeLugares) {
		this.quantidadeLugares = quantidadeLugares;
	}

	
}
