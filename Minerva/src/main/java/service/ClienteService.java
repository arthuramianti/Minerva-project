package service;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDao;
import model.ClienteModel;
import spark.Request;
import spark.Response;

public class ClienteService {
	private ClienteDao clienteDao = new ClienteDao();

	public ClienteService() {

	}

	public Object get(Request request, Response response) {
		List<ClienteModel> allClients = new ArrayList<ClienteModel>();
		allClients = clienteDao.getClients("id_cliente");

		String tableClients = "";

		tableClients = "<!DOCTYPE html>" + "<html lang=\"pt-BR\">" + "<head>" + "	<title>Todos os clientes</title>"
				+ "	<!-- <link rel=\"stylesheet\" href=\"C:\\Users\\arthu\\eclipse-workspace\\Exercicio3\\src\\main\\resources\\style\\style.css\"> -->"
				+ "</head>" + "<body>" + "	<h1>Todos os Clientes</h1>" + "	<section>" + "		<table border=\"1\">"
				+ "			<thead>" + "				<tr>" + "					<th>ID do Cliente</th>"
				+ "					<th>Nome completo</th>" + "					<th>Idade</th>"
				+ "					<th>Email</th>" + "				</tr>		" + "			</thead>"
				+ "			<tbody>";

		for (ClienteModel c : allClients) {
			tableClients += "<tr>" + "			<td>" + c.getId() + "</td>" + "			<td>" + c.getNomeCliente()
					+ "</td>" + "			<td>" + c.getIdade() + "</td>" + "			<td>" + c.getEmail() + "</td>"
					+ "		</tr>";
		}

		tableClients += "</tbody>" + "		</table>" + "	</section>" + "</body>" + "</html>";

		return tableClients;

	}

	public Object getClientById(Request request, Response response) throws SQLException {
		int id = Integer.parseInt(request.queryParams("id"));

		ClienteModel cliente = clienteDao.get(id);

		String tableClient = "<!DOCTYPE html>" + "<html lang=\"pt-BR\">" + "<head>" + "	<title>Cliente de ID -> " + id
				+ "</title>"
				+ "	<!-- <link rel=\"stylesheet\" href=\"C:\\Users\\arthu\\eclipse-workspace\\Exercicio3\\src\\main\\resources\\style\\style.css\"> -->"
				+ "</head>" + "<body>" + "	<h1>O cliente de ID -> " + id + "</h1>" + "	<section>"
				+ "		<table border=\"1\">" + "			<thead>" + "				<tr>"
				+ "					<th>ID do Cliente</th>" + "					<th>Nome completo</th>"
				+ "					<th>Idade</th>" + "					<th>Email</th>" + "				</tr>		"
				+ "			</thead>" + "			<tbody>";

		tableClient += "<tr>" + "		<td>" + cliente.getId() + "</td>" + "		<td>" + cliente.getNomeCliente()
				+ "</td>" + "		<td>" + cliente.getIdade() + "</td>" + "		<td>" + cliente.getEmail() + "</td>"
				+ "	</tr>";

		tableClient += "</tbody>" + "		</table>" + "	</section>" + "</body>" + "</html>";

		return tableClient;

	}

	public Object deleteClientById(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("id_cliente"));
		boolean retorno = clienteDao.delete(id);
		String front = "<h1>Cliente de ID -> " + id + " foi deletado com sucesso!</h1>";
		return front;
	}

	public Object insertClient(Request request, Response response) {
		String front = "";
		if (!request.queryParams("email_cliente").isEmpty() && !request.queryParams("nome_cliente").isEmpty()
				&& !request.queryParams("idade_cliente").isEmpty()) {
			ClienteModel cliente = new ClienteModel(request.queryParams("nome_cliente"),
					Integer.parseInt(request.queryParams("idade_cliente")), request.queryParams("email_cliente"));
			boolean retorno = clienteDao.insert(cliente);
			front = retorno ? "<h1>Inserção feita com sucesso!</h1>"
					: "<h1>Ocorreu um erro na inserção, tente novamente</h1>";
		} else {
			front = "<h1>O seu formulário está faltando algum campo, refaça o formulario por favor</h1>";
		}
		return front;
	}

	public Object inicia(Request request, Response response) {
		String nomeArquivo = "src/main/resources/Front-end/index.html";
		String retorno = "";
		try {
			Scanner entrada = new Scanner(new File(nomeArquivo));
			while (entrada.hasNext()) {
				retorno += (entrada.nextLine() + "\n");
			}
			entrada.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
}
