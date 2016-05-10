package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ClassesAtributos.Cliente;

public class ConexaoDAO {

	public static Connection conn;
	public static Statement st;
	public static ResultSet rs;

	public void conectaBanco() throws ClassNotFoundException, SQLException {

		System.setProperty("jdbc.Drivers", "org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\edwar\\Documents\\GitHub\\workspace\\teste.db");
		System.out.println("Banco Conectado!");

	}

	public void adicionaCliente(Cliente cliente) throws SQLException {

		String sql = "INSERT INTO CLIENTES(NOME, CPF, TELEFONE, CELULAR, DATANASCIMENTO)"
				+ "VALUES ('" + cliente.getNomeCliente() + "', '" + cliente.getCpf() + "','" + cliente.getTelefoneRes()
				+ "','" + cliente.getTelefoneCelular() + "','" + cliente.getDataNas() + "')";
		
		st = conn.createStatement();
		st.executeUpdate(sql);

	}

	public void desconectaBanco() throws SQLException {

		conn.close();
		System.out.println("Banco desconectado!");
	}

}
