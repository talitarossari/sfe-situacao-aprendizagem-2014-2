package br.senai.sc.sfe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;
	@Column(length = 100, nullable = false)
	private String nome;
	@Column(unique = true, length = 100, nullable = false)
	private String cpf;
	@Column(length=45, nullable=false)
	private String funcao;
	@Column(length=50, nullable=false)
	private String areaAtuacao;

	public Pessoa() {
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public Pessoa(int idPessoa, String nome, String cpf, String funcao,
			String areaAtuacao) {
		super();
		this.setIdPessoa(idPessoa);
		this.nome = nome;
		this.cpf = cpf;
		this.funcao = funcao;
		this.areaAtuacao = areaAtuacao;
	}

	public String toString() {
		return this.nome + " - " + this.cpf + " - " + this.funcao;
	}

}
