package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO extends DAO{
	
	public ClienteDAO() {
		super();
		conectar();
	}
	
	public void finalizaConexao() {
		close();
	}
	
	public boolean insert(Cliente cliente) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO client (nome_cliente, idade_cliente, email_cliente) "
						+ "VALUES ('"+cliente.getNomeCliente()+  "', '" + cliente.getIdade() + "', '"  
					    + cliente.getEmail() + "');";
			st.executeUpdate(sql);
			st.close();
			status = true;
		}catch(SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Cliente get(int id) throws SQLException {
		Cliente cliente = null;
			try {
				Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sql = "SELECT * FROM client WHERE id_client=" + id + ";";
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()){            
					cliente = new Cliente(rs.getString("nome_cliente"),rs.getInt("id_client"), rs.getInt("idade_cliente"), rs.getString("email_cliente"));
				}
				st.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		
		
		return cliente;
	}
	
	public boolean update(Cliente client, int idCliente) {
		boolean retorno = false;
		
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE client SET nome_cliente= '" + client.getNomeCliente() + "', idade_cliente= "
					+ client.getIdade() + ", email_cliente= '" + client.getEmail() + "' WHERE id_client = "
					+ idCliente + ";";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			retorno = true;
		}catch(SQLException u) {
			throw new RuntimeException(u);
		}
		
		return retorno;
	}
	
	public boolean delete(int id) {
		boolean retorno = false;
		
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM client WHERE id_client=" + id + ";";
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
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT id_client FROM client WHERE nome_cliente LIKE '%"+nomeCliente+"%';";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				idClient = rs.getInt("id_client");
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idClient;
	}
	
	public List<Cliente> get() {
		return getClients("");
	}
	
	public List<Cliente> getClients(String orderBy){
		List<Cliente> clients = new ArrayList<Cliente>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM client" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);
	        while(rs.next()) {	            	
	        	Cliente u = new Cliente(rs.getString("nome_cliente"),rs.getInt("id_client"), rs.getInt("idade_cliente"), rs.getString("email_cliente"));
	            clients.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return clients;
	}
}
