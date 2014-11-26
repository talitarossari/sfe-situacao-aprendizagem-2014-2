package br.senai.sc.sfe.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idUsuarios;
	private String login;
	private int senha;
	private List<Pessoa> pessoas;

	public Usuario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Integer getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}


	@Column(nullable=false, length=45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	@Column(nullable=false)
	public int getSenha() {
		return this.senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}


	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="usuario")
	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setUsuario(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setUsuario(null);

		return pessoa;
	}

}