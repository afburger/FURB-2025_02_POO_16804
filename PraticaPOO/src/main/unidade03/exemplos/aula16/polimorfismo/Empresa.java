package unidade03.exemplos.aula16.polimorfismo;

import java.util.ArrayList;

public class Empresa {

	private ArrayList<Funcionario> funcionarios = new ArrayList<>();

	public void incluirFuncionario(Funcionario f) {
		funcionarios.add(f);
	}

	public double calcularFolhaSalarial() {
		double totalSalarios = 0.0;
		for (Funcionario f : funcionarios) {

			if (f instanceof Vendedor) {
				ArrayList vendas = ((Vendedor) f).getVendas();
				if (vendas != null && !vendas.isEmpty()) {
					System.out.println("O Vendeor deve receber comissão");
				}
			}

			totalSalarios += f.calcularSalario();
		}
		return totalSalarios;
	}



}
