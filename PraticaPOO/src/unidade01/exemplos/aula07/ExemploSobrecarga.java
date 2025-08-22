package unidade01.exemplos.aula07;

public class ExemploSobrecarga {

	private double peso;
	private double altura;
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double calcularImc() {
		return peso / (altura * altura);
	}

	public double calcularImc(double limite) {
		double imc = calcularImc();
		if (imc > limite) {
			System.out.println("Vai pra academia!");
		}
		return imc;
	}

}
