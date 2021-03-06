package senac.agendamento.dao;

import java.awt.Color;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import senac.agendamento.model.Agendamento;
import senac.agendamento.model.Cliente;
import senac.agendamento.model.Funcionario;

public class RelatoriosDAO extends DAO {
	
	Agendamento ag = new Agendamento();

	public boolean relatorioDeAgendamentos(JTable tabela, String dataInicio, String dataFinal, int filtro) {
		
//		esta funcao recebe uma tabela, uma data inicial, uma data final e um filtro para pesquisa.
//		de acordo com o numero do filtro � gerado um tipo de relatorio geral de agendamento.

		String sql;
		String pesquisa;

		if (filtro == 1) {
			pesquisa = "CANCELADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 2) {
			pesquisa = "FILA DE ESPERA";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 3) {
			pesquisa = "AGENDADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 4) {
			pesquisa = "FINALIZADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else {
			pesquisa = null;
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
			
		}

		DefaultTableModel model = (DefaultTableModel) tabela.getModel();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		conectaBanco();

		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				model = (DefaultTableModel) tabela.getModel();
				model.addRow(new String[] { rs.getString(1), ag.converteData(rs.getString(2)), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10)});

			}
			
			st.close();
			desconectaBanco();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if(model.getRowCount() > 0){
			return true;
		}else{
			return false;
			
		}

	}
	
	public boolean relatorioPorFuncionario(JTable tabela, String dataInicio, String dataFinal, int filtro, int opcao) {
		
//		esta funcao recebe uma tabela, uma data inicial, uma data final, um filtro e uma opcao que traz o idFuncionario.
//		de acordo com o numero do filtro � gerado um tipo de relatorio, para um funcionario especifico.

		String sql;
		String pesquisa;

		if (filtro == 1) {
			pesquisa = "CANCELADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_FUNCIONARIO = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 2) {
			pesquisa = "FILA DE ESPERA";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_FUNCIONARIO = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 3) {
			pesquisa = "AGENDADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_FUNCIONARIO = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 4) {
			pesquisa = "FINALIZADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_FUNCIONARIO = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else {
			pesquisa = null;
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_FUNCIONARIO = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		}

		DefaultTableModel model = (DefaultTableModel) tabela.getModel();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		conectaBanco();

		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				model = (DefaultTableModel) tabela.getModel();
				model.addRow(new String[] { rs.getString(1), ag.converteData(rs.getString(2)), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10) });

			}
			
			st.close();
			desconectaBanco();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(model.getRowCount() > 0){
			return true;
		}else{
			return false;
			
		}


	}
	
	public boolean relatorioPorUnidade(JTable tabela, String dataInicio, String dataFinal, int filtro, int opcao) {
		
//		esta funcao recebe uma tabela, uma data inicial, uma data final, um filtro e uma opcao que traz o idUnidade.
//		de acordo com o numero do filtro � gerado um tipo de relatorio, para uma unidade especifica.

		String sql;
		String pesquisa;

		if (filtro == 1) {
			pesquisa = "CANCELADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_UNIDADE = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 2) {
			pesquisa = "FILA DE ESPERA";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_UNIDADE = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 3) {
			pesquisa = "AGENDADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_UNIDADE = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 4) {
			pesquisa = "FINALIZADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_UNIDADE = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else {
			pesquisa = null;
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND AG.ID_UNIDADE ='"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		}

		DefaultTableModel model = (DefaultTableModel) tabela.getModel();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		conectaBanco();

		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				model = (DefaultTableModel) tabela.getModel();
				model.addRow(new String[] { rs.getString(1), ag.converteData(rs.getString(2)), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10)});

			}
			
			st.close();
			desconectaBanco();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(tabela.getRowCount() > 0){
			return true;
		}else{
			return false;
			
		}


	}
	
	public boolean relatorioPorCliente(JTable tabela, String dataInicio, String dataFinal, int filtro, int opcao) {
		
//		esta funcao recebe uma tabela, uma data inicial, uma data final, um filtro e uma opcao que traz o idCliente.
//		de acordo com o numero do filtro � gerado um tipo de relatorio, para um cliente especifico.

		String sql;
		String pesquisa;

		if (filtro == 1) {
			pesquisa = "CANCELADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND C.ID_CLIENTE = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 2) {
			pesquisa = "FILA DE ESPERA";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND C.ID_CLIENTE = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 3) {
			pesquisa = "AGENDADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND C.ID_CLIENTE = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else if (filtro == 4) {
			pesquisa = "FINALIZADO";
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.STATUS = '"+pesquisa+"' AND AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND C.ID_CLIENTE = '"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		} else {
			pesquisa = null;
			sql = "SELECT AG.ID_AGENDAMENTO, AG.DATAAGENDAMENTO AS DATA, C.NOME, A.PLACA, AG.STATUS, S.DESCRICAO, AG.HORARIOINICIAL, AG.HORARIOFINAL, U.NOME_UNIDADE AS UNIDADE, F.NOME AS FUNCIONARIO FROM CLIENTES C INNER JOIN AUTOMOVEIS A ON C.ID_CLIENTE = A.ID_CLIENTE INNER JOIN SERVICOS S ON S.ID_SERVICO = AG.ID_SERVICO INNER JOIN FUNCIONARIOS F ON F.ID_FUNCIONARIO = AG.ID_FUNCIONARIO INNER JOIN AGENDAMENTOS AG ON A.ID_AUTOMOVEL = AG.ID_AUTOMOVEL INNER JOIN UNIDADE U ON AG.ID_UNIDADE = U.ID_UNIDADE WHERE AG.DATAAGENDAMENTO BETWEEN '"
					+ dataInicio + "' AND '" + dataFinal
					+ "' AND C.ID_CLIENTE ='"+opcao+"' GROUP BY AG.ID_AGENDAMENTO ORDER BY AG.DATAAGENDAMENTO ASC, AG.HORARIOINICIAL DESC, U.NOME_UNIDADE ASC";
		}

		DefaultTableModel model = (DefaultTableModel) tabela.getModel();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		conectaBanco();

		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				model = (DefaultTableModel) tabela.getModel();
				model.addRow(new String[] { rs.getString(1), ag.converteData(rs.getString(2)), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10) });

			}
			
			st.close();
			desconectaBanco();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(tabela.getRowCount() > 0){
			return true;
		}else{
			return false;
			
		}


	}
	
	public ArrayList<Funcionario> bucarTodosFuncionarioComboBox (){
		
//		esta funcao busca todos os funcionarios cadastrados no banco de dados e retorna um arraylist
//		para preenchimento de um comboBox.
		
		String sql = "SELECT F.ID_FUNCIONARIO, F.NOME, F.ID_UNIDADE FROM FUNCIONARIOS F GROUP BY ID_FUNCIONARIO";
		
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
		
		conectaBanco();
		
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				Funcionario funcionario = new Funcionario();
				
				funcionario.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
				funcionario.setNomeFuncionario(rs.getString("NOME"));
				funcionario.setIdUnidade(rs.getInt("ID_UNIDADE"));
				
				listaFuncionarios.add(funcionario);
				
			}
			
			st.close();
			rs.close();
			desconectaBanco();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaFuncionarios;
		
	}
	
	public ArrayList<Cliente> bucarTodosClientesComboBox (){
		
//		esta funcao busca todos os clientes cadastrados no banco de dados e retorna um arraylist
//		para preenchimento de um comboBox.
		
		
		String sql = "SELECT C.ID_CLIENTE, C.NOME, C.CPF FROM CLIENTES C GROUP BY C.ID_CLIENTE ORDER BY C.NOME";
		
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		
		conectaBanco();
		
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				Cliente cliente = new Cliente();
				
				cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
				cliente.setNomeCliente(rs.getString("NOME"));
				cliente.setCpf(rs.getString("CPF"));
				
				listaClientes.add(cliente);
				
			}
			
			st.close();
			rs.close();
			desconectaBanco();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaClientes;
		
	}
	
	
}
