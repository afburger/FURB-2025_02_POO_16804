package unidade03.exercicios.lista10;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Projeto {

	private int numero;
	private LocalDate dataInclusao;
	private String descricao;
	private ArrayList<Profissional> responsaveis = new ArrayList<>();

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Profissional> getResponsaveis() {
		return responsaveis;
	}

	public void adicionarResponsavel(Profissional responsavel) {
		if (responsaveis.contains(responsavel)) {
			throw new IllegalArgumentException("Profissional já registrado para o projeto: " + getNumero());
		}
		responsaveis.add(responsavel);
		responsavel.adicionaProjeto(this);
	}

	public void removerResponsavel(String cpf) {
		// Verifica se o cpf foi informado
		if (cpf != null && !cpf.isBlank()) {
			// Cria uma variável para armazenar o profissional se encontrar.
			Profissional excluir = null;
			// Percorre o arraylist de profissionais
			for (Profissional prof : responsaveis) {
				// Verifica se o cpf do profissional é o mesmo que o CPF informado.
				if (cpf.equals(prof.getCpf())) {
					// Se encontrou, atualiza a variável
					excluir = prof;
					// para a pesquisa.
					break;
				}
				// verifica se a variável excluir possui um profissional atribuído.
				if (excluir != null) {
					// Remove o profissional.
					responsaveis.remove(excluir);
				}
			}
		}
	}

	public abstract TipoProjeto getTipoProjeto();

	public abstract String getResumo();
}
