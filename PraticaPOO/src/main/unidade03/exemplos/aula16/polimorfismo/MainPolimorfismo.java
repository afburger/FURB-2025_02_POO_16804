package unidade03.exemplos.aula16.polimorfismo;

import java.time.LocalDate;

public class MainPolimorfismo {

	public static void main(String[] args) {

		Empresa empresa = new Empresa();

		Funcionario f1;
		f1 = new Funcionario();
		f1.setNome("Nome1");
		f1.setSalarioBase(1500.0);

		empresa.incluirFuncionario(f1);

		f1 = new Funcionario();
		f1.setNome("Nome 2");
		f1.setSalarioBase(3000.0);

		empresa.incluirFuncionario(f1);

		empresa.incluirFuncionario(new Programador());

		f1 = new Vendedor();
		f1.setNome("Vendedor 1");
		f1.setSalarioBase(2000.0);
		((Vendedor) f1).setPercentualComissao(10.0);
		((Vendedor) f1).adicionarVenda(new Venda(5000.0, LocalDate.now()));
		empresa.incluirFuncionario(f1);

		f1 = new Vendedor();
		f1.setNome("Vendedor 2");
		f1.setSalarioBase(4000.0);

		empresa.incluirFuncionario(f1);


		System.out.println("Salário total: " + empresa.calcularFolhaSalarial());
	}
}
