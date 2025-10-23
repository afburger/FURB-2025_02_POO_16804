package unidade03.exercicios.lista10.relatorios;

import unidade03.exercicios.lista10.Projeto;
import unidade03.exercicios.lista10.Sistema;
import unidade03.exercicios.lista10.SistemaUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RelatorioResumido implements Relatorio {

	@Override
	public int getCodigo() {
		return 4;
	}

	@Override
	public void imprimir(Sistema sistema) {
		System.out.println("---------------------------------------------");
		System.out.println("Relatório resumido de projetos");
		System.out.println("---------------------------------------------");
		System.out.println("Número | Tipo projeto | Data Inclusão");
		System.out.println("---------------------------------------------");
		for (Projeto projeto : sistema.getProjetos()) {
			StringBuilder sb = new StringBuilder();
			sb.append(projeto.getNumero())
					.append(" | ")
					.append(projeto.getTipoProjeto())
					.append(" | ")
					.append(SistemaUtils.formatarData(projeto.getDataInclusao()))
					.append(" | ")
			;
			System.out.println(sb.toString());
		}
		System.out.println("---------------------------------------------");
	}
}
