package unidade03.exemplos.aula11.tributario;

import java.time.LocalDate;

public class TributoITBI extends Tributo {

	private Contribuinte proprietarioAtual;
	private Contribuinte proprietarioNovo;
	private LocalDate dataTransferencia;

	public Contribuinte getProprietarioAtual() {
		return proprietarioAtual;
	}

	public void setProprietarioAtual(Contribuinte proprietarioAtual) {
		this.proprietarioAtual = proprietarioAtual;
	}

	public Contribuinte getProprietarioNovo() {
		return proprietarioNovo;
	}

	public void setProprietarioNovo(Contribuinte proprietarioNovo) {
		this.proprietarioNovo = proprietarioNovo;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
}
