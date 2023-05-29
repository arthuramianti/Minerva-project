package util;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.ArtistaDao;
import dao.CategoriaDao;
import dao.ProdutoArtistaDao;
import model.ArtistaModel;
import model.CategoriaModel;
import model.ImagensArtistaModel;

public class Util {
	
	public String render(String nomeArquivo) {
		String page = "";
		try {
			Scanner entrada = new Scanner(new File("src/main/resources/Front-end/" + nomeArquivo));
			while (entrada.hasNext()) {
				page += (entrada.nextLine() + "\n");
			}
			entrada.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return page;
	}
	
	public String renderHeader() {
		String header = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt-br\">\r\n"
				+ "<head>\r\n"
				+ "  <meta charset=\"UTF-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "  <title>Minerva</title>\r\n"
				+ "  <meta name=\"description\" content=\"Página de busca de artistas independentes\">\r\n"
				+ "  <link rel=\"canonical\" href=\"https://www.minerva.com\">\r\n"
				+ "  <meta name=\"robots\" content=\"index, follow\">\r\n"
				+ "  <meta name=\"keywords\" content=\"musica, arte, artistas independentes\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"../style\\style.css\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"../style\\arthur.css\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "	<header class=\"navbar navbar-expand-lg navbar-light cabecalho-principal\">\r\n"
				+ "  	<div class=\"container cabecalho-container\">\r\n"
				+ "  	<div class=\"row\">\r\n"
				+ "  		<div class=\"col-3\">\r\n"
				+ "  		<div class=\"titulo-div centralizar-div\">\r\n"
				+ "    		<a class=\"navbar-brand titulo-principal\" href=\"http://localhost:6789\"><h1> Minerva </h1></a>\r\n"
				+ "    		<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
				+ "      			<span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "    		</button>\r\n"
				+ "    	</div>\r\n"
				+ "    	</div>\r\n"
				+ "    	<div class=\"col-5\">\r\n"
				+ "    	</div>\r\n"
				+ "		<div class=\"col-4\">\r\n"
				+ "    		<div class=\"collapse navbar-collapse centralizar-div\" id=\"navbarNav\">\r\n"
				+ "      			<ul class=\"navbar-nav ms-auto\">\r\n"
				+ "        			<li class=\"nav-item\">\r\n"
				+ "          				<a class=\"nav-link\" href=\"http://localhost:6789\">Home</a>\r\n"
				+ "        			</li>\r\n"
				+ "      				<li class=\"nav-item\">\r\n"
				+ "          				<a class=\"nav-link\" href=\"http://localhost:6789\">Contatos</a>\r\n"
				+ "        			</li>\r\n"
				+ "        			<li class=\"nav-item\">\r\n"
				+ "          				<a class=\"nav-link\" href=\"http://localhost:6789/categorias\">Categorias</a>\r\n"
				+ "        			</li>\r\n"
				+ "        			<li class=\"nav-item\">\r\n"
				+ "                        <a class=\"btn btn-outline-light\" href=\"http://localhost:6789/cadastroUsuario\">Cadastre-se</a>\r\n"
				+ "        			</li>\r\n"
				+ "      			</ul>\r\n"
				+ "    		</div>\r\n"
				+ "    	</div>\r\n"
				+ "    </div>\r\n"
				+ "    </div>\r\n"
				+ "  </header>\r\n";
		
		return header;
	}
	
	public String renderIndex() throws SQLException {
		String page = this.renderHeader();
		
		page	+= "	<div class=\"container-busca\">\r\n"
				+ "		<div class=\"background-busca\">\r\n"
				+ "			<img alt=\"\" src=\"../images/abstract-colorful-digital-art-wallpaper-1920x1080_48.jpg\">\r\n"
				+ "		</div>	   \r\n"
				+ "		<div class=\"div-busca\">\r\n"
				+ "			<div class=\"content-div-busca\">\r\n"
				+ "				<h1>Encontre o artista certo para você.</h1>\r\n"
				+ "				<h6>São vários colaboradores de diferentes áreas da arte para lhe atender.</h6>\r\n"
				+ "				<div class=\"busca\">\r\n"
				+ "					<form class=\"d-flex my-2 my-lg-0\" action=\"http://localhost:6789/buscaArtista\"  method=\"post\" style=\"min-width: 600px\">\r\n"
				+ "						<input class=\"form-control me-2\" type=\"search\" name=\"chave_busca\" id=\"chave_busca\" placeholder=\"Pesquisar artistas\" aria-label=\"Pesquisar\">\r\n"
				+ "						<button class=\"btn btn-success\" type=\"submit\">Buscar</button>\r\n"
				+ "					</form>				\r\n"
				+ "				</div>\r\n"
				+ "			</div>\r\n"
				+ "		</div>				\r\n"
				+ "	</div>\r\n"
				+ " \r\n"
				+ "    <main>\r\n"
				+ "    <section class=\"s-01\">\r\n"
				+ "   	<div class=\"limite-site\">\r\n"
				+ "   		<h2 class=\"h-principal\">Artistas principais</h2>";
		
		page += renderSectionOneIndex();
		page += renderSectionTwoIndex();
		page += "</main>";
		page += renderFooter();
		
		return page;
	}
	
	public String renderSectionOneIndex() {
		String sectionOne = "";
		ArtistaDao conexao = new ArtistaDao();
		List<ArtistaModel> artistas = conexao.getArtistas("id_artista");
		
		int auxiliar = 0;
		
		for(ArtistaModel a: artistas) {
			if (auxiliar == 0) {
				sectionOne += "<div class=\"row linha_artistas_home\">\r\n";
			}
			
			sectionOne += "   				<div class=\"col col-tiny-12 col-small-6 col-3 col-medium-3\">\r\n"
					+ "   					<div class=\"card\">\r\n"
					+ "  						<img src=" + a.getPathImages() + " class=\"card-img-top\" alt=\"...\">			\r\n"
					+ " 						<div class=\"card-body\">\r\n"
					+ " 					    	<h5 class=\"card-title\">" + a.getNomeArtista() + "</h5>\r\n"
					+ "    						<p class=\"card-text\">" + a.getResumoDescricaoArtista() + "</p>\r\n"
					+ "    						<a href=\"artista/" + a.getIdArtista() + "\"><button type=\"button\" class=\"btn btn-outline-primary\">Perfil</button></a>\r\n"
					+ "				    	</div>\r\n"
					+ "					 </div>\r\n"
					+ "   				</div>";
			
			auxiliar++;
			
			if(auxiliar == 4) {
				sectionOne += "</div>";
				auxiliar = 0;
			}
		}
		
		sectionOne += "</div>\r\n"
				+ "   </section> ";
		
		return sectionOne;
	}
	
	public String renderSectionTwoIndex() {
		String sectionTwo = "";
		CategoriaDao conexao = new CategoriaDao();
		List<CategoriaModel> categorias = conexao.getCategorias("id_categoria");
		
		sectionTwo += "	<div class=\"secao_categorias\">\r\n"
				+ "		<div class=\"limite-site\">\r\n"
				+ "			<h2 class=\"h-principal\">Categorias</h2>";
		
		int auxiliar = 0;
		
		for(CategoriaModel c: categorias) {
			if(auxiliar == 0) {
				sectionTwo += "<div class=\"row linha_categorias_home\">";
			}
			
			sectionTwo += "<div class=\"col col-tiny-12 col-small-6 col-3 col-medium-3\">\r\n"
					+ "   					<div class=\"card\">\r\n"
					+ "  						<div class=\"img"+c.getIdCategoria()+"_categoria\"></div>\r\n"
					+ " 						<div class=\"card-body\">\r\n"
					+ " 					    	<h5 class=\"card-title\">" + c.getNomeCategoria() + "</h5>    						\r\n"
					+ "    						<a href=\"categorias/"+c.getIdCategoria() +"\"><button type=\"button\" class=\"btn btn-outline-primary\">Mais</button></a>\r\n"
					+ "				    	</div>\r\n"
					+ "					</div>\r\n"
					+ "   				</div>";
			
			auxiliar++;
			
			if(auxiliar == 4) {
				sectionTwo += "</div>";
				auxiliar = 0;
			}
		}
		
		sectionTwo += "</div>\r\n"
				+ "	</div>";
		
		
		return sectionTwo;
	}
	
	public String renderFooter() {
		String footer = "<footer class=\"footer-principal\">\r\n"
				+ "    	<div class=\"site-footer\">\r\n"
				+ "    		<div class=\"main-footer\">\r\n"
				+ "	    		<a class=\"navbar-brand titulo-principal\" href=\"#\"><h1> Minerva </h1></a>\r\n"
				+ "	    		<div class=\"socials\">\r\n"
				+ "	    		<a href=\"...\">\r\n"
				+ "	    			<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-twitter\" viewBox=\"0 0 16 16\">\r\n"
				+ "						<path d=\"M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z\"/>\r\n"
				+ "					</svg>\r\n"
				+ "	    		</a>\r\n"
				+ "	    		<a href=\"...\">\r\n"
				+ "					<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-instagram\" viewBox=\"0 0 16 16\">\r\n"
				+ "						<path d=\"M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z\"/>\r\n"
				+ "					</svg>\r\n"
				+ "				</a>\r\n"
				+ "				<a href=\"...\">\r\n"
				+ "					<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-facebook\" viewBox=\"0 0 16 16\">\r\n"
				+ "						<path d=\"M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z\"/>\r\n"
				+ "					</svg>\r\n"
				+ "				</a>\r\n"
				+ "				<a href=\"...\">\r\n"
				+ "					<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-whatsapp\" viewBox=\"0 0 16 16\">\r\n"
				+ "						<path d=\"M13.601 2.326A7.854 7.854 0 0 0 7.994 0C3.627 0 .068 3.558.064 7.926c0 1.399.366 2.76 1.057 3.965L0 16l4.204-1.102a7.933 7.933 0 0 0 3.79.965h.004c4.368 0 7.926-3.558 7.93-7.93A7.898 7.898 0 0 0 13.6 2.326zM7.994 14.521a6.573 6.573 0 0 1-3.356-.92l-.24-.144-2.494.654.666-2.433-.156-.251a6.56 6.56 0 0 1-1.007-3.505c0-3.626 2.957-6.584 6.591-6.584a6.56 6.56 0 0 1 4.66 1.931 6.557 6.557 0 0 1 1.928 4.66c-.004 3.639-2.961 6.592-6.592 6.592zm3.615-4.934c-.197-.099-1.17-.578-1.353-.646-.182-.065-.315-.099-.445.099-.133.197-.513.646-.627.775-.114.133-.232.148-.43.05-.197-.1-.836-.308-1.592-.985-.59-.525-.985-1.175-1.103-1.372-.114-.198-.011-.304.088-.403.087-.088.197-.232.296-.346.1-.114.133-.198.198-.33.065-.134.034-.248-.015-.347-.05-.099-.445-1.076-.612-1.47-.16-.389-.323-.335-.445-.34-.114-.007-.247-.007-.38-.007a.729.729 0 0 0-.529.247c-.182.198-.691.677-.691 1.654 0 .977.71 1.916.81 2.049.098.133 1.394 2.132 3.383 2.992.47.205.84.326 1.129.418.475.152.904.129 1.246.08.38-.058 1.171-.48 1.338-.943.164-.464.164-.86.114-.943-.049-.084-.182-.133-.38-.232z\"/>\r\n"
				+ "					</svg>\r\n"
				+ "				</a>\r\n"
				+ "	    		</div>\r\n"
				+ "    		</div>\r\n"
				+ "    		<div class=\"links-footer\">		\r\n"
				+ "				<div class=\"group-footer\">\r\n"
				+ "					<span class=\"titulo-group-footer\">Descobrir</span>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Escolha do Editor</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Coleções selecionadas</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Imagens populares</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Vídeos populares</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Música Popular</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Pesquisas populares</a>\r\n"
				+ "				</div>\r\n"
				+ "				<div class=\"group-footer\">\r\n"
				+ "					<span class=\"titulo-group-footer\">Comunidade</span>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Blog</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Fórum</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">criadores</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Câmeras</a>\r\n"
				+ "				</div>\r\n"
				+ "				<div class=\"group-footer\">\r\n"
				+ "					<span class=\"titulo-group-footer\">Sobre</span>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Sobre nós</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">FAQ</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Resumo da licença</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Termos de Serviço</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Política de Privacidade</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">Política de Cookies</a>\r\n"
				+ "					<a class=\"a-footer\" href=\"...\">API</a>\r\n"
				+ "				</div>\r\n"
				+ "			</div>\r\n"
				+ "    	</div>	\r\n"
				+ "	    <p style=\"color: white\">Copyright © 2023 - Minerva</p>\r\n"
				+ "    </footer>\r\n"
				+ "</body>"
				+ "</html>";
		
		return footer;
	}
	
	public String renderCategorias() {
		String html = "";
		CategoriaDao conexao = new CategoriaDao();
		List<CategoriaModel> categorias = conexao.getCategorias("id_categoria");
		
		html += this.renderHeader();
		
		html +=	 "	<div class=\"secao_categorias\">\r\n"
				+ "		<div class=\"limite-site\">\r\n"
				+ "			<h2 class=\"h-principal\" style=\"margin-top:100px;\">Categorias</h2>";
		
		int auxiliar = 0;
		
		for(CategoriaModel c: categorias) {
			if(auxiliar == 0) {
				html += "<div class=\"row linha_categorias_home\">";
			}
			
			html += "<div class=\"col col-tiny-12 col-small-6 col-3 col-medium-3\">\r\n"
					+ "   					<div class=\"card\">\r\n"
					+ "  						<div class=\"img"+c.getIdCategoria()+"_categoria\"></div>\r\n"
					+ " 						<div class=\"card-body\">\r\n"
					+ " 					    	<h5 class=\"card-title\">" + c.getNomeCategoria() + "</h5>    						\r\n"
					+ "    						<a href=\"categorias/"+c.getIdCategoria() + "\"><button type=\"button\" class=\"btn btn-outline-primary\">Mais</button></a>\r\n"
					+ "				    	</div>\r\n"
					+ "					</div>\r\n"
					+ "   				</div>";
			
			auxiliar++;
			
			if(auxiliar == 4) {
				html += "</div>";
				auxiliar = 0;
			}
		}
		
		html += "</div>\r\n"
				+ "	</div>";
		
		
		return html;
	}
	
	public String renderPerfilArtistaCompleto(String idArtista) throws NumberFormatException, SQLException {
		ArtistaDao conexao = new ArtistaDao();
		ArtistaModel artista = conexao.get(Integer.parseInt(idArtista));
		List<ImagensArtistaModel> imagens = conexao.getImagensDoArtistaByIdArtista(Integer.parseInt(idArtista));
		
		String paginaPerfil = this.renderHeader();
		
		paginaPerfil += "<div class=\"secao\">\r\n"
				+ "		<div class=\"limite-site\">";
		
		paginaPerfil += "<div class=\"row\">\r\n"
				+ "				<div class=\"col-3\"></div>\r\n"
				+ "				<div class=\"col-6\">\r\n"
				+ "					<div class=\"row\">\r\n"
				+ "						<div class=\"col-6\">\r\n"
				+ "							<div class=\"bloco_foto_perfil\">\r\n"
				+ "								<div class=\"circulo_foto_perfil\">\r\n"
				+ "									<div class=\"foto_perfil\">\r\n"
				+ "										<img alt=\"\" class=\"img-fluid imagem_perfil\" src=\"../images/eu.jpg\">\r\n"
				+ "									</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "						<div class=\"col-6\">\r\n"
				+ "							<div class=\"row bloco_nome_artista\" style=\"margin-bottom: 3px;\">\r\n"
				+ "								<div class=\"col-12\"><h4>"+artista.getNomeArtista()+"</h4></div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"row bloco_categoria_artista\">\r\n"
				+ "								<div class=\"col-4\"><div class=\"tag_cat\">"+artista.getNomeCategoria()+"</div></div>\r\n"
				+ "								<div class=\"col-4\"></div>\r\n"
				+ "								<div class=\"col-4\"></div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"row bloco_status_artista\">\r\n"
				+ "								<div class=\"col-4\">70 posts</div>\r\n"
				+ "								<div class=\"col-6\">100 seguidores</div>\r\n"
				+ "								<div class=\"col-2\"></div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"row bloco_sobre_artista\">\r\n"
				+ "								<div class=\"col-12\" style=\"text-align: justify;\">"+artista.getResumoDescricaoArtista()+"</div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"row bloco_contatos_artista\">\r\n"
				+ "								<div class=\"col-12\">\r\n"
				+ "									<a href=\"\" style=\"text-decoration: none;color: inherit;\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-phone\" viewBox=\"0 0 16 16\"><path d=\"M11 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h6zM5 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H5z\"/><path d=\"M8 14a1 1 0 1 0 0-2 1 1 0 0 0 0 2z\"/>\r\n"
				+ "											</svg>"+artista.getNumeroArtista()+"</a>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"row bloco_cadastro_produto\">\r\n"
				+ "								<div class=\"col-12\">\r\n"
				+ "									\r\n"
				+ "									<button type=\"button\" class=\"btn btn-outline-primary\" id =\"btn-abre-modal\" data-bs-toggle=\"modal\" data-bs-target=\"#staticBackdrop\"\">Cadastrar novo produto</button>\r\n"
				+ "									<div class=\"modal fade\" id=\"staticBackdrop\"\r\n"
				+ "										data-bs-backdrop=\"static\" data-bs-keyboard=\"true\" tabindex=\"-1\"\r\n"
				+ "										aria-labelledby=\"staticBackdropLabel\" aria-hidden=\"true\">\r\n"
				+ "										<div class=\"modal-dialog\">\r\n"
				+ "											<div class=\"modal-content\">\r\n"
				+ "												<div class=\"modal-header\">\r\n"
				+ "													<h1 class=\"modal-title fs-5\" id=\"staticBackdropLabel\">Cadastre um novo produto</h1>\r\n"
				+ "													<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"\r\n"
				+ "														aria-label=\"Close\"></button>\r\n"
				+ "													</div>\r\n"
				+ "													<form action=\"/cadastroProduto\" name=\"Formulario de cadastro de produto\" method=\"post\">\r\n"
				+ "													<div class=\"modal-body\">\r\n"
				+ "														<div class=\"mb-3\">\r\n"
				+ "															<label style=\"font-weight: 700;\" class=\"form-label\" for=\"titulo_produto\">Título</label>\r\n"
				+ "															<input type=\"text\" class=\"form-control\" id=\"titulo_produto\" name=\"titulo_produto\" aria-describedby=\"emailHelp\">\r\n"
				+ "														</div>\r\n"
				+ "														<div class=\"mb-3\">\r\n"
				+ "															<label style=\"font-weight: 700;\" class=\"form-label\" for=\"img_label_produto\">Imagem:</label>\r\n"
				+ "															<label class = \"imagem_produto\" for=\"arquivo\">Enviar arquivo</label>\r\n"
				+ "															<input type=\"file\" name=\"arquivoImagem\" id=\"arquivo\">\r\n"
				+ "														</div>\r\n"
				+ "														<div class=\"mb-3\">\r\n"
				+ "															<label style=\"font-weight: 700;\" class=\"form-label\" for=\"descricao_produto\">Descrição:</label>\r\n"
				+ "															<textarea class=\"form-control\" id=\"descricao_cliente\" name=\"descricao_produto\" rows=\"4\"></textarea>\r\n"
				+ "														</div>\r\n"
				+ "													</div>\r\n"
				+ "													<div class=\"modal-footer\">\r\n"
				+ "														<button type=\"submit\" class=\"btn btn-primary\" data-bs-dismiss=\"modal\" style=\"margin-top: 10px;\">Submit</button>\r\n"
				+ "													</div>\r\n"
				+ "                                                 </form>\r\n"	
				+ "											</div>\r\n"
				+ "										</div>\r\n"
				+ "									</div>		\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "					</div>\r\n"
				+ "				</div>\r\n"
				+ "				<div class=\"col-3\"></div>\r\n"
				+ "			</div>";
		
		int auxiliar = 0;
		for(ImagensArtistaModel i: imagens) {
			if(auxiliar == 0) {
				paginaPerfil += "<div class=\"galeria_fotos_perfil row\">\r\n";
			}
			
			paginaPerfil += "				<div class=\"col-4\">\r\n"
					+ "<a href=http://localhost:6789/produto/"+i.getIdImagem()+">"
			+ "					<div class=\"bloco_imagens_artista\">\r\n"
			+ "						<img src=" + i.getImagem() + " class=\"img-fluid bloco_imagens_artista\" alt=\"...\">\r\n"
			+ "					</div>\r\n"
			+ " 			</a>	"
			+ "				</div>\r\n";
			
			if(auxiliar == 3) {
				paginaPerfil += "			</div>";
				auxiliar = 0;
			}
			auxiliar++;
		}
		
		paginaPerfil += "</div>\r\n"
				+ "	</div>"
		+ "	</div>";
		
		paginaPerfil += this.renderFooter();
		
		return paginaPerfil;
	}
	
	public String renderProdutoArtistaCompleto(String id) throws NumberFormatException, SQLException {
		String paginaProduto = this.renderHeader();
		ArtistaDao conexao = new ArtistaDao();
		ProdutoArtistaDao conexaoProduto = new ProdutoArtistaDao();
		ImagensArtistaModel produto = conexaoProduto.get(Integer.parseInt(id));
		ArtistaModel artista = conexao.getInfoArtistaPaginaProduto(produto.getFkIdArtista());
		
		paginaProduto += "<section class=\"s-produtoArtista\">\r\n"
				+ "      <div class=\"limite-site\">\r\n"
				+ "		  <div class=\"row\">\r\n"
				+ "			  <div class=\"img-produto col col-9\">\r\n"
				+ "				  <img src="+produto.getImagem()+" width=\"830\">\r\n"
				+ "			  </div>\r\n"
				+ "			  <div class=\"produto-artista-content col col-3\">\r\n"
				+ "			  	  <div class=\"row\">\r\n"
				+ "			  	  	  <div class=\"col col-2\">\r\n"
				+ "			  	  	  	  <div class=\"foto-artista-pA\">\r\n"
				+ "				  	  	  	  <img src=\"..\\images\\eu.jpg\">\r\n"
				+ "			  	  	  	  </div>\r\n"
				+ "			  	  	  </div>\r\n"
				+ "			  	  	  <div class=\"col col-10\">\r\n"
				+ "					  	  <a class=\"nome-tag-produto\">"+artista.getNomeArtista()+"</a>\r\n"
				+ "					  	  <div class=\"tag_categoria\">"+artista.getNomeCategoria()+"</div>\r\n"
				+ "			  	  	  </div>\r\n"
				+ "			  	  </div>\r\n"
				+ "			  	  <div class=\"like_buttons\">\r\n"
				+ "					<button style=\"margin: 7px;\" type=\"button\" class=\"btn btn-outline-primary btn-sm\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-heart-fill\" viewBox=\"0 0 16 16\">\r\n"
				+ "  						<path fill-rule=\"evenodd\" d=\"M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z\"/></svg>\r\n"
				+ "						Curtir\r\n"
				+ "					</button>\r\n"
				+ "					<button style=\"margin: 7px;\" type=\"button\" class=\"btn btn-outline-primary btn-sm\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-share\" viewBox=\"0 0 16 16\">\r\n"
				+ "  						<path d=\"M13.5 1a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.499 2.499 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5zm-8.5 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm11 5.5a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3z\"/></svg>\r\n"
				+ "						Compartilhar\r\n"
				+ "					</button>\r\n"
				+ "					<button style=\"margin: 7px;\" type=\"button\" class=\"btn btn-outline-primary btn-sm\"><svg style=\"margin-bottom: 5px;\" xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-star-fill\" viewBox=\"0 0 16 16\">\r\n"
				+ "  						<path d=\"M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z\"/></svg>\r\n"
				+ "						Adicionar aos favoritos\r\n"
				+ "					</button>\r\n"
				+ "				</div>\r\n"
				+ "				<div class=\"bloco_texto_foto\">\r\n"
				+ "					<div style=\"margin-top:4px;font-size:14px\">\r\n"
				+ "						"+produto.getDescricaoProduto()+"\r\n"
				+ "					</div>\r\n"
				+ "				</div>\r\n"
				+ "				<div class=\"bloco_categorias\">\r\n"
				+ "					<p style=\"font-weight: 400;\">Categorias do artista</p>\r\n"
				+ "					<button type=\"button\" class=\"btn btn-primary btn-sm\">"+artista.getNomeCategoria()+"</button>\r\n"
				+ "					<button type=\"button\" class=\"btn btn-primary btn-sm\">"+artista.getNomeSubcategoria()+"</button>\r\n"
				+ "				</div>\r\n"
				+ "				<div class=\"bloco_botao_contato\">\r\n"
				+ "					<p style=\"font-weight: 400;\">Entre em contato com o artista via WPP</p>\r\n"
				+ "					<button type=\"button\" class=\"btn btn-success\">Contato</button>\r\n"
				+ "				</div>\r\n"
				+ "			  </div>\r\n"
				+ "		  </div>\r\n"
				+ "      </div>\r\n"
				+ "  </section>";
		
		paginaProduto += this.renderFooter();
		
		return paginaProduto;
	}
	
	public String toMD5(String senha) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(), 0, senha.length());
		String md5 =  new BigInteger(1, m.digest()).toString(16);

		return md5;
	}
}
