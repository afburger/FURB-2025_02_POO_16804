package unidade02.revisao;

import java.util.List;

public class GeradorRelatorio {

	public static void gerarRelatorio(List<ObjetoRelatorio> objetos) {
		for (ObjetoRelatorio obj : objetos) {
			System.out.println(obj.imprimir());
		}
	}
}
