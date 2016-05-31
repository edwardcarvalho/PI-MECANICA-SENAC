package ClassesAtributos;

public class Servico {

	private int idServico;
	private String descricao;
	private String tempoExecucao;

	public Servico(int idServico, String descricao, String tempoExecucao) {
		this.idServico = idServico;
		this.descricao = descricao;
		this.tempoExecucao = tempoExecucao;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(String tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

}
