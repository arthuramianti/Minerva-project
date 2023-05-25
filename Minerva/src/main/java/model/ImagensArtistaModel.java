package model;

public class ImagensArtistaModel {
	private int idImagem;
	private String imagem;
	private int fkIdArtista;
	
	
	public ImagensArtistaModel() {
		this.idImagem = 0;
		this.imagem = "";
		this.fkIdArtista = 0;
	}
	
	public ImagensArtistaModel(int idImagem, String imagem, int fkIdArtista) {
		this.idImagem = idImagem;
		this.imagem = imagem;
		this.fkIdArtista = fkIdArtista;
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
	
}
