package service;

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

	public Object insertArtista(Request request, Response response) {
		String front = "";
		
		if(!request.queryParams("nome_artista").isEmpty() && !request.queryParams("idade_artista").isEmpty() && !request.queryParams("email_artista").isEmpty()) {
			ArtistaModel artista = new ArtistaModel(request.queryParams("nome_artista"),
					Integer.parseInt(request.queryParams("idade_artista")), request.queryParams("email_artista") , request.queryParams("senha_artista"),
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
	
}
