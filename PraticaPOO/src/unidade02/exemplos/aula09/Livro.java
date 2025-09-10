package unidade02.exemplos.aula09;

public class Livro {

	private String titulo;
	private int anoPublicacao;
	private Pessoa[] autor;

	public Livro(Pessoa autorPrincipal) {
		autor = new Pessoa[1];
		autor[0] = autorPrincipal;
		autorPrincipal.getObras()[0] = this;
	}

	public Livro(Pessoa[] autores) {
		autor = autores;
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

	public Pessoa[] getAutor() {
		return autor;
	}
}
