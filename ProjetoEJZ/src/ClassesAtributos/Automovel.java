package ClassesAtributos;

public class Automovel {

	private int idAutomovel;
	private Cliente cliente;
	private String modelo;
	private String cor;
	private String anoFabricacao;
	private String placa;

	public Automovel(int idAutomovel, Cliente cliente, String marca,
			String modelo, String cor, String anoFabricacao, String placa) {
		this.idAutomovel = idAutomovel;
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

}
