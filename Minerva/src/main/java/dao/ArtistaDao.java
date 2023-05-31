package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.ArtistaModel;
import model.ImagensArtistaModel;

public class ArtistaDao extends Dao {

	public ArtistaDao() {
		super();
		conectar();
	}

	public void finalizaConexao() {
		close();
	}

	public boolean insert(ArtistaModel artista) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO artista (nome_artista, idade_artista, email_artista, senha_artista, numero_artista, resumo_descricao_artista, cpf_artista) " + "VALUES ('"
					+ artista.getNomeArtista() + "'," + artista.getIdadeArtista() + ", '" + artista.getEmailArtista() + "', '" + artista.getSenhaArtista() + "', '" + artista.getNumeroArtista() + "', '" + artista.getResumoDescricaoArtista() + "', '" + artista.getCpfArtista() + "');";
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public ArtistaModel get(int idArtista) throws SQLException {
		ArtistaModel artista = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT nome_artista, resumo_descricao_artista, numero_artista, nome_categoria\r\n"
					+ "FROM artista\r\n"
					+ "JOIN categorias ON id_categoria = fk_id_categoria\r\n"
					+ "WHERE id_artista = "+idArtista+";";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				artista = new ArtistaModel(rs.getString("nome_artista"), rs.getString("resumo_descricao_artista"),
						rs.getString("numero_artista"), rs.getString("nome_categoria"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return artista;
	}
	
	public List<ImagensArtistaModel> getImagensDoArtistaByIdArtista(int idArtista){
		List<ImagensArtistaModel> imagens = new ArrayList<ImagensArtistaModel>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produtos_artista WHERE fk_id_artista = " + idArtista + ";";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ImagensArtistaModel u = new ImagensArtistaModel(rs.getInt("id_produto"), rs.getString("path_imagem_produto"),
						rs.getInt("fk_id_artista"));
				imagens.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return imagens;
	}
	
	public String getFotoPerfil(int fkIdArtista) {
		String imagePath = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT path_foto FROM foto_perfil_artista WHERE fk_id_artista=" + fkIdArtista + ";";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				imagePath = rs.getString("path_foto");
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return imagePath;
	}
	
	public String getImagePathArtista(int fkIdImagem) {
		String imagePath = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT path_imagens FROM imagens_artista WHERE id_imagens=" + fkIdImagem + ";";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				imagePath = rs.getString("path_imagens");
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return imagePath;
	}
	
	public ArtistaModel getInfoArtistaPaginaProduto(int id) {
		ArtistaModel artista = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT nome_artista, nome_categoria, nome_subcategoria\r\n"
					+ "FROM artista\r\n"
					+ "JOIN categorias ON id_categoria = artista.fk_id_categoria\r\n"
					+ "JOIN subcategorias ON subcategorias.id_subcategoria = artista.fk_id_subcategoria\r\n"
					+ "WHERE id_artista = " + id + ";";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				artista = new ArtistaModel(rs.getString("nome_artista"), rs.getString("nome_categoria"),
						rs.getString("nome_subcategoria"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return artista;
	}

	/*public boolean update(ClienteModel cliente, int idCliente) {
		boolean retorno = false;

		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE cliente SET nome_cliente= '" + cliente.getNomeCliente() + "', idade_cliente= "
					+ cliente.getIdade() + ", email_cliente= '" + cliente.getEmail() + "' WHERE id_cliente = " + idCliente
					+ ";";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			retorno = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return retorno;
	}*/

	/*public boolean delete(int idCliente) {
		boolean retorno = false;

		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM cliente WHERE id_cliente=" + idCliente + ";";
			st.executeUpdate(sql);
			st.close();
			retorno = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		return retorno;
	}*/

	/*public int getClientId(String nomeCliente) {
		int idClient = 0;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT id_cliente FROM cliente WHERE nome_cliente LIKE '%" + nomeCliente + "%';";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				idClient = rs.getInt("id_cliente");
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idClient;
	}*/

	/*public List<ClienteModel> get() {
		return getClients("");
	}*/

	public List<ArtistaModel> getArtistas(String orderBy) {
		List<ArtistaModel> artistas = new ArrayList<ArtistaModel>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM artista" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy) + " LIMIT 4;");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ArtistaModel u = new ArtistaModel(rs.getString("nome_artista"), rs.getInt("id_artista"),
						rs.getInt("idade_artista"), rs.getString("email_artista"), rs.getString("senha_artista"), rs.getInt("fk_id_categoria"), rs.getString("resumo_descricao_artista"), this.getImagePathArtista(rs.getInt("fk_id_imagens")), rs.getString("numero_artista"), rs.getString("cpf_artista"));
				artistas.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return artistas;
	}
	
	public List<ArtistaModel> getArtistasByCategoria(String fkIdCategoria) {
		List<ArtistaModel> artistas = new ArrayList<ArtistaModel>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT nome_artista, id_artista, resumo_descricao_artista, nome_categoria, path_imagens, nome_subcategoria\r\n"
					+ "FROM artista\r\n"
					+ "JOIN categorias\r\n"
					+ "ON (categorias.id_categoria = "+fkIdCategoria+")\r\n"
					+ "JOIN imagens_artista\r\n"
					+ "ON (id_imagens = artista.fk_id_imagens)\r\n"
					+ "JOIN subcategorias ON subcategorias.id_subcategoria = artista.fk_id_subcategoria\r\n"
					+ "WHERE artista.fk_id_categoria = "+fkIdCategoria+";";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ArtistaModel u = new ArtistaModel(rs.getString("nome_artista"), rs.getInt("id_artista"), rs.getString("resumo_descricao_artista"), rs.getString("nome_categoria"), rs.getString("path_imagens"), rs.getString("nome_subcategoria"));
				artistas.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return artistas;
	}
	
	public List<ArtistaModel> getArtistasByCategoriaAndSub(String fkIdCategoria, String fkIdSubcategoria) {
		List<ArtistaModel> artistas = new ArrayList<ArtistaModel>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT id_artista, nome_artista, resumo_descricao_artista, nome_subcategoria, path_imagens, id_subcategoria from artista\r\n"
					+ "JOIN categorias ON categorias.id_categoria = "+fkIdCategoria+"\r\n"
					+ "JOIN subcategorias ON subcategorias.id_subcategoria = "+fkIdSubcategoria+"\r\n"
					+ "JOIN imagens_artista\r\n"
					+ "ON (id_imagens = artista.fk_id_imagens)\r\n"
					+ "WHERE artista.fk_id_subcategoria = "+fkIdSubcategoria+";";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ArtistaModel u = new ArtistaModel(rs.getInt("id_artista"),rs.getString("nome_artista"), rs.getString("resumo_descricao_artista"), rs.getString("nome_subcategoria"), rs.getString("path_imagens"), rs.getInt("id_subcategoria"));
				artistas.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return artistas;
	}
	
	public List<ArtistaModel> getArtistasByAnithing(String chaveBusca) {
		List<ArtistaModel> artistas = new ArrayList<ArtistaModel>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT nome_artista, id_artista, resumo_descricao_artista, nome_categoria, path_imagens, nome_subcategoria\r\n"
					+ "FROM artista\r\n"
						+ "JOIN categorias ON categorias.id_categoria = artista.fk_id_categoria\r\n"
						+ "JOIN imagens_artista ON id_imagens = artista.fk_id_imagens\r\n"
						+ "JOIN subcategorias ON subcategorias.id_subcategoria = artista.fk_id_subcategoria\r\n"
						+ "WHERE nome_artista LIKE '%"+chaveBusca+"%' \r\n"
						+ "OR nome_categoria LIKE '%"+chaveBusca+"%'\r\n"
						+ "OR nome_subcategoria LIKE '%"+chaveBusca+"%';";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ArtistaModel u = new ArtistaModel(rs.getString("nome_artista"), rs.getInt("id_artista"), rs.getString("resumo_descricao_artista"), rs.getString("nome_categoria"), rs.getString("path_imagens"), rs.getString("nome_subcategoria"));
				artistas.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return artistas;
	}

}
