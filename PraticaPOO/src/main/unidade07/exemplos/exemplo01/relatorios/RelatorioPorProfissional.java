package unidade07.exemplos.exemplo01.relatorios;

import javax.swing.JOptionPane;

import unidade07.exemplos.exemplo01.Projeto;
import unidade07.exemplos.exemplo01.Profissional;
import unidade07.exemplos.exemplo01.Sistema;
import unidade07.exemplos.exemplo01.SistemaUtils;

public class RelatorioPorProfissional implements Relatorio {

	@Override
	public int getCodigo() {
		return 3;
	}

	@Override
	public void imprimir(Sistema sistema) {
		String cpf = JOptionPane.showInputDialog("Informe o CPF do profissional:");

		if (cpf == null || cpf.isEmpty()) {
			JOptionPane.showMessageDialog(null, "CPF não informado. Operação cancelada.");
			return;
		}

		Profissional profissional = sistema.getProfissionalPorCpf(cpf);

		if (profissional == null) {
			JOptionPane.showMessageDialog(null, "Nenhum profissional encontrado com o CPF informado.");
			return;
		}

		if (profissional.getProjetos().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O profissional " + profissional.getNome() + " não possui projetos cadastrados.");
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("---------------------------------------------\n");
		sb.append("Relatório de Projetos de: ").append(profissional.getNome()).append("\n");
		sb.append("---------------------------------------------\n");
		sb.append(String.format("%-8s | %-15s | %-15s | %-12s\n", "Número", "Tipo Projeto", "Descrição", "Data Inclusão"));
		sb.append("---------------------------------------------\n");

		for (Projeto projeto : profissional.getProjetos()) {
			sb.append(String.format("%-8d | %-15s | %-15s | %-12s\n",
					projeto.getNumero(),
					projeto.getTipoProjeto(),
					projeto.getDescricao(),
					SistemaUtils.formatarData(projeto.getDataInclusao())));
		}

		sb.append("---------------------------------------------");

		JOptionPane.showMessageDialog(null, sb.toString(),
				"Relatório - Projetos de " + profissional.getNome(),
				JOptionPane.INFORMATION_MESSAGE);
	}
}
