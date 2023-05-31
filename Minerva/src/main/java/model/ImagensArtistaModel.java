package model;

public class ImagensArtistaModel {
	private int idImagem;
	private String imagem;
	private int fkIdArtista;
	private String descricaoProduto;
	
	
	public ImagensArtistaModel() {
		this.idImagem = 0;
		this.imagem = "";
		this.fkIdArtista = 0;
		this.descricaoProduto = "";
	}
	
	public ImagensArtistaModel(int idImagem, String imagem, int fkIdArtista) {
		this.idImagem = idImagem;
		this.imagem = imagem;
		this.fkIdArtista = fkIdArtista;
		this.descricaoProduto = "";
	}
	
	public ImagensArtistaModel(int idImagem, String imagem, int fkIdArtista, String descricaoProduto) {
		this.idImagem = idImagem;
		this.imagem = imagem;
		this.fkIdArtista = fkIdArtista;
		this.descricaoProduto = descricaoProduto;
	}
	
	public int getIdImagem() {
		return idImagem;
	}
	public void setIdImagem(int idImagem) {
		this.idImagem = idImagem;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getFkIdArtista() {
		return fkIdArtista;
	}
	public void setFkIdArtista(int fkIdArtista) {
		this.fkIdArtista = fkIdArtista;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
}
