package br.com.ks.saques.DTO;

public class ClienteDTO {

	private ClienteDTO() {
		super();
	}

	public ClienteDTO(Long id, String usuario, String nome, Double valor) {
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.valor = valor;
	}

	public ClienteDTO(String retornoNegativa) {
		super();
		this.retornoNegativa = retornoNegativa;
	}

	private Long id;

	private String nome;

	private String usuario;

	private Double valor;

	private String retornoNegativa;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRetornoNegativa() {
		return retornoNegativa;
	}

	public void setRetornoNegativa(String retornoNegativa) {
		this.retornoNegativa = retornoNegativa;
	}

}
