package unidade01.exemplos.aula07;

public class AppTratarException {

	public static void main(String[] args) {

		double[] nota = new double[3];
		nota[0] = 10;
		nota[1] = 7;
		nota[2] = 8;

		double somaNotas = 0;
		try {
			for (int i=0; i<=nota.length; i++) {
				somaNotas += nota[i];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("O valor do indice informado é inválido");
		}

		System.out.println("A média é: " + (somaNotas/nota.length));

		TratarException exception = new TratarException();
		exception.lerArquivo();

	}
}
