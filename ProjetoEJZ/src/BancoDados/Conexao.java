package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ClassesAtributos.Automovel;
import ClassesAtributos.Cliente;

public class Conexao {

	public static Connection conn;
	public static PreparedStatement pst;
	public static ResultSet rs;

	public void conectaBanco() throws ClassNotFoundException, SQLException {

		System.setProperty("jdbc.Drivers", "org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\edwar\\Documents\\GitHub\\workspace\\teste.db");
		System.out.println("Banco Conectado!");

	}

	public void desconectaBanco() throws SQLException {

		conn.close();
		System.out.println("Banco desconectado!");
	}

	public void adicionaCliente(Cliente cliente) throws SQLException, ClassNotFoundException {


		conectaBanco();

		String sql = "INSERT INTO CLIENTES (NOME, CPF, TELEFONE, CELULAR, DATANASCIMENTO) VALUES (?,?,?,?,?)";

		pst = conn.prepareStatement(sql);
		pst.setString(1, cliente.getNomeCliente());
		pst.setString(2, cliente.getCpf());
		pst.setString(3, cliente.getTelefoneRes());
		pst.setString(4, cliente.getTelefoneCelular());
		pst.setString(5, cliente.getDataNas());
		pst.executeUpdate();
		pst.close();
		
		rs = pst.getGeneratedKeys();
		cliente.setIdCliente(rs.getInt(1));

		desconectaBanco();

	}
	
	public void adicionaAutomovel (Automovel carro, Cliente cliente) throws ClassNotFoundException, SQLException{
		
		conectaBanco();
		
		String sql = "INSERT INTO AUTOMOVEIS(id_cliente, Modelo, AnoFabricacao, Placa) VALUES (?,?,?,?)";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, cliente.getIdCliente());
		pst.setString(2, carro.getModelo());
		pst.setString(3, carro.getAnoFabricacao());
		pst.setString(4, carro.getPlaca());
		pst.execute();
		pst.close();
		
		desconectaBanco();
	}

}
