package unidade01.exemplos.aula09;

public class Main2 {

	public static void main(String[] args) {
		Pessoa2 autorPrincipal = new Pessoa2("André", "andre@furb.br");
		Pessoa2 pessoaSemLivro = new Pessoa2("José", "jose@furb.br");

		Livro2 livro = new Livro2(autorPrincipal);
		livro.setTitulo("Aulas de POO");
		livro.setAnoPublicacao(2025);

		Livro2 livro2 = new Livro2(autorPrincipal);
		livro2.setTitulo("Aulas de Introdução à programação");

		System.out.println("Informações do livro: " + livro.getTitulo() + " : " + livro.getAnoPublicacao());
		System.out.println("Informações dos autores do livro: ");
		for (int i=0; i < livro.getAutores().size(); i++) {
			System.out.println("Nome do autor (" + i + "): " + livro.getAutores().get(i).getNome());
		}

		System.out.println("###########################");
		System.out.println("Informaões do livro partindo do autor");
		System.out.println("Autor: " + autorPrincipal.getNome());
		System.out.println("Obras deste autor");
		for (Livro2 livroFor : autorPrincipal.getObras()) {
			System.out.println(livroFor.getTitulo());
		}

		System.out.println("Autor2: " + pessoaSemLivro.getNome());
		System.out.println("Obras do autor2");
		for (Livro2 livroFor : pessoaSemLivro.getObras()) {
			System.out.println(livroFor.getTitulo());
		}
	}
}
