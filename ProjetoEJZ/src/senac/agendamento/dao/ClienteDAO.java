package senac.agendamento.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import senac.agendamento.model.Automovel;
import senac.agendamento.model.Cliente;

public class ClienteDAO extends DAO {

	public void salvarCliente(Cliente cliente) {

		conectaBanco();

		String sql = "INSERT INTO CLIENTES (NOME, CPF, TELEFONE, CELULAR, DATANASCIMENTO, STATUS_CLIENTE) VALUES (?,?,?,?,?,?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cliente.getNomeCliente().toUpperCase());
			pst.setString(2, cliente.getCpf());
			pst.setString(3, cliente.getTelefoneRes());
			pst.setString(4, cliente.getTelefoneCelular());
			pst.setString(5, cliente.getDataNas());
			pst.setString(6, "ATIVO");
			pst.executeUpdate();
			pst.close();
			rs = pst.getGeneratedKeys();
			cliente.setIdCliente(rs.getInt(1));
			desconectaBanco();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void salvarAutomovel(Automovel carro, Cliente cliente) {

		conectaBanco();

		String sql = "INSERT INTO AUTOMOVEIS(id_cliente, Modelo, AnoFabricacao, Placa, Cor, Status_Auto) VALUES (?,?,?,?,?,?)";

		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cliente.getIdCliente());
			pst.setString(2, carro.getModelo().toUpperCase());
			pst.setString(3, carro.getAnoFabricacao().toUpperCase());
			pst.setString(4, carro.getPlaca().toUpperCase());
			pst.setString(5, carro.getCor().toUpperCase());
			pst.setString(6, "ATIVO");
			pst.execute();
			pst.close();

			desconectaBanco();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizaTabelaCarrosCadastrado(Cliente cliente, JTable tabela){

		conectaBanco();

		DefaultTableModel model = (DefaultTableModel) tabela.getModel();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		Statement st;
		
		String sql = "SELECT A.PLACA, A.MODELO, A.COR, A.ANOFABRICACAO FROM AUTOMOVEIS A WHERE A.ID_CLIENTE ='"
				+ cliente.getIdCliente() + "'AND A.STATUS_AUTO = 'ATIVO' GROUP BY A.PLACA";
		try {
			st = conn.createStatement();
			
			
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				model = (DefaultTableModel) tabela.getModel();
				model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
			}
			
			st.close();
			desconectaBanco();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluirAutomovel(String placa) {

		try {
			conectaBanco();

			String sql = "UPDATE AUTOMOVEIS SET STATUS_AUTO ='INATIVO', PLACA ='" + placa + "(I)' WHERE PLACA = '"
					+ placa + "'";

			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();
			desconectaBanco();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean alterarCliente(Cliente cliente, Integer id_Cliente) {

		try {
			conectaBanco();

			String sql = "UPDATE CLIENTES SET NOME = '" + cliente.getNomeCliente().toUpperCase() + "', TELEFONE = '"
					+ cliente.getTelefoneRes() + "', CELULAR = '" + cliente.getTelefoneCelular()
					+ "', DATANASCIMENTO = '" + cliente.getDataNas() + "' WHERE ID_CLIENTE =" + id_Cliente;

			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();
			desconectaBanco();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@SuppressWarnings("finally")
	public boolean validarCpf(String cpf) {

		String sql = "SELECT C.CPF FROM CLIENTES C WHERE CPF =" + cpf;

		conectaBanco();
		Statement st;
		ArrayList<String> ListaCpf = new ArrayList<>();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				ListaCpf.add(rs.getString("cpf"));
			}

			st.close();
			rs.close();
			desconectaBanco();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (ListaCpf.size() > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	public Cliente buscarCliente(String cpf) {

		Cliente clienteBanco = null;

		try {
			conectaBanco();

			String sql = "SELECT C.NOME, C.CPF, C.ID_CLIENTE, C.DATANASCIMENTO, C.TELEFONE, C.CELULAR FROM CLIENTES C WHERE CPF ='"
					+ cpf + "'AND C.STATUS_CLIENTE = 'ATIVO'";

			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				clienteBanco = new Cliente(rs.getString("Nome"), rs.getString("cpf"), rs.getString("telefone"),
						rs.getString("celular"), rs.getString("dataNascimento"));
				clienteBanco.setIdCliente(rs.getInt("id_cliente"));

			}

			st.close();
			rs.close();
			desconectaBanco();
			return clienteBanco;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void cancelarCadastro(int id_cliente) {

		try {
			conectaBanco();

			String sql = "DELETE FROM CLIENTES WHERE ID_CLIENTE =" + id_cliente;

			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();

			String sql1 = "DELETE FROM AUTOMOVEIS WHERE ID_CLIENTE =" + id_cliente;

			st = conn.createStatement();
			st.executeUpdate(sql1);
			st.close();
			desconectaBanco();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
