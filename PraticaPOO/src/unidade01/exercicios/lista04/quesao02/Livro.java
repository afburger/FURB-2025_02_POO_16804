package unidade01.exercicios.lista04.quesao02;

public class Livro {

	private String titulo;
	private String autor;
	private int anoPublicacao;
	private static int totalLivros;

	public Livro() {
		this("Sem título", "Desonhecido", 0);
	}

	public Livro(String titulo, String autor, int ano) {
		this.titulo = titulo;
		this.autor = autor;
		anoPublicacao = ano;
		totalLivros++;
	}

	public String exibirInfo() {
		return "Título: " + titulo
				+ " Autor: " + autor
				+ " Ano de publicação: " + anoPublicacao;
	}

	public String exibirInfo(boolean resumido) {
		if (resumido) {
			return "Título: " + titulo;
		}
		return exibirInfo();
	}

	public static int getTotalLivros() {
		return totalLivros;
	}
}
