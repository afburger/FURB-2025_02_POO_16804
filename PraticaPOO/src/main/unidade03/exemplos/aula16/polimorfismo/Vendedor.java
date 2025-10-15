package unidade03.exemplos.aula16.polimorfismo;

import java.util.ArrayList;

public class Vendedor extends Funcionario {

	private double percentualComissao;

	private ArrayList<Venda> vendas = new ArrayList<>();

	public void setPercentualComissao(double percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void adicionarVenda(Venda venda) {
		this.vendas.add(venda);
	}

	private double getTotalVendas() {
		double total = 0.0;
		for (Venda v : vendas) {
			total += v.getValor();
		}
		return total;
	}

	@Override
	public double calcularSalario() {
		if (percentualComissao != 0.0) {
			double vendas = getTotalVendas();
			double comissao = vendas  * (percentualComissao/100);
			return super.calcularSalario() + comissao;
		}
		return  super.calcularSalario();
	}
}
