package model;

public class SubcategoriaModel {
	private String nomeSubcategoria;
	private int idSubcategoria;
	private String nomeCategoria;
	private int fkIdCategoria;

	public SubcategoriaModel() {
		this.setNomeSubcategoria("");
		this.setIdSubcategoria(0);
		this.setNomeCategoria("");
		this.setFkIdCategoria(0);
	}
	
	public SubcategoriaModel(String nomeSubcategoria, String nomeCategoria, int idSubcategoria, int fkIdSubcategoria) {
		this.setNomeSubcategoria(nomeSubcategoria);
		this.setIdSubcategoria(idSubcategoria);
		this.setNomeCategoria(nomeCategoria);
		this.setFkIdCategoria(fkIdSubcategoria);
	}
	
	public SubcategoriaModel(String nomeSubcategoria) {
		this.setNomeSubcategoria(nomeSubcategoria);
		this.setIdSubcategoria(0);
		this.setNomeCategoria("");
		this.setFkIdCategoria(0);
	}

	public String getNomeSubcategoria() {
		return nomeSubcategoria;
	}

	public void setNomeSubcategoria(String nomeSubcategoria) {
		this.nomeSubcategoria = nomeSubcategoria;
	}

	public int getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(int idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public int getFkIdCategoria() {
		return fkIdCategoria;
	}

	public void setFkIdCategoria(int fkIdCategoria) {
		this.fkIdCategoria = fkIdCategoria;
	}
	
	@Override
	public String toString() {
		return "SubcategoriaModel [nomeSubcategoria=" + nomeSubcategoria + ", idSubcategoria=" + idSubcategoria
				+ ", nomeCategoria=" + nomeCategoria + "]";
	}
	
}
