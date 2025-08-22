package unidade01.exemplos.aula07;

public class AppSobrecarga {

	public static void main(String[] args) {
		ExemploSobrecarga ex = new ExemploSobrecarga();

		ex.setPeso(100);
		ex.setAltura(1.60);

		System.out.println("IMC:" + ex.calcularImc());
		System.out.println("#########");
		System.out.println("IMC:" + ex.calcularImc(25));
	}
}
