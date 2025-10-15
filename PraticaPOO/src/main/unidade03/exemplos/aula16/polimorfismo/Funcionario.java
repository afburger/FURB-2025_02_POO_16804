package unidade03.exemplos.aula16.polimorfismo;

public class Funcionario {

	private String nome;
	private double salarioBase;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double calcularSalario() {
		return salarioBase;
	}
}
