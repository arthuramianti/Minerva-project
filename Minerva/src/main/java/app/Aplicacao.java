package app;

import static spark.Spark.*;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import javax.servlet.MultipartConfigElement;


import service.ArtistaService;
import service.CategoriaService;
import service.ClienteService;
import service.RenderService;
import spark.Spark;

public class Aplicacao {
	
	static ClienteService clienteService = new ClienteService();
	static ArtistaService artistaService = new ArtistaService();
	static RenderService renderService = new RenderService();
	static CategoriaService categoriaService = new CategoriaService();

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
		get("/artista/:id", (request, response) -> renderService.renderPerfilArtista(request, response));
		get("/produto/:id", (request, response) -> renderService.renderProdutoArtista(request, response));
		//post("/cadastrarArtista", (request, response) -> artistaService.cadastroArtista(request, response));
		
		//Categoria
		get("/categorias/:id", (request, response) -> categoriaService.renderCategoriaEspecifica(request, response));
		get("/categorias/:id/:subcategoria", (request, response) -> categoriaService.atualizaPaginaCategoriaComSub(request, response));
		
		//Busca principal
		post("/buscaArtista", (request, response) -> artistaService.buscaArtista(request, response));
		
		//Produtos
		post("/cadastroProduto", (request, response) -> artistaService.insertProduto(request, response));
		
		
		/*Spark.post("/cadastroProduto", "multipart/form-data", (request, response) -> {
			String imageName = request.queryParams("arquivo");
			System.out.println(imageName);
            String uploadPath = "imagens/" + "teste.jpg";
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            InputStream input = request.raw().getPart("arquivo").getInputStream();
            Files.copy(input, Paths.get(uploadPath), StandardCopyOption.REPLACE_EXISTING);
            
            return "Imagem enviada com sucesso!";
        });*/
		
		

	}

}
