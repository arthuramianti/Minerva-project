package model;

public class ProdutoModel {
	private int idProduto;
	private int fkIdArtista;
	private String pathImagemProduto;
	private String descricaoProduto;
	
	public ProdutoModel() {
		this.idProduto = 0;
		this.fkIdArtista = 0;
		this.pathImagemProduto = "";
		this.descricaoProduto = "";
	}
	
	public ProdutoModel(int fkIdArtista, String pathImagemProduto, String descricaoProduto) {
		this.fkIdArtista = fkIdArtista;
		this.pathImagemProduto = pathImagemProduto;
		this.descricaoProduto = descricaoProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getFkIdArtista() {
		return fkIdArtista;
	}

	public void setFkIdArtista(int fkIdArtista) {
		this.fkIdArtista = fkIdArtista;
	}

	public String getPathImagemProduto() {
		return pathImagemProduto;
	}

	public void setPathImagemProduto(String pathImagemProduto) {
		this.pathImagemProduto = pathImagemProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}


}
