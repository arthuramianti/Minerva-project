package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ClienteModel;
import model.SubcategoriaModel;

public class SubcategoriaDao extends Dao{
	public SubcategoriaDao() {
		super();
		conectar();
	}
	
	public void finalizaConexao() {
		close();
	}
	
	public SubcategoriaModel get(int idSubcategoria) {
		SubcategoriaModel subcategoria = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT id_subcategoria, nome_subcategoria, nome_categoria, fk_id_categoria\r\n"
					+ "	FROM subcategorias\r\n"
					+ "	JOIN categorias \r\n"
					+ "	ON categorias.id_categoria = fk_id_categoria\r\n"
					+ "	WHERE id_subcategoria = "+ idSubcategoria + ";";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				subcategoria = new SubcategoriaModel(rs.getString("nome_subcategoria"), rs.getString("nome_categoria"),
						rs.getInt("id_subcategoria"), rs.getInt("fk_id_categoria"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return subcategoria;
	}
	
	public List<SubcategoriaModel> getSubcategoriaNameByFK(String fkIdCategoria) {
		List<SubcategoriaModel> subcategorias = new ArrayList<SubcategoriaModel>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT nome_subcategoria\r\n"
					+ "	FROM subcategorias\r\n"
					+ "	JOIN categorias \r\n"
					+ "	ON categorias.id_categoria = fk_id_categoria\r\n"
					+ "	WHERE fk_id_categoria = "+ fkIdCategoria + ";";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				SubcategoriaModel u = new SubcategoriaModel(rs.getString("nome_subcategoria"));
				subcategorias.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return subcategorias;
	}
}
