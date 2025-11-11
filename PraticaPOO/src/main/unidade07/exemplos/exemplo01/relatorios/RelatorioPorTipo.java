package unidade07.exemplos.exemplo01.relatorios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import unidade07.exemplos.exemplo01.Projeto;
import unidade07.exemplos.exemplo01.ProjetoPrivado;
import unidade07.exemplos.exemplo01.ProjetoPublico;
import unidade07.exemplos.exemplo01.Sistema;
import unidade07.exemplos.exemplo01.SistemaUtils;
import unidade07.exemplos.exemplo01.TipoProjeto;

public class RelatorioPorTipo implements Relatorio {

	@Override
	public int getCodigo() {
		return 2;
	}

	@Override
	public void imprimir(Sistema sistema) {
		int opcao = 0;
		try {
			String entrada = JOptionPane.showInputDialog("""
                    Informe o filtro que deseja realizar:
                    1 - Projetos Públicos
                    2 - Projetos Privados
                    """);
			opcao = Integer.parseInt(entrada);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Entrada inválida! Retornando ao menu principal.");
			return;
		}

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

		} else {
			JOptionPane.showMessageDialog(null, "Opção inválida!");
		}
	}

	private static void relatorioProjetosPrivados(ArrayList<ProjetoPrivado> privados) {
		if (privados.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há projetos privados cadastrados.");
			return;
		}

		Collections.sort(privados, Comparator.comparingInt(ProjetoPrivado::getNumero));

		StringBuilder sb = new StringBuilder();
		sb.append("---------------------------------------------\n");
		sb.append("Relatório de Projetos Privados por Número\n");
		sb.append("---------------------------------------------\n");
		sb.append(String.format("%-8s | %-15s | %-10s | %-10s\n", "Número", "Descrição", "Área", "Metragem"));
		sb.append("---------------------------------------------\n");

		for (ProjetoPrivado privado : privados) {
			sb.append(String.format("%-8d | %-15s | %-10s | %-10.2f\n",
					privado.getNumero(),
					privado.getDescricao(),
					privado.getTipoArea(),
					privado.getMetragem()));
		}
		sb.append("---------------------------------------------");

		JOptionPane.showMessageDialog(null, sb.toString(), "Relatório - Projetos Privados", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void relatorioProjetosPublicos(ArrayList<ProjetoPublico> publicos) {
		if (publicos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há projetos públicos cadastrados.");
			return;
		}

		Collections.sort(publicos, Comparator.comparingInt(ProjetoPublico::getNumero));

		StringBuilder sb = new StringBuilder();
		sb.append("---------------------------------------------\n");
		sb.append("Relatório de Projetos Públicos por Número\n");
		sb.append("---------------------------------------------\n");
		sb.append(String.format("%-8s | %-15s | %-12s | %-12s\n", "Número", "Descrição", "Início", "Fim"));
		sb.append("---------------------------------------------\n");

		for (ProjetoPublico publico : publicos) {
			sb.append(String.format("%-8d | %-15s | %-12s | %-12s\n",
					publico.getNumero(),
					publico.getDescricao(),
					SistemaUtils.formatarData(publico.getDataInicio()),
					SistemaUtils.formatarData(publico.getDataFim())));
		}
		sb.append("---------------------------------------------");

		JOptionPane.showMessageDialog(null, sb.toString(), "Relatório - Projetos Públicos", JOptionPane.INFORMATION_MESSAGE);
	}
}
