package app;

import static spark.Spark.*;

import service.ArtistaService;
import service.ClienteService;
import service.RenderService;

public class Aplicacao {
	
	static ClienteService clienteService = new ClienteService();
	static ArtistaService artistaService = new ArtistaService();
	static RenderService renderService = new RenderService();

	public static void main(String[] args) {
		port(6789);
		
		staticFiles.location("/");
		
		//Rotas normais do site
		get("/", (request, response) -> renderService.renderIndex(request, response));	
		get("/categorias", (request, response) -> renderService.renderCategoriasOverview(request, response));
		get("/cadastroUsuario", (request, response) -> renderService.renderCadastroUsuario(request, response));
		get("/cadastroArtista", (request, response) -> renderService.renderCadastroArtista(request, response));
		
		//Usuário
		post("/cadastroCliente", (request, response) -> clienteService.insertClient(request, response));
		get("/todosClientes", (request, response) -> clienteService.get(request, response));	
		post("/consultaCliente", (request, response) -> clienteService.getClientById(request, response));	
		post("/deletaCliente", (request, response) -> clienteService.deleteClientById(request, response));
		
		//Artista
		post("/cadastrarArtista", (request, response) -> artistaService.insertArtista(request, response));
		//post("/cadastrarArtista", (request, response) -> artistaService.cadastroArtista(request, response));
		
		
		

	}

}
