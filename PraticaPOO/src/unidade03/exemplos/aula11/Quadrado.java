package unidade03.exemplos.aula11;

public class Quadrado extends Figura {

	private int base;

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	@Override
	public void desenhar() {
		System.out.println("Qudrado é desenhado pela base: " + base + "ao quadrado");
	}
}
