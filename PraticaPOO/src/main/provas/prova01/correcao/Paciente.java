package provas.prova01.correcao;

public class Paciente {

	private String nome;
	private String cpf;
	private int idade;

	public Paciente(String nome, String cpf, int idade) {
		this.nome = nome;
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("CPF é inválido");
		}
		this.cpf = cpf;
		if (idade < 0) {
			throw new IllegalArgumentException("Idade é inválido");
		}
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}

	public String exibirDados() {
		return "Nome: " + nome + " CPF: " + cpf + " Idade: " + idade;
	}
}
