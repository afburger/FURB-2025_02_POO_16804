package unidade01.exemplos.aula09;

public class Main {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa("Autor", "autor@email.com.br");

		Livro livro = new Livro(pessoa);
		livro.setTitulo("Como aprender JAVA em 21 dias");


		System.out.println("Livro:" + livro.getTitulo());
		Pessoa autorLivro = livro.getAutor()[0];
		System.out.println("Nome do autor:" + autorLivro.getNome());
		System.out.println("email do autor:" + livro.getAutor()[0].getEmail());

		// Navegabilidade Bidirecional
		System.out.println("Obra partindo do autor");
		System.out.println(pessoa.getObras()[0].getTitulo());
	}
}
