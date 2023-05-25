package service;

import java.sql.SQLException;

import spark.Request;
import spark.Response;
import util.Util;

public class RenderService {
	private Util util = new Util();
	
	public RenderService() {
		
	}
	
	public Object renderIndex(Request request, Response response) throws SQLException {
		String retorno = util.renderIndex();
		
		return retorno;
	}
	
	public Object renderCategoriasOverview(Request request, Response response) {
		String retorno = util.renderCategorias();
		
		return retorno;
	}
	
	public Object renderCadastroUsuario(Request request, Response response) {
		String retorno = util.render("cadastroUsuario.html");
		
		return retorno;
	}
	
	public Object renderCadastroArtista(Request request, Response response) {
		String retorno = util.render("cadastroArtista.html");
		
		return retorno;
	}
	
	public Object renderPerfilArtista(Request request, Response response) throws NumberFormatException, SQLException {
		String retorno = util.renderPerfilArtistaCompleto(request.params("id"));
		
		return retorno;
	}
	
}
