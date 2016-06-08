package senac.agendamento.model;

public class Cliente {

	private int idCliente;
	private String nomeCliente;
	private String cpf;
	private String telefoneRes;
	private String telefoneCelular;
	private String dataNas;

	public Cliente(String nomeCliente, String cpf,String telefoneRes, String telefoneCelular, String dataNas) {
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.telefoneRes = telefoneRes;
		this.telefoneCelular = telefoneCelular;
		this.dataNas = dataNas;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefoneRes() {
		return telefoneRes;
	}

	public void setTelefoneRes(String telefoneRes) {
		this.telefoneRes = telefoneRes;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getDataNas() {
		return dataNas;
	}

	public void setDataNas(String dataNas) {
		this.dataNas = dataNas;
	}
}
