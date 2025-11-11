package unidade07.exemplos.exemplo01;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import unidade07.exemplos.exemplo01.relatorios.Relatorio;
import unidade07.exemplos.exemplo01.relatorios.RelatorioCompleto;
import unidade07.exemplos.exemplo01.relatorios.RelatorioPorProfissional;
import unidade07.exemplos.exemplo01.relatorios.RelatorioPorTipo;
import unidade07.exemplos.exemplo01.relatorios.RelatorioResumido;

public class App {

	public static void main(String[] args) {

		int opcaoMenu = 0;
		Sistema sistema = new Sistema();

		ArrayList<Relatorio> relatorios = new ArrayList<>();
		relatorios.add(new RelatorioCompleto());
		relatorios.add(new RelatorioPorTipo());
		relatorios.add(new RelatorioResumido());
		relatorios.add(new RelatorioPorProfissional());

		while (opcaoMenu != 99) {
			try {
				String menu = "Escolha uma opção:\n"
						+ "1 - Inserir um profissional\n"
						+ "2 - Inserir um projeto público\n"
						+ "3 - Inserir um projeto privado\n"
						+ "4 - Gerar relatórios\n"
						+ "99 - Sair do sistema";
				opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog(menu));

				switch (opcaoMenu) {
					case 1 -> {
						String cpf = JOptionPane.showInputDialog("Informe o CPF do profissional:");
						String nome = JOptionPane.showInputDialog("Informe o nome do profissional:");
						sistema.adicionarProfissional(cpf, nome);
						JOptionPane.showMessageDialog(null, "Profissional adicionado com sucesso!");
					}
					case 2 -> {
						String descricao = JOptionPane.showInputDialog("Informe a descrição do projeto público:");
						String cpfResponsavel = JOptionPane.showInputDialog("Informe o CPF do responsável principal:");

						int diaInicio = Integer.parseInt(JOptionPane.showInputDialog("Informe o dia de início da obra:"));
						int mesInicio = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês de início da obra:"));
						int anoInicio = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de início da obra:"));
						LocalDate dataInicio = LocalDate.of(anoInicio, mesInicio, diaInicio);

						int diaFim = Integer.parseInt(JOptionPane.showInputDialog("Informe o dia de término da obra:"));
						int mesFim = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês de término da obra:"));
						int anoFim = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de término da obra:"));
						LocalDate dataFim = LocalDate.of(anoFim, mesFim, diaFim);

						ArrayList<String> cpfsPublicos = new ArrayList<>();
						cpfsPublicos.add(cpfResponsavel);

						sistema.adicionarProjetoPublico(descricao, cpfsPublicos, dataInicio, dataFim);
						JOptionPane.showMessageDialog(null, "Projeto público adicionado com sucesso!");
					}
					case 3 -> {
						String descricaoPrivado = JOptionPane.showInputDialog("Informe a descrição do projeto privado:");
						String cpfResponsavel = JOptionPane.showInputDialog("Informe o CPF do responsável principal:");
						double metragem = Double.parseDouble(JOptionPane.showInputDialog("Informe a metragem da obra:"));

						int tipoArea = Integer.parseInt(JOptionPane.showInputDialog(
								"Informe o tipo da localização da obra:\n1 - Urbana\n2 - Rural"));
						TipoArea area = (tipoArea == 1) ? TipoArea.AREA_URBANA : TipoArea.AREA_RURAL;

						ArrayList<String> cpfsPrivados = new ArrayList<>();
						cpfsPrivados.add(cpfResponsavel);

						sistema.adicionarProjetoPrivado(descricaoPrivado, cpfsPrivados, metragem, area);
						JOptionPane.showMessageDialog(null, "Projeto privado adicionado com sucesso!");
					}
					case 4 -> {
						int opcaoRelatorio = Integer.parseInt(JOptionPane.showInputDialog("""
                                Escolha o tipo de relatório:
                                1 - Completo
                                2 - Por tipo
                                3 - Por profissional
                                4 - Resumido
                                """));

						boolean encontrado = false;
						for (Relatorio rel : relatorios) {
							if (opcaoRelatorio == rel.getCodigo()) {
								rel.imprimir(sistema); // assumindo que já imprime via JOptionPane
								encontrado = true;
								break;
							}
						}

						if (!encontrado) {
							JOptionPane.showMessageDialog(null, "Tipo de relatório inválido!");
						}
					}
					case 99 -> JOptionPane.showMessageDialog(null, "Saindo do sistema...");
					default -> JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			}
		}
	}
}
