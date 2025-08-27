package unidade01.exercicios.lista04.quesao01;

public class Funcionario {

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
			System.out.println("Valor inválido");
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

		if (salario > faixa1) {
			// Faixa 2
			if (salario <= faixa2) {
				diferenca = salario - faixa1;
				imposto = diferenca * (percentualFaixa2 / cemPorcento);
			} else if (salario <= faixa3) { // Faixa 3
				// Calcular da faixa 2
				diferenca = faixa2 - faixa1;
				imposto = diferenca * (percentualFaixa2 / cemPorcento);

				// Calcular da faixa 3
				diferenca = salario - faixa2;
				imposto += diferenca * (percentualFaixa3 / cemPorcento);
			} else if (salario <= faixa4) {
				// Calcular da faixa 2
				diferenca = faixa2 - faixa1;
				imposto = diferenca * (percentualFaixa2 / cemPorcento);

				// Calcular da faixa 3
				diferenca = faixa3 - faixa2;
				imposto += diferenca * (percentualFaixa3 / cemPorcento);

				// Calcular da faixa 4
				diferenca = salario - faixa3;
				imposto += diferenca * (percentualFaixa4 / cemPorcento);
			} else {
				// Calcular da faixa 2
				diferenca = faixa2 - faixa1;
				imposto = diferenca * (percentualFaixa2 / cemPorcento);

				// Calcular da faixa 3
				diferenca = faixa3 - faixa2;
				imposto += diferenca * (percentualFaixa3 / cemPorcento);

				// Calcular da faixa 4
				diferenca = faixa4 - faixa3;
				imposto += diferenca * (percentualFaixa4 / cemPorcento);

				diferenca = salario - faixa4;
				imposto += diferenca * (percentualFaixa5 / cemPorcento);
			}
		}
		return imposto;
	}
}
