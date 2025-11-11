package unidade07.exemplos.exemplo01.relatorios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import unidade07.exemplos.exemplo01.Projeto;
import unidade07.exemplos.exemplo01.Sistema;
import unidade07.exemplos.exemplo01.SistemaUtils;

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
			JOptionPane.showMessageDialog(null, sb.toString(), "Relatório - Projetos Completo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
