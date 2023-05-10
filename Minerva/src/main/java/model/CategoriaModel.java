package model;

public class CategoriaModel {
	private int idCategoria;
	private String nomeCategoria;
	
	public CategoriaModel() {
		this.setIdCategoria(0);
		this.setNomeCategoria("");
	}
	
	public CategoriaModel(int idCategoria, String nomeCategoria) {
		this.setIdCategoria(idCategoria);
		this.setNomeCategoria(nomeCategoria);
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String toString() {
		return "CategoriaModel [idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria + "]";
	}
	
}
