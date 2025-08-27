package unidade01.exercicios.lista03.questao01;

public class FuncionarioDois {

	private static double faixa1 = 1903.98;
	private static double faixa2 = 2826.65;
	private static double faixa3 = 3751.05;
	private static double faixa4 = 4664.68;

	private static double percentualFaixa2 = 7.5;
	private static double percentualFaixa3 = 15.0;
	private static double percentualFaixa4 = 22.5;
	private static double percentualFaixa5 = 27.5;

	private static double cemPorcento = 100.0;

	private String nome;
	private double salario;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setSalario(double salario) {
		if (salario < 0) {
			System.out.println("Salário inválido");
		} else {
			this.salario = salario;
		}
	}

	public double getSalario() {
		return salario;
	}

	public double calcularIrpf() {
		double imposto = 0;
		double diferenca = 0;

		// Calculo Faixa 2;
		if (salario > faixa1) {
			diferenca = Math.min(salario, faixa2) - faixa1;
			imposto += diferenca * (percentualFaixa2 / cemPorcento);
		}

		// Calculo Faixa 3;
		if (salario > faixa2) {
			diferenca = Math.min(salario, faixa3) - faixa2;
			imposto += diferenca * (percentualFaixa3 / cemPorcento);
		}

		// Calculo Faixa 4;
		if (salario > faixa3) {
			diferenca = Math.min(salario, faixa4) - faixa3;
			imposto += diferenca * (percentualFaixa3 / cemPorcento);
		}

		// Calculo Faixa 5;
		if (salario > faixa4) {
			diferenca = salario - faixa4;
			imposto += diferenca * (percentualFaixa5 / cemPorcento);
		}

		return imposto;
	}
}
