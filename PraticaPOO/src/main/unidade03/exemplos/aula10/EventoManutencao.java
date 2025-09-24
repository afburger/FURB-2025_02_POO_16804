package unidade03.exemplos.aula10;

import java.util.ArrayList;

public class EventoManutencao extends Evento {

	private ArrayList<String> pecasTrocadas = new ArrayList<>();

	public EventoManutencao(Veiculo veiculo) {
		super(veiculo);
		setDescricao("Manutenção");
	}

	public ArrayList<String> getPecasTrocadas() {
		return pecasTrocadas;
	}

	public void adicionarPeca(String peca) {
		pecasTrocadas.add(peca);
	}

	public void removerPeca(String peca) {
		pecasTrocadas.remove(peca);
	}
}
