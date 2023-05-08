package util;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.ArtistaDao;
import dao.CategoriaDao;
import model.ArtistaModel;
import model.CategoriaModel;

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
	
	public String renderIndex() throws SQLException {
		String page = "<!DOCTYPE html>\r\n"
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
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "	<header class=\"navbar navbar-expand-lg navbar-light cabecalho-principal\">\r\n"
				+ "  	<div class=\"container cabecalho-container\">\r\n"
				+ "  	<div class=\"row\">\r\n"
				+ "  		<div class=\"col-3\">\r\n"
				+ "  		<div class=\"titulo-div centralizar-div\">\r\n"
				+ "    		<a class=\"navbar-brand titulo-principal\" href=\"#\"><h1> Minerva </h1></a>\r\n"
				+ "    		<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
				+ "      			<span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "    		</button>\r\n"
				+ "    	</div>\r\n"
				+ "    	</div>\r\n"
				+ "    	<div class=\"col-6\">\r\n"
				+ "    	</div>\r\n"
				+ "		<div class=\"col-3\">\r\n"
				+ "    		<div class=\"collapse navbar-collapse centralizar-div\" id=\"navbarNav\">\r\n"
				+ "      			<ul class=\"navbar-nav ms-auto\">\r\n"
				+ "      				<li class=\"nav-item\">\r\n"
				+ "          				<a class=\"nav-link\" href=\"http://localhost:6789/cadastroUsuario\" href=\"#\">Cadastre-se</a>\r\n"
				+ "        			</li>\r\n"
				+ "        			<li class=\"nav-item\">\r\n"
				+ "          				<a class=\"nav-link\" href=\"#\">Home</a>\r\n"
				+ "        			</li>\r\n"
				+ "        			<li class=\"nav-item\">\r\n"
				+ "          				<a class=\"nav-link\" href=\"#\">Sobre</a>\r\n"
				+ "        			</li>\r\n"
				+ "        			<li class=\"nav-item\">\r\n"
				+ "          				<button type=\"button\" class=\"btn btn-outline-light\">Contatos</button>\r\n"
				+ "        			</li>\r\n"
				+ "      			</ul>\r\n"
				+ "    		</div>\r\n"
				+ "    	</div>\r\n"
				+ "    </div>\r\n"
				+ "    </div>\r\n"
				+ "  </header>\r\n"
				+ "	<div class=\"container-busca\">\r\n"
				+ "		<div class=\"background-busca\">\r\n"
				+ "			<img alt=\"\" src=\"../images/abstract-colorful-digital-art-wallpaper-1920x1080_48.jpg\">\r\n"
				+ "		</div>	   \r\n"
				+ "		<div class=\"div-busca\">\r\n"
				+ "			<div class=\"content-div-busca\">\r\n"
				+ "				<h1>Encontre o artista certo para você.</h1>\r\n"
				+ "				<h6>São vários colaboradores de diferentes áreas da arte para lhe atender.</h6>\r\n"
				+ "				<div class=\"busca\">\r\n"
				+ "					<form class=\"d-flex my-2 my-lg-0\" style=\"min-width: 600px\">\r\n"
				+ "						<input class=\"form-control me-2\" type=\"search\" placeholder=\"Pesquisar artistas\" aria-label=\"Pesquisar\">\r\n"
				+ "						<button class=\"btn btn-outline-success\" type=\"submit\">Buscar</button>\r\n"
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
		
		
		
		return page;
	}
	
	public String renderSectionOneIndex() {
		String sectionOne = "";
		ArtistaDao conexao = new ArtistaDao();
		List<ArtistaModel> artistas = conexao.getArtistas("id_artista");
		int auxiliar = 0;
		
		for(ArtistaModel a: artistas) {
			if (auxiliar == 0) {
				sectionOne += "<div class=\"row\">\r\n";
			}
			
			sectionOne += "   				<div class=\"col col-tiny-12 col-small-6 col-3 col-medium-3\">\r\n"
					+ "   					<div class=\"card\">\r\n"
					+ "  						<img src=" + a.getPathImages() + " class=\"card-img-top\" alt=\"...\">			\r\n"
					+ " 						<div class=\"card-body\">\r\n"
					+ " 					    	<h5 class=\"card-title\">" + a.getNomeArtista() + "</h5>\r\n"
					+ "    						<p class=\"card-text\">" + a.getResumoDescricaoArtista() + "</p>\r\n"
					+ "    						<button type=\"button\" class=\"btn btn-outline-primary\">Contrate</button>\r\n"
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
		
		
		
		return null;
	}
	
	public String renderCategorias() {
		String html = "";
		CategoriaDao conexao = new CategoriaDao();
		List<CategoriaModel> categorias = conexao.getCategorias("id_categoria");
		
		html += "<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt-br\">\r\n"
				+ "<head>\r\n"
				+ "  <meta charset=\"UTF-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "  <title>Minerva - Categorias</title>\r\n"
				+ "  <meta name=\"description\" content=\"Página de busca de artistas independentes\">\r\n"
				+ "  <link rel=\"canonical\" href=\"https://www.minerva.com\">\r\n"
				+ "  <meta name=\"robots\" content=\"index, follow\">\r\n"
				+ "  <meta name=\"keywords\" content=\"musica, arte, artistas independentes\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"..\\style\\style.css\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"..\\style\\arthur.css\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway\">\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <header class=\"navbar navbar-expand-lg navbar-light cabecalho-principal\">\r\n"
				+ "  	<div class=\"container cabecalho-container\">\r\n"
				+ "  	<div class=\"row\">\r\n"
				+ "  		<div class=\"col-3\">\r\n"
				+ "  		<div class=\"titulo-div centralizar-div\">\r\n"
				+ "    		<a class=\"navbar-brand titulo-principal\" href=\"#\"><h1> Minerva </h1></a>\r\n"
				+ "    		<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
				+ "      			<span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "    		</button>\r\n"
				+ "    	</div>\r\n"
				+ "    	</div>\r\n"
				+ "    	<div class=\"col-6\">\r\n"
				+ "    	</div>\r\n"
				+ "		<div class=\"col-3\">\r\n"
				+ "    		<div class=\"collapse navbar-collapse centralizar-div\" id=\"navbarNav\">\r\n"
				+ "      			<ul class=\"navbar-nav ms-auto\">\r\n"
				+ "        			<li class=\"nav-item\">\r\n"
				+ "          				<a class=\"nav-link\" href=\"#\">Home</a>\r\n"
				+ "        			</li>\r\n"
				+ "        			<li class=\"nav-item\">\r\n"
				+ "          				<a class=\"nav-link\" href=\"#\">Sobre</a>\r\n"
				+ "        			</li>\r\n"
				+ "        			<li class=\"nav-item\">\r\n"
				+ "          				<button type=\"button\" class=\"btn btn-outline-light\">Contatos</button>\r\n"
				+ "        			</li>\r\n"
				+ "      			</ul>\r\n"
				+ "    		</div>\r\n"
				+ "    	</div>\r\n"
				+ "    </div>\r\n"
				+ "    </div>\r\n"
				+ "    </header>\r\n"
				+ "\r\n"
				+ "	<div class=\"secao_categorias\">\r\n"
				+ "		<div class=\"limite-site\">\r\n"
				+ "			<h2 class=\"h-principal\" style=\"margin-top:100px;\">Categorias</h2>";
		
		int auxiliar = 0;
		
		for(CategoriaModel c: categorias) {
			if(auxiliar == 0) {
				html += "<div class=\"row\">";
			}
			
			html += "<div class=\"col col-tiny-12 col-small-6 col-3 col-medium-3\">\r\n"
					+ "   					<div class=\"card\">\r\n"
					+ "  						<div class=\"img"+c.getIdCategoria()+"_categoria\"></div>\r\n"
					+ " 						<div class=\"card-body\">\r\n"
					+ " 					    	<h5 class=\"card-title\">" + c.getNomeCategoria() + "</h5>    						\r\n"
					+ "    						<button type=\"button\" class=\"btn btn-outline-primary\">Mais</button>\r\n"
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
}
