package unidade03.exemplos.aula11;

public class Retangulo extends FiguraDoisLados {

	@Override
	public void desenhar() {
		System.out.println("Para desenhar o retângulo é a altura:" + getLadoA() + " x a largura: " + getLadoB());
	}
}
