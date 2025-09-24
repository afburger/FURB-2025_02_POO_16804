package unidade01.exemplos.aula07;

import java.util.Scanner;

public class AppTratarExceptionDois {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int idade;
		try {
			idade = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException objErro) {
			System.out.println("Valor incorreto. ");
		}
		System.out.println("Fim");

	}
}
