package model;

public class Cliente {
	private String nomeCliente;
	private int idade;
	private String email;
	private int id;
	
	public Cliente() {
		this.nomeCliente = "";
		this.idade = 0;
		this.email = "";
		this.id = 0;
	}
	
	public Cliente(String nomeCliente, int idade, String email) {
		this.nomeCliente = nomeCliente;
		this.idade = idade;
		this.email = email;
		this.id = 0;
	}
	
	public Cliente(String nomeCliente, int id, int idade, String email) {
		this.nomeCliente = nomeCliente;
		this.idade = idade;
		this.email = email;
		this.id = id;
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
		return "Cliente [Nome do Cliente="+ this.getNomeCliente() +", Idade=" + this.getIdade() + ", Email=" + this.getEmail() + ", ID="+this.getId() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
