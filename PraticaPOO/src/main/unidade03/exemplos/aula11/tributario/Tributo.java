package unidade03.exemplos.aula11.tributario;

import java.time.LocalDate;

/**
 * Classe abstrata para representar o dados compartilhados entre IPTU e ITBI.
 */
public abstract class Tributo {

	private LocalDate dataLancamento;
	private Imovel imovel;
	private double valor;

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
