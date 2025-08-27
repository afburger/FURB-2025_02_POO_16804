package unidade01.exercicios.lista04.quesao02;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe quantos livros deseja cadastrar");
		int quantidadeLivros = teclado.nextInt();

		Livro[] livros = new Livro[quantidadeLivros];

		for (int i = 0; i < livros.length; i++) {

			System.out.println("Informe o título do livro N." + i);
			String titulo = teclado.next();

			System.out.println("Informe o autor do livro N." + i);
			String autor = teclado.next();

			System.out.println("Informe o ano de publicação do livro N." + i);
			int anoPublicacao = teclado.nextInt();

			livros[i] = new Livro(titulo, autor, anoPublicacao);
		}

		for (int i = 0; i < livros.length; i++) {
			Livro livroCadastrado = livros[i];
			if (i % 2 == 0) {
				System.out.println(livroCadastrado.exibirInfo(true));
			} else {
				System.out.println(livroCadastrado.exibirInfo());
			}

		}

		System.out.println("Total de livros cadastrados: " + Livro.getTotalLivros());
	}
}
