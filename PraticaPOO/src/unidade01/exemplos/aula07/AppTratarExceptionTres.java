package unidade01.exemplos.aula07;

import java.util.Scanner;

public class AppTratarExceptionTres {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		try {
			int a[] = new int[2];
			a[4] = 30 / Integer.parseInt(teclado.nextLine());
			System.out.println("Operação concluída com êxito");
		} catch (NumberFormatException e) {
			System.out.println("Valor digitado é inválido");
		} catch (ArithmeticException e) {
			System.out.println("Falha na divisão");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Não conseguiu atribuir ao vetor");
		} catch (Exception e) {
			System.out.println("Qualquer outra exceção");
		}
		System.out.println("Fora do bloco");


	}
}
