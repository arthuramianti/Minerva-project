package app;

import static spark.Spark.*;

import service.ClienteService;

public class Aplicacao {
	
	static ClienteService clienteService = new ClienteService();

	public static void main(String[] args) {
		port(6780);
		
		staticFiles.location("/");
		
		//Rotas normais do site
		get("/", (request, response) -> clienteService.inicia(request, response));	
		get("/cadastroUsuario", (request, response) -> clienteService.cadastroUsuario(request, response));
		
		//Rotas de formulários
		post("/cadastroCliente", (request, response) -> clienteService.insertClient(request, response));
		get("/todosClientes", (request, response) -> clienteService.get(request, response));	
		post("/consultaCliente", (request, response) -> clienteService.getClientById(request, response));	
		post("/deletaCliente", (request, response) -> clienteService.deleteClientById(request, response));

	}

}
