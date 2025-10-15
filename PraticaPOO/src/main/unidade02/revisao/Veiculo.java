package unidade02.revisao;

public class Veiculo extends ObjetoRelatorio {

	private String placa;
	private String modelo;
	private String marca;

	public Veiculo(String placa, String modelo, String marca) {
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	@Override
	public String imprimir() {
		return placa + " - " + marca + " - " + modelo;
	}
}
