package br.senai.sc.sfe.entity;

public class Usuario {

	private int idUsuario;
	private String login;
	private int senha;
	private Pessoa pessoa;
	
	public Usuario() {	
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}

	public Usuario(int idUsuario, String login, int senha, Pessoa pessoa) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.pessoa = pessoa;
	}
		
}
