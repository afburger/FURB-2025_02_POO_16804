package unidade03.exercicios.lista10.relatorios;

import unidade03.exercicios.lista10.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RelatorioPorTipo implements Relatorio {

	private Scanner scan;

	public RelatorioPorTipo(Scanner scan) {
		this.scan = scan;
	}

	@Override
	public int getCodigo() {
		return 2;
	}

	@Override
	public void imprimir(Sistema sistema) {
		System.out.println("Informe o filtro que deseja realizar:");
		System.out.println("1 - Projetos Públicos");
		System.out.println("2 - Projetos Privados");
		int opcao = scan.nextInt();

		ArrayList<Projeto> projetos = sistema.getProjetos();
		if (opcao == 1) {
			ArrayList<ProjetoPublico> publicos = new ArrayList<>();
			for (Projeto projeto : projetos) {
				if (TipoProjeto.PROJETO_PUBLICO.equals(projeto.getTipoProjeto())) {
					publicos.add((ProjetoPublico) projeto);

				}
			}
			relatorioProjetosPublicos(publicos);

		} else if (opcao == 2) {
			ArrayList<ProjetoPrivado> privados = new ArrayList<>();
			for (Projeto projeto : projetos) {
				if (TipoProjeto.PROJETO_PRIVADO.equals(projeto.getTipoProjeto())) {
					privados.add((ProjetoPrivado) projeto);

				}
			}
			relatorioProjetosPrivados(privados);
		}
	}

	private static void relatorioProjetosPrivados(ArrayList<ProjetoPrivado> privados) {
		Collections.sort(privados, new Comparator<ProjetoPrivado>() {
			@Override
			public int compare(ProjetoPrivado o1, ProjetoPrivado o2) {
				return Integer.compare(o1.getNumero(), o2.getNumero());
			}
		});
		System.out.println("---------------------------------------------");
		System.out.println("Relatório de projetos privados por número");
		System.out.println("---------------------------------------------");
		System.out.println("Número | Descrição | Área | Metragem");
		System.out.println("---------------------------------------------");
		for (ProjetoPrivado privado : privados) {
			StringBuilder sb = new StringBuilder();
			sb.append(privado.getNumero())
					.append(" | ")
					.append(privado.getTipoProjeto())
					.append(" | ")
					.append(privado.getDescricao())
					.append(" | ")
					.append(privado.getTipoArea())
					.append(" | ")
					.append(privado.getMetragem())
					.append(" | ")

			;
			System.out.println(sb.toString());
		}
		System.out.println("---------------------------------------------");
	}

	private static void relatorioProjetosPublicos(ArrayList<ProjetoPublico> publicos) {
		Collections.sort(publicos, new Comparator<ProjetoPublico>() {
			@Override
			public int compare(ProjetoPublico o1, ProjetoPublico o2) {
				return Integer.compare(o1.getNumero(), o2.getNumero());
			}
		});
		System.out.println("---------------------------------------------");
		System.out.println("Relatório de projetos publicos por número");
		System.out.println("---------------------------------------------");
		System.out.println("Número | Descrição | Início | Fim");
		System.out.println("---------------------------------------------");
		for (ProjetoPublico publico : publicos) {
			StringBuilder sb = new StringBuilder();
			sb.append(publico.getNumero())
					.append(" | ")
					.append(publico.getTipoProjeto())
					.append(" | ")
					.append(publico.getDescricao())
					.append(" | ")
					.append(SistemaUtils.formatarData(publico.getDataInicio()))
					.append(" | ")
					.append(SistemaUtils.formatarData(publico.getDataFim()))
					.append(" | ")
			;
			System.out.println(sb.toString());
		}
		System.out.println("---------------------------------------------");
	}
}
