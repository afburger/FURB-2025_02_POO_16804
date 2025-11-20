package provas.prova03.model;

import java.io.Serializable;

/**
 * Classe que representa a nota conforme o diagrama
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class Nota implements Serializable {

	private double nota;
	private int numeroProva;
	private String descricao;

	public Nota(double nota, int numeroProva, String descricao) {
		this.nota = nota;
		this.numeroProva = numeroProva;
		this.descricao = descricao;
	}

	public double getNota() {
		return nota;
	}

	public int getNumeroProva() {
		return numeroProva;
	}

	public String getDescricao() {
		return descricao;
	}
}
