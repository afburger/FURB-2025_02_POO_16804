package unidade07.exemplos.exemplo02.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que gerencia uma coleção de estudantes
 *
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class RepositorioEstudantes {
	private List<Estudante> estudantes;

	public RepositorioEstudantes() {
		estudantes = new ArrayList<>();
	}

	public void adicionarEstudante(Estudante estudante) {
		estudantes.add(estudante);
	}

	public List<Estudante> obterTodosEstudantes() {
		return new ArrayList<>(estudantes);
	}

	public void removerEstudante(int indice) {
		if (indice >= 0 && indice < estudantes.size()) {
			estudantes.remove(indice);
		}
	}
}