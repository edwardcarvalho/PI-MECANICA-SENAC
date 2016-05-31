package BancoDados;

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

import ClassesAtributos.Agendamento;
import ClassesAtributos.Automovel;
import ClassesAtributos.Cliente;
import ClassesAtributos.Funcionario;

public class DAO {

	public static Connection conn;
	public static PreparedStatement pst;
	public static ResultSet rs;

	public void conectaBanco() throws ClassNotFoundException, SQLException {

		System.setProperty("jdbc.Drivers", "org.sqlite.JDBC");
		conn = DriverManager
				.getConnection("jdbc:sqlite:C:\\Users\\CASA\\Documents\\Repositorio_Edward\\Projetos\\teste.db");
		System.out.println("Banco Conectado!");

	}

	public void desconectaBanco() throws SQLException {

		conn.close();
		System.out.println("Banco desconectado!");
	}

}