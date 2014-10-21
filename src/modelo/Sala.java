package modelo;

public class Sala {
	
	private int idSala;
	private String localizacao;
	private String descricao;
	private String tipo;
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
	
	public int getIdSala() {
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
