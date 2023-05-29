package service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import dao.ArtistaDao;
import model.ArtistaModel;
import spark.Request;
import spark.Response;
import util.Util;

public class ArtistaService {
	private ArtistaDao ArtistaDao = new ArtistaDao();
	Util util = new Util();
	
	public ArtistaService() {
		
	}

	public Object insertArtista(Request request, Response response) throws NumberFormatException, NoSuchAlgorithmException {
		String front = "";
		
		if(!request.queryParams("nome_artista").isEmpty() && !request.queryParams("idade_artista").isEmpty() && !request.queryParams("email_artista").isEmpty()) {
			ArtistaModel artista = new ArtistaModel(request.queryParams("nome_artista"),
					Integer.parseInt(request.queryParams("idade_artista")), request.queryParams("email_artista") , util.toMD5(request.queryParams("senha_artista")),
					request.queryParams("resumo_descicao_artista"), request.queryParams("arquivo"), request.queryParams("numero_artista"), request.queryParams("cpf_artista"), Integer.parseInt(request.queryParams("categoria_artista")));
		
		response.status(201);
		boolean retorno = ArtistaDao.insert(artista);
		
		front = retorno ? "<h3>Inserção feita com sucesso!</h3>"
				: "<h3>Ocorreu um erro na inserção, tente novamente</h3>";
		
		} else {
			front = "<h3>Há campos faltantes no seu formulario faça novamente.</h3>";
			response.status(404);
		}
		
		String page = util.render("cadastroArtista.html");
		
		page = page.replaceFirst("<form action=\"http://localhost:6789/cadastrarArtista\"  method=\"post\" name=\"Formulario de cadastro de Artistas\">", "<form action=\"http://localhost:6789/cadastrarArtista\" style=\"display: none;\" method=\"post\" name=\"Formulario de cadastro de Artistas\">");
		page = page.replaceFirst("<div style=\"text-align: center; padding: 18px; display: none;\"><h4><RESULTFORM></h4></div>", 
				"<div style=\"text-align: center; padding: 18px;\"><h4><RESULTFORM></h4></div>");
		
		page = page.replaceFirst("<RESULTFORM>", front);
		
		return page;
	}
	
	public Object buscaArtista(Request request, Response response) {
		String page = util.renderHeader();
		List<ArtistaModel> artistas = new ArrayList<ArtistaModel>();
		int auxiliar = 0;
		
		page += "<section>"
				+ "<div class=\"limite-site\">";
		page += "<h2 class=\"h-principal h-categorias\" style=\"margin-top:100px;\">Resultado da busca para \""+request.queryParams("chave_busca")+"\"</h2>";
		
		if(!request.queryParams("chave_busca").isEmpty()) {
			artistas = ArtistaDao.getArtistasByAnithing(request.queryParams("chave_busca"));
			
			if(artistas.isEmpty()) {
				page += "<div class=\"row div-categorias-especificas\">\r\n"
					+ "<div class=\"col-12\">\r\n"
					+ "<h2 class=\"h-principal h-categorias\" style=\"margin-top:100px;\">Infelizmente ainda não temos artistas cadastrados para esta busca, tente usar outras palavras chave</h2>"
					+ "</div>"
					+ "</div>";
			} else {
				for(ArtistaModel a: artistas) {
					if (auxiliar == 0) {
						page += "<div class=\"row div-categorias-especificas\">\r\n";
					}
					
					page += "   				<div class=\"col col-tiny-12 col-small-6 col-3 col-medium-3\">\r\n"
							+ "   					<div class=\"card\">\r\n"
							+ "  						<img src=" + a.getPathImages() + " class=\"card-img-top\" alt=\"...\">			\r\n"
							+ " 						<div class=\"card-body\">\r\n"
							+ " 					    	<h5 class=\"card-title\">" + a.getNomeArtista() + "</h5>\r\n"
							+ "    						<p class=\"card-text\">" + a.getResumoDescricaoArtista() + "</p>\r\n"
							+ "    						<a href=\"http://localhost:6789/artista/" + a.getIdArtista() + "\"><button type=\"button\" class=\"btn btn-outline-primary\">Perfil</button></a>\r\n"
							+ "				    	</div>\r\n"
							+ "					 </div>\r\n"
							+ "   				</div>";
					
					auxiliar++;
					
					if(auxiliar == 4) {
						page += "</div>";
						auxiliar = 0;
					}
				}
			}
			
		} else {
			page += "<div class=\"row div-categorias-especificas\">\r\n"
					+ "<div class=\"col-12\">\r\n"
					+ "<h2 class=\"h-principal h-categorias\" style=\"margin-top:100px;\">Campo de busca vazio, tente inserir palavras chave para buscar por artistas</h2>"
					+ "</div>"
					+ "</div>";
		}
		
		page += "</div>";
		page += "</section>";
		
		page += util.renderFooter();
		
		return page;
	}
	
	public Object insertProduto(Request request, Response response) {
		System.out.println("ll");
		return "<h1>fodas</h1>";
		
	}
	
}
