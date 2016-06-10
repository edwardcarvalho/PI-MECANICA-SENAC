package senac.agendamento.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import senac.agendamento.model.Agendamento;
import senac.agendamento.model.Automovel;
import senac.agendamento.model.Cliente;
import senac.agendamento.model.Funcionario;

public class DAO {

	public static Connection conn;
	public static PreparedStatement pst;
	public static ResultSet rs;

	public void conectaBanco() {

//		faz a abertura de uma conexão com o banco de dados.
		
		String diretorio = System.getProperty("user.dir");

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + diretorio
					+ "\\Banco\\bancoConcessionaria.db");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Banco Conectado!");

	}

	public void desconectaBanco() throws SQLException {
		
//		faz o fechamento da conexão aberta com o banco de dados.

		conn.close();
		System.out.println("Banco desconectado!");
	}

}