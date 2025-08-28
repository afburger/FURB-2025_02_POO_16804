package unidade01.exemplos.aula07;

public class AppLancarException {

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("André");
		funcionario.setSalario(-10000.00);

		System.out.println("IRPF: " + funcionario.calcularIrpf());
	}
}
