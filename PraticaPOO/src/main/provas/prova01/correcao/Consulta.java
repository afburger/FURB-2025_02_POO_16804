package provas.prova01.correcao;

import java.time.LocalDate;

public class Consulta {

	private LocalDate data;
	private String observacoes;
	private Medico medico;
	private Paciente paciente;

	public Consulta (Paciente paciente, Medico medico, LocalDate data) {
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
	}

	public void adicionarObservacao(String texto) {
		StringBuilder sb = new StringBuilder();
		if (observacoes != null) {
			sb.append(observacoes);
		}
		sb.append(texto);
		observacoes = sb.toString();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public String exibirDados() {
		StringBuilder sb = new StringBuilder();
		sb.append("Informações da consulta").append("\n");
		sb.append("Data: ").append(data).append("\n");
		sb.append("Médico: ").append(medico.exibirDados()).append("\n");
		sb.append("Paciente: ").append(paciente.exibirDados()).append("\n");
		return sb.toString();
	}

}
