package provas.prova01.correcao;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hospital {

	private String nome;
	private ArrayList<Medico> medicos = new ArrayList<>();
	private ArrayList<Consulta> consultas = new ArrayList<>();

	private Endereco endereco;

	public Consulta agendarConsulta(Paciente p, Medico m, LocalDate data) {
		Consulta consulta = new Consulta(p, m, data);
		consultas.add(consulta);
		return consulta;
	}

	public void cancelarConsulta(Consulta c) {
		consultas.remove(c);
	}

	public void listarConsultas() {
		for (Consulta c : consultas) {
			System.out.println(c.exibirDados());
		}
	}

	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}

	public ArrayList<Medico> getMedicos() {
		return medicos;
	}

	public ArrayList<Paciente> getPacientes() {
		ArrayList<Paciente> pacientes = new ArrayList<>();
		for (Consulta c : consultas) {
			Paciente pc = c.getPaciente();
			if (!pacientes.contains(pc)) {
				pacientes.add(pc);
			}
		}
		return  pacientes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Paciente buscarPaciente(String cpf) {
		if (cpf != null && !cpf.isBlank()) {
			ArrayList<Paciente> pacientes = getPacientes();

			for (Paciente p : pacientes) {
				if (cpf.equals(p.getCpf())) {
					return p;
				}
			}
		}
		return null;
	}

	public Medico buscarMedico(String crm) {
		if (crm != null && !crm.isBlank()) {
			for (Medico med : medicos) {
				if (crm.equals(med.getCrm())) {
					return med;
				}
			}
		}
		return null;
	}
}
