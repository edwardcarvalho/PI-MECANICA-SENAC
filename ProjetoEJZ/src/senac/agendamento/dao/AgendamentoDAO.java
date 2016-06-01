package senac.agendamento.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import senac.agendamento.model.Agendamento;
import senac.agendamento.model.Automovel;
import senac.agendamento.model.Cliente;
import senac.agendamento.model.Funcionario;
import senac.agendamento.model.Servico;

public class AgendamentoDAO extends DAO {

	public Cliente buscaCliente(String cpf) {

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

	public Automovel buscaAutomovelCliente(int id_cliente) {

		Automovel automovelCliente = null;

		try {
			conectaBanco();

			String sql = "SELECT A.ID_CLIENTE, A.MODELO, A.COR, A.ANOFABRICACAO, A.PLACA FROM AUTOMOVEIS A WHERE A.ID_CLIENTE ='"
					+ id_cliente + "'";

			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Cliente cliente = null;
				automovelCliente = new Automovel(rs.getInt("id_cliente"), rs.getString("modelo"), rs.getString("cor"),
						rs.getString("anofabricacao"), rs.getString("placa"));

			}

			st.close();
			rs.close();
			desconectaBanco();
			return automovelCliente;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public ArrayList<Agendamento> buscaHorariosDisponiveis(int unidade, String data) {

		Agendamento agendamento = null;

		ArrayList<Agendamento> horarios = new ArrayList<>();

		String sql = "SELECT AG.HORARIOINICIAL, AG.HORARIOFINAL, AG.STATUS, C.NOME, A.PLACA, A.MODELO, S.DESCRICAO, U.NOME_UNIDADE, F.NOME FROM CLIENTES C "
				+ "INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE "
				+ "INNER JOIN AGENDAMENTOS AG ON AG.ID_AUTOMOVEL = A.ID_AUTOMOVEL INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO "
				+ "INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO "
				+ "INNER JOIN UNIDADE U ON U.ID_UNIDADE = AG.ID_UNIDADE WHERE AG.ID_UNIDADE ='" + unidade
				+ "' AND AG.DATAAGENDAMENTO = '" + data + "' GROUP BY AG.ID_AGENDAMENTO";

		conectaBanco();

		Statement st;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				agendamento = new Agendamento();

				agendamento.setHorarioInicial(rs.getString("HORARIOINICIAL"));
				agendamento.setHorarioFinal(rs.getString("HORARIOFINAL"));

				horarios.add(agendamento);
			}

			st.close();
			desconectaBanco();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return horarios;

	}

	public ArrayList<Funcionario> buscaFuncionariosDisponiveis(int unidade, String data, String horario) {

		Funcionario funcionarios = null;

		ArrayList<Funcionario> funcionario = new ArrayList<>();

		String sql = "SELECT * FROM FUNCIONARIOS F WHERE NOT EXISTS (SELECT * FROM AGENDAMENTOS WHERE ID_FUNCIONARIO = F.ID_FUNCIONARIO AND DATAAGENDAMENTO ='"
				+ data + "' AND HORARIOINICIAL ='" + horario + "') AND F.ID_UNIDADE ='" + unidade + "' GROUP BY F.NOME";

		conectaBanco();

		Statement st;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				funcionarios = new Funcionario();

				funcionarios.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
				funcionarios.setNomeFuncionario(rs.getString("NOME"));
				funcionarios.setIdUnidade(rs.getInt("ID_UNIDADE"));

				funcionario.add(funcionarios);
			}

			st.close();
			desconectaBanco();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return funcionario;

	}

	public ArrayList<Automovel> buscaPlacaComboBox(Cliente cliente) {

		ArrayList<Automovel> automovel = new ArrayList<>();

		Automovel auto;

		try {
			conectaBanco();

			String sql = "SELECT A.ID_CLIENTE, A.PLACA, A.ID_AUTOMOVEL, A.MODELO, A.ANOFABRICACAO, A.COR FROM AUTOMOVEIS A INNER JOIN CLIENTES C ON A.ID_CLIENTE ='"
					+ cliente.getIdCliente() + "' WHERE A.STATUS_AUTO = 'ATIVO' GROUP BY A.PLACA";

			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				auto = new Automovel();

				auto.setIdAutomovel(rs.getInt("id_Automovel"));
				auto.setIdCliente(rs.getInt("id_Cliente"));
				auto.setPlaca(rs.getString("placa"));
				auto.setModelo(rs.getString("modelo"));
				auto.setAnoFabricacao(rs.getString("anoFabricacao"));
				auto.setCor(rs.getString("cor"));

				automovel.add(auto);
			}

			st.close();
			rs.close();
			desconectaBanco();
			return automovel;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Servico> buscaServicos() {

		ArrayList<Servico> servicos = new ArrayList<>();

		String sql = "SELECT ID_SERVICO, DESCRICAO, TEMPOEXECUCAO FROM SERVICOS";

		conectaBanco();

		try {

			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Servico serv = new Servico();

				serv.setIdServico(rs.getInt("id_servico"));
				serv.setDescricao(rs.getString("descricao"));
				serv.setTempoExecucao(rs.getString("tempoExecucao"));

				servicos.add(serv);

			}

			st.close();
			rs.close();
			desconectaBanco();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return servicos;
	}

	public boolean agendarCliente(Agendamento agendamento) {

		String sql = "INSERT INTO AGENDAMENTOS (ID_AUTOMOVEL, ID_FUNCIONARIO, ID_SERVICO, STATUS, DATAAGENDAMENTO, HORARIOINICIAL,HORARIOFINAL,ID_UNIDADE) VALUES (?,?,?,?,?,?,?,?)";

		try {
			conectaBanco();

			pst = conn.prepareStatement(sql);
			pst.setInt(1, agendamento.getIdAutomovel());
			pst.setInt(2, agendamento.getIdFuncionario());
			pst.setInt(3, agendamento.getIdServico());
			pst.setString(4, agendamento.getStatusAgendamento());
			pst.setString(5, agendamento.getDataAgendamento());
			pst.setString(6, agendamento.getHorarioInicial());
			pst.setString(7, agendamento.getHorarioFinal());
			pst.setInt(8, agendamento.getIdUnidade());
			pst.executeUpdate();
			pst.close();
			rs = pst.getGeneratedKeys();

			desconectaBanco();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}
