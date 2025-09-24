package unidade03.exemplos.aula11;

public class Main {

	public static void main(String[] args) {
		Retangulo ret = new Retangulo();
		ret.setAltura(10);
		ret.setLargura(5);
		ret.desenhar();

		Figura estrla = new Figura() {
			@Override
			public void desenhar() {
				System.out.println("Estrela de 5 pontas");
			}
		};

		estrla.desenhar();

	}
}
