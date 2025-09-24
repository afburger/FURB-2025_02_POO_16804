package unidade02.exemplos.aula09;

import java.util.ArrayList;

public class Livro2 {

	private String titulo;
	private int anoPublicacao;
	private ArrayList<Pessoa2> autores;

	public Livro2(Pessoa2 autorPrincipal) {
		autores =  new ArrayList<>();
		autores.add(autorPrincipal);
		autorPrincipal.adicionaLivro(this);
	}

	public Livro2(ArrayList<Pessoa2> autores) {
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public ArrayList<Pessoa2> getAutores() {
		return autores;
	}

	public void adicionaAutor(Pessoa2 autor) {
		autores.add(autor);
	}
}
