package ClassesAtributos;

public class Agendamento {

	private int idAgendamento;
	private Automovel automovel;
	private Funcionario funcionario;
	private Servico servico;
	private String dataAgendamento;
	private String horarioInicial;
	private String horarioFinal;

	public Agendamento(int idAgendamento, Automovel automovel,
			Funcionario funcionario, Servico servico, String dataAgendamento,
			String horarioInicial, String horarioFinal) {
		this.idAgendamento = idAgendamento;
		this.automovel = automovel;
		this.funcionario = funcionario;
		this.servico = servico;
		this.dataAgendamento = dataAgendamento;
		this.horarioInicial = horarioInicial;
		this.horarioFinal = horarioFinal;
	}

	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
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

}
