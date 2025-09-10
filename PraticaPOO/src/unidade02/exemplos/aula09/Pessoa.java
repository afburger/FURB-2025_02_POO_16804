package unidade02.exemplos.aula09;

public class Pessoa {

	private String nome;
	private String email;
	private Livro[] obras;

	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
		obras = new Livro[10];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Livro[] getObras() {
		return obras;
	}
}
