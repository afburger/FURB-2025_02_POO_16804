package unidade07.exemplos.exemplo01.relatorios;

import javax.swing.JOptionPane;

import unidade07.exemplos.exemplo01.Projeto;
import unidade07.exemplos.exemplo01.Sistema;
import unidade07.exemplos.exemplo01.SistemaUtils;

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
			JOptionPane.showMessageDialog(null, sb.toString(), "Relatório - Projetos Resumidos", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
