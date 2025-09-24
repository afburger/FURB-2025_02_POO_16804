package provas.prova01.correcao;

public class Medico {

	private String nome;
	private String crm;
	private Hospital hospital;

	public Medico(String nome, String crm) {
		this.nome = nome;
		if (crm == null || crm.isBlank()) {
			throw new IllegalArgumentException("CRM é inválido");
		}
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public String getCrm() {
		return crm;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String exibirDados() {
		return "Nome do médico: " + nome + " CRM: " + crm;
	}
}
