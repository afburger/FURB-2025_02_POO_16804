package unidade03.exemplos.aula11.tributario;

import java.time.LocalDate;

public class TributoIPTU extends Tributo {

	private long anoCompetencia;

	public void setAnoCompetencia(long anoCompetencia) {
		this.anoCompetencia = anoCompetencia;
	}

	public long getAnoCompetencia() {
		return anoCompetencia;
	}
}
