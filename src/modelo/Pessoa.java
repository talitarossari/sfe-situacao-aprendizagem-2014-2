package modelo;

public class Pessoa {

	private int idPessoa;
	private String nome;
	private String cpf;
	private String funcao;
	private String areaAtuacao;
	
	public Pessoa() {
	}
	
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
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
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.funcao = funcao;
		this.areaAtuacao = areaAtuacao;
	}
	
	public String toString() {
		return this.nome + " - " + this.cpf + " - " + this.funcao;
	}
	
}
