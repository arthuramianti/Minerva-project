package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.CategoriaModel;

public class CategoriaDao extends Dao{
	
	public CategoriaDao () {
		super();
		conectar();
	}
	
	public void finalizaConexao() {
		close();
	}
	
	public CategoriaModel get(int idCategoria) {
		CategoriaModel categoria = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM categorias WHERE id_categoria=" + idCategoria + ";";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				categoria = new CategoriaModel(rs.getInt("id_categoria"), rs.getString("nome_categoria"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return categoria;
	}
	
	public List<CategoriaModel> getCategorias(String orderBy) {
		List<CategoriaModel> categorias = new ArrayList<CategoriaModel>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM categorias" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				CategoriaModel u = new CategoriaModel(rs.getInt("id_categoria"), rs.getString("nome_categoria"));
				categorias.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}
		return categorias;
	}
	
}
