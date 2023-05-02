package app;

import static spark.Spark.*;

import service.ClienteService;

public class Aplicacao {

	public static void main(String[] args) {
		port(6789);
		
		ClienteService clienteService = new ClienteService();
		
		get("/todosClientes", (request, response) -> clienteService.get(request, response));
		
		post("/consultaCliente", (request, response) -> clienteService.getClientById(request, response));
		
		post("/deletaCliente", (request, response) -> clienteService.deleteClientById(request, response));
		
		post("/cadastroCliente", (request, response) -> clienteService.insertClient(request, response));

	}

}
