package provas.prova01.correcao;

public class Endereco {

	private String rua;
	private int numero;
	private String cidade;

	public Endereco(String rua, int numero, String cidade) {
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}
}
