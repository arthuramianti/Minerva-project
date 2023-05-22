package model;

public class ClienteModel {
	private String nomeCliente;
	private int idade;
	private String email;
	private int id;
	private String senha;
	private String numero;
	
	public ClienteModel() {
		this.nomeCliente = "";
		this.idade = 0;
		this.email = "";
		this.id = 0;
		this.numero = "";
		this.senha = "";
	}
	
	public ClienteModel(String nomeCliente, int idade, String email, String senha, String numero) {
		this.nomeCliente = nomeCliente;
		this.idade = idade;
		this.email = email;
		this.id = 0;
		this.numero = numero;
		this.senha = senha;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "Cliente [Nome do Cliente="+ this.getNomeCliente() +"Número=" + this.getNumero() + ", Idade=" + this.getIdade() + ", Email=" + this.getEmail() + ", ID="+this.getId() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
