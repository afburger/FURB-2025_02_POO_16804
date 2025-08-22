package unidade01.exemplos.aula07;

public class AppVariaveisEstaticas {

	public static void main(String[] args) {
		// Utilizando uma variável estática.
		System.out.println(ExemploVariavelEstatica.mensagem);

		System.out.println("Contagem: " + ExemploVariavelEstatica.contador);

		new ExemploVariavelEstatica();
		new ExemploVariavelEstatica();
		new ExemploVariavelEstatica();

		imprimeMensagem();

		// Utlizando um método estático
		System.out.println(Math.min(100, 50));

		System.out.println("Contagem: " + ExemploVariavelEstatica.contador);
	}

	// Criação de um método estático
	public static void imprimeMensagem() {
		System.out.println("Mensagem padrão");
	}

}
