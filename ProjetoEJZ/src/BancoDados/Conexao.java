package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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

	public void adicionaAutomovel(Automovel carro, Cliente cliente) throws ClassNotFoundException, SQLException {

		conectaBanco();

		String sql = "INSERT INTO AUTOMOVEIS(id_cliente, Modelo, AnoFabricacao, Placa, Cor) VALUES (?,?,?,?,?)";

		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, cliente.getIdCliente());
		pst.setString(2, carro.getModelo());
		pst.setString(3, carro.getAnoFabricacao());
		pst.setString(4, carro.getPlaca());
		pst.setString(5, carro.getCor());
		pst.execute();
		pst.close();

		desconectaBanco();
	}

	public void mostraCarroCadastrado(Cliente cliente, Automovel carro, JTable tabela)
			throws ClassNotFoundException, SQLException {

		conectaBanco();

		DefaultTableModel model = (DefaultTableModel) tabela.getModel();

		for (int i = 0; i < model.getRowCount(); i++) {
			model.removeRow(0);
		}

		rs = null;
		Statement st = conn.createStatement();

		String sql = "SELECT A.PLACA, A.MODELO, A.COR, A.ANOFABRICACAO FROM AUTOMOVEIS A WHERE A.ID_CLIENTE ="
				+ cliente.getIdCliente();

		rs = st.executeQuery(sql);

		while (rs.next()) {
			model = (DefaultTableModel) tabela.getModel();
			model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
		}

		st.close();
		desconectaBanco();

	}

}
