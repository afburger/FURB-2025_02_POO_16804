package unidade01.exemplos.aula07;

public class ExemploConstrutor {

	private String nome;
	private String cpf;
	private int anoNascimento;

	public ExemploConstrutor() {
		nome = "Nulo";
		cpf = "00000000000";
	}

	public ExemploConstrutor(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}
}
