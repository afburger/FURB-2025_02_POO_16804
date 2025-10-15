package unidade03.exemplos.aula16.polimorfismo;

import java.time.LocalDate;

public class Venda {

	private double valor;
	private LocalDate data;
	private Vendedor vendedor;

	public Venda(double valor, LocalDate data) {
		this.valor = valor;
		this.data = data;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public double getValor() {
		return valor;
	}

	public LocalDate getData() {
		return data;
	}
}
