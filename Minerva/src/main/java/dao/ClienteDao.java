package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.ClienteModel;

public class ClienteDao extends Dao {

	public ClienteDao() {
		super();
		conectar();
	}

	public void finalizaConexao() {
		close();
	}

	public boolean insert(ClienteModel cliente) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO cliente (nome_cliente, idade_cliente, email_cliente) " + "VALUES ('"
					+ cliente.getNomeCliente() + "', '" + cliente.getIdade() + "', '" + cliente.getEmail() + "');";
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public ClienteModel get(int idCliente) throws SQLException {
		ClienteModel cliente = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM cliente WHERE id_cliente=" + idCliente + ";";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				cliente = new ClienteModel(rs.getString("nome_cliente"), rs.getInt("id_cliente"),
						rs.getInt("idade_cliente"), rs.getString("email_cliente"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return cliente;
	}

	public boolean update(ClienteModel cliente, int idCliente) {
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
	}

	public boolean delete(int idCliente) {
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
	}

	public int getClientId(String nomeCliente) {
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
	}

	public List<ClienteModel> get() {
		return getClients("");
	}

	public List<ClienteModel> getClients(String orderBy) {
		List<ClienteModel> clients = new ArrayList<ClienteModel>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM cliente" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ClienteModel u = new ClienteModel(rs.getString("nome_cliente"), rs.getInt("id_cliente"),
						rs.getInt("idade_cliente"), rs.getString("email_cliente"));
				clients.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return clients;
	}
}
