package unidade01.exemplos.aula06;

public class AppConstrutor {

	public static void main(String[] args) {
		ExemploConstrutor ex1 = new ExemploConstrutor();

		ExemploConstrutor ex2 = new ExemploConstrutor("André", "12345678911");

		System.out.println(ex1.getNome());
		System.out.println(ex1.getCpf());

		System.out.println("-------------------");

		System.out.println(ex2.getNome());
		System.out.println(ex2.getCpf());
	}
}
