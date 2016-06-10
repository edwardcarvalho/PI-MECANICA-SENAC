package senac.agendamento.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class Agendamento {

	private String dataAgendamento;
	private String horarioInicial;
	private String horarioFinal;
	private String statusAgendamento;
	private int idAgendamento;
	private int idAutomovel;
	private int idFuncionario;
	private int idServico;
	private int idUnidade;

	public Agendamento() {
	}
	
	public String getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(String statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	public int getIdAutomovel() {
		return idAutomovel;
	}

	public void setIdAutomovel(int idAutomovel) {
		this.idAutomovel = idAutomovel;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(int idUnidade) {
		this.idUnidade = idUnidade;
	}

	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public String getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getHorarioInicial() {
		return horarioInicial;
	}

	public void setHorarioInicial(String horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	public String getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	
	public ComboBoxModel mostraHorariosDisponiveis (ArrayList<Agendamento> horariosDisponiveis){
		
//		recebe um arraylist e retorna um comboBox perenchido com os horarios disponiveis
		
		int agendaManha = 0;
		int agendaTarde = 0;
		
		JComboBox comboBoxHorarioDisponivel = new JComboBox();

		for (Agendamento horario : horariosDisponiveis) {
			if (horario.getHorarioInicial().equalsIgnoreCase("8:00")) {
				agendaManha++;
			} else {
				agendaTarde++;
			}
		}

		if (agendaManha < 3 && agendaTarde < 3) {
			comboBoxHorarioDisponivel.setModel(new DefaultComboBoxModel(
					new String[] { "...", "Manhã (8h00 às 12h00)", "Tarde (13h15 às 17h15)" }));
		} else if (agendaManha < 3 && agendaTarde > 2) {
			comboBoxHorarioDisponivel
					.setModel(new DefaultComboBoxModel(new String[] { "...", "Manhã (8h00 às 12h00)" }));
		} else if (agendaManha > 2 && agendaTarde < 3) {
			comboBoxHorarioDisponivel
					.setModel(new DefaultComboBoxModel(new String[] { "...", "Tarde (13h15 às 17h15)" }));
		} else {
			comboBoxHorarioDisponivel
			.setModel(new DefaultComboBoxModel(new String[] { "INDISPONIVEL" }));
		}
		
		return comboBoxHorarioDisponivel.getModel();
	}
	
	public String converteData(String data) {
		
//		recebe uma data String em formato yyyy-MM-dd e converte para dd-MM-yyyy,
//		para facilitar a visualização da data pelo usuario.
		
		String dataForm = null;
		String[] date = data.split("-");
		for (int i = 2; i >= 0; i--) {
			if (i == 2) {
				dataForm = date[i] + "-";
			} else if (i == 1) {
				dataForm += date[i] + "-";
			} else {
				dataForm += date[i];
			}
		}

		return dataForm;
	}
	
	public boolean verificaDataAgendamentoValida(Date data){
		
//		recebe um Objeto Date com a data desejada para agendamento e verifica se é uma data valida (data atual ou futura).
//		retorna true se atender a este requisito e false se for uma data anterior a atual.
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateSdf = sdf.format(date);
		String dataSdf = sdf.format(data);
		try {
			date = sdf.parse(dateSdf);
			data = sdf.parse(dataSdf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(data.equals(date) || data.after(date)){
			return true;
		}else{
			return false;
		}
		
	}

}
