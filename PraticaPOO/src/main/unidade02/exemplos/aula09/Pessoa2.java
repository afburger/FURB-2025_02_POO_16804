package unidade02.exemplos.aula09;

import java.util.ArrayList;

public class Pessoa2 {

	private String nome;
	private String email;
	private ArrayList<Livro2> obras;

	public Pessoa2(String nome, String email) {
		this.nome = nome;
		this.email = email;
		obras = new ArrayList<>();
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

	public ArrayList<Livro2> getObras() {
		return obras;
	}

	public void adicionaLivro(Livro2 livro) {
		obras.add(livro);
	}
}
