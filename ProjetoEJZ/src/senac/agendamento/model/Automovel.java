package senac.agendamento.model;

public class Automovel {

	private int idAutomovel;
	private int idCliente;
	private String modelo;
	private String cor;
	private String anoFabricacao;
	private String placa;
	private String status_Auto;
	
	public Automovel() {
	}

	public Automovel(int idCliente, String modelo, String cor, String anoFabricacao, String placa) {
		this.setIdCliente(idCliente);
		this.modelo = modelo;
		this.cor = cor;
		this.anoFabricacao = anoFabricacao;
		this.placa = placa;
	}

	public int getIdAutomovel() {
		return idAutomovel;
	}

	public void setIdAutomovel(int idAutomovel) {
		this.idAutomovel = idAutomovel;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getStatus() {
		return status_Auto;
	}

	public void setStatus(String status) {
		this.status_Auto = status;
	}

}
