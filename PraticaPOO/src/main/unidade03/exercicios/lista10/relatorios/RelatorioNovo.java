package unidade03.exercicios.lista10.relatorios;

import unidade03.exercicios.lista10.Sistema;

public class RelatorioNovo implements Relatorio {
	@Override
	public int getCodigo() {
		return 5;
	}

	@Override
	public void imprimir(Sistema sistema) {
		System.out.println("Novo relatorio");
	}
}
