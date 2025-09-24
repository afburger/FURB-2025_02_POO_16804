package unidade03.exemplos.aula11;

public class Circulo extends Figura {

	private int raio;

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	@Override
	public void desenhar() {
		System.out.println("A forma de desenhar o círculo é o raio " + raio + "ao quadrado");
	}
}
