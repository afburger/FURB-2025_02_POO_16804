package provas.prova03.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o alnuno conforme o diagrama
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class Aluno implements Serializable {

	private String nome;
	private int codigoMatricula;
	private String turma;
	private List<Nota> notas;

	public Aluno(String nome, int codigoMatricula, String turma) {
		this.nome = nome;
		this.codigoMatricula = codigoMatricula;
		this.turma = turma;
		this.notas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public int getCodigoMatricula() {
		return codigoMatricula;
	}

	public String getTurma() {
		return turma;
	}

	/**
	 * Adiciona a nota na lista de notas.
	 */
	public void adicionarNota(Nota nota) {
		this.notas.add(nota);
	}

	/**
	 * Retorna a lista de notas
	 */
	public List<Nota> getNotas() {
		return notas;
	}


	/**
	 * Calcula e retorna as médias com a seguinte fórmula:
	 * média = somarTodasAsNotas / quantidadeDeNotas
	 */
	public double getMedia() {
		double soma = 0;

		for (Nota nota : notas) {
			soma += nota.getNota();
		}

		double media = soma / getNotas().size();
		return media;
	}

}
