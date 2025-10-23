package unidade03.exercicios.lista10.relatorios;

import unidade03.exercicios.lista10.Projeto;
import unidade03.exercicios.lista10.Sistema;
import unidade03.exercicios.lista10.SistemaUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RelatorioCompleto implements Relatorio {

	@Override
	public int getCodigo() {
		return 1;
	}

	@Override
	public void imprimir(Sistema sistema) {
		ArrayList<Projeto> projetos = sistema.getProjetos();
		Collections.sort(projetos, new Comparator<Projeto>() {
			@Override
			public int compare(Projeto o1, Projeto o2) {
				return Integer.compare(o1.getNumero(), o2.getNumero());
			}
		});

		System.out.println("---------------------------------------------");
		System.out.println("Relatório de projetos ordenados por número");
		System.out.println("---------------------------------------------");
		System.out.println("Número | Tipo projeto | Descrição | Data Inclusão");
		System.out.println("---------------------------------------------");
		for (Projeto projeto : projetos) {
			StringBuilder sb = new StringBuilder();
			sb.append(projeto.getNumero())
				.append(" | ")
				.append(projeto.getTipoProjeto())
				.append(" | ")
				.append(projeto.getDescricao())
				.append(" | ")
				.append(SistemaUtils.formatarData(projeto.getDataInclusao()))
			;
			System.out.println(sb.toString());
		}
		System.out.println("---------------------------------------------");
	}
}
