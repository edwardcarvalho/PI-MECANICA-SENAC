package ClassesAtributos;

public class Funcionario {

	private int idFuncionario;
	private String nomeFuncionario;
	private int idUnidade;

	public Funcionario() {
	}
	
	public int getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(int idUnidade) {
		this.idUnidade = idUnidade;
	}


	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

}
