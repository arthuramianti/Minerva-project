package model;

public class ArtistaModel {
	private String nomeArtista;
	private int idArtista;
	private int idadeArtista;
	private String emailArtista;
	private int fkIdCategoria;
	private String resumoDescricaoArtista;
	private String pathImages;
	private String senhaArtista;
	private String numeroArtista;
	private String cpfArtista;
	private String nomeCategoria;
	private String nomeSubcategoria;
	
	public ArtistaModel() {
		this.nomeArtista = "";
		this.idArtista = 0;
		this.idadeArtista = 0;
		this.emailArtista = "";
		this.fkIdCategoria = 0;
		this.resumoDescricaoArtista = "";
		this.pathImages = "";
		this.senhaArtista = "";
		this.numeroArtista = "";
		this.cpfArtista = "";
	}
	
	public ArtistaModel(String nomeArtista, String nomeCategoria, String nomeSubcategoria) {
		this.nomeArtista = nomeArtista;
		this.nomeCategoria = nomeCategoria;
		this.nomeSubcategoria = nomeSubcategoria;
	}
	
	public ArtistaModel(String nomeArtista, int idArtista, int idadeArtista, String emailArtista, String senhaArtista, int fkIdCategoria, String resumoDescricaoArtista, String pathImages, String numeroArtista, String cpfArtista) {
		this.nomeArtista = nomeArtista;
		this.idArtista = idArtista;
		this.idadeArtista = idadeArtista;
		this.emailArtista = emailArtista;
		this.fkIdCategoria = fkIdCategoria;
		this.resumoDescricaoArtista = resumoDescricaoArtista;
		this.pathImages = pathImages;
		this.senhaArtista = senhaArtista;
		this.numeroArtista = numeroArtista;
		this.cpfArtista = cpfArtista;
	}
	
	public ArtistaModel(String nomeArtista, int idadeArtista, String emailArtista, String senhaArtista, String resumoDescricaoArtista, String pathImages, String numeroArtista, String cpfArtista, int fkIdCategoria) {
		this.nomeArtista = nomeArtista;
		this.idArtista = 0;
		this.idadeArtista = idadeArtista;
		this.emailArtista = emailArtista;
		this.senhaArtista = senhaArtista;
		this.fkIdCategoria = fkIdCategoria;
		this.resumoDescricaoArtista = resumoDescricaoArtista;
		this.pathImages = pathImages;
		this.numeroArtista = numeroArtista;
		this.cpfArtista = cpfArtista;
	}
	
	public ArtistaModel(String nomeArtista, int idArtista, String resumoDescricaoArtista, String nomeCategoria, String pathImages) {
		this.nomeArtista = nomeArtista;
		this.idArtista = idArtista;
		this.resumoDescricaoArtista = resumoDescricaoArtista;
		this.pathImages = pathImages;
		this.nomeCategoria = nomeCategoria;
	}
	
	public ArtistaModel(int idArtista, String nomeArtista, String resumoDescricaoArtista, String nomeSubcategoria, String pathImages, int fkIdCategoria) {
		this.idArtista = idArtista;
		this.nomeArtista = nomeArtista;
		this.resumoDescricaoArtista = resumoDescricaoArtista;
		this.pathImages = pathImages;
		this.nomeSubcategoria = nomeSubcategoria;
	}
	
	public ArtistaModel(String nomeArtista, String resumoDescricaoArtista, String numeroArtista, String nomeCategoria) {
		this.nomeArtista = nomeArtista;
		this.resumoDescricaoArtista = resumoDescricaoArtista;
		this.nomeCategoria = nomeCategoria;
		this.numeroArtista = numeroArtista;
	}
	
	public ArtistaModel(String nomeArtista, int idArtista, String resumoDescricaoArtista, String nomeCategoria, String pathImagem, String nomeSubcategoria) {
		this.nomeArtista = nomeArtista;
		this.idArtista = idArtista;
		this.resumoDescricaoArtista = resumoDescricaoArtista;
		this.pathImages = pathImagem;
		this.nomeSubcategoria = nomeSubcategoria;
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

	public String getSenhaArtista() {
		return senhaArtista;
	}

	public void setSenhaArtista(String senhaArtista) {
		this.senhaArtista = senhaArtista;
	}

	public String getNumeroArtista() {
		return numeroArtista;
	}

	public void setNumeroArtista(String numeroArtista) {
		this.numeroArtista = numeroArtista;
	}

	public String getCpfArtista() {
		return cpfArtista;
	}

	public void setCpfArtista(String cpfArtista) {
		this.cpfArtista = cpfArtista;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getNomeSubcategoria() {
		return nomeSubcategoria;
	}

	public void setNomeSubcategoria(String nomeSubcategoria) {
		this.nomeSubcategoria = nomeSubcategoria;
	}
}
