package model;

public class ArtistaModel {
	private String nomeArtista;
	private int idArtista;
	private int idadeArtista;
	private String emailArtista;
	private int fkIdCategoria;
	private String resumoDescricaoArtista;
	private String pathImages;
	
	public ArtistaModel() {
		this.nomeArtista = "";
		this.idArtista = 0;
		this.idadeArtista = 0;
		this.emailArtista = "";
		this.fkIdCategoria = 0;
		this.resumoDescricaoArtista = "";
		this.pathImages = "";
	}
	
	public ArtistaModel(String nomeArtista, int idArtista, int idadeArtista, String emailArtista, int fkIdCategoria, String resumoDescricaoArtista, String pathImages) {
		this.nomeArtista = nomeArtista;
		this.idArtista = idArtista;
		this.idadeArtista = idadeArtista;
		this.emailArtista = emailArtista;
		this.fkIdCategoria = fkIdCategoria;
		this.resumoDescricaoArtista = resumoDescricaoArtista;
		this.pathImages = pathImages;
	}
	
	public String getNomeArtista() {
		return nomeArtista;
	}
	
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	
	public int getIdArtista() {
		return idArtista;
	}
	
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	
	public int getIdadeArtista() {
		return idadeArtista;
	}
	
	public void setIdadeArtista(int idadeArtista) {
		this.idadeArtista = idadeArtista;
	}
	
	public String getEmailArtista() {
		return emailArtista;
	}
	
	public void setEmailArtista(String emailArtista) {
		this.emailArtista = emailArtista;
	}
	
	public int getFkIdCategoria() {
		return fkIdCategoria;
	}
	
	public void setFkIdCategoria(int fkIdCategoria) {
		this.fkIdCategoria = fkIdCategoria;
	}
	
	public String getResumoDescricaoArtista() {
		return resumoDescricaoArtista;
	}
	
	public void setResumoDescricaoArtista(String resumoDescricaoArtista) {
		this.resumoDescricaoArtista = resumoDescricaoArtista;
	}
	
	public String toString() {
		return "ArtistaModel [nomeArtista=" + nomeArtista + ", idArtista=" + idArtista + ", idadeArtista="
				+ idadeArtista + ", emailArtista=" + emailArtista + ", fkIdCategoria=" + fkIdCategoria
				+ ", resumoDescricaoArtista=" + resumoDescricaoArtista + ", fk_id_artista=" + pathImages + "]";
	}

	public String getPathImages() {
		return pathImages;
	}

	public void setPathImages(String pathImages) {
		this.pathImages = pathImages;
	}
}
