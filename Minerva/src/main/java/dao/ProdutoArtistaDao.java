package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ImagensArtistaModel;
import model.ProdutoModel;

public class ProdutoArtistaDao extends Dao{
	public ProdutoArtistaDao() {
		super();
		conectar();
	}

	public void finalizaConexao() {
		close();
	}
	
	public ImagensArtistaModel get(int idProduto) throws SQLException {
		ImagensArtistaModel produto = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produtos_artista WHERE id_produto = " + idProduto + ";";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				produto = new ImagensArtistaModel(rs.getInt("id_produto"), rs.getString("path_imagem_produto"),
						rs.getInt("fk_id_artista"), rs.getString("descricao_produto"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return produto;
	}
	
	public boolean insert(ProdutoModel produto) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO produtos_artista (fk_id_artista, path_imagem_produto, descricao_produto) " + "VALUES ('"
					+ produto.getFkIdArtista() + "','" + produto.getPathImagemProduto() + "', '" + produto.getDescricaoProduto() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
		
	}
}
