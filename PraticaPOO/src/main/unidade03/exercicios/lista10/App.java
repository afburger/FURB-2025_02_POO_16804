package unidade03.exercicios.lista10;

import unidade03.exercicios.lista10.relatorios.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int opcaoMenu = 0;
		Sistema sistema = new Sistema();

		ArrayList<Relatorio> relatorios = new ArrayList<>();
		relatorios.add(new RelatorioCompleto());
		relatorios.add(new RelatorioPorTipo(scan));
		relatorios.add(new RelatorioResumido());
		relatorios.add(new RelatorioPorProfissional(scan));
		relatorios.add(new RelatorioNovo());

		while (opcaoMenu != 99) {
			exibeMenu();
			opcaoMenu = scan.nextInt();
			switch (opcaoMenu) {
				case 1:
					System.out.println("Informe o CPF do profissional");
					String cpf = scan.next();
					System.out.println("Informe o nome do profissional");
					String nome = scan.next();
					sistema.adicionarProfissional(cpf, nome);
					break;
				case 2:
					System.out.println("Informe a descrição do projeto");
					String descricao = scan.next();
					System.out.println("Informe o cpf do responsável principal");
					String cpfResponsavelPublico = scan.next();
					System.out.println("Informe o dia de inicio da obra");
					int dia = scan.nextInt();
					System.out.println("Informe o mes de inicio da obra");
					int mes = scan.nextInt();
					System.out.println("Informe o ano de inicio da obra");
					int ano = scan.nextInt();
					LocalDate dataInicio = LocalDate.of(ano, mes, dia);
					System.out.println("Informe o dia de fim da obra");
					int diaFim = scan.nextInt();
					System.out.println("Informe o mes de fim da obra");
					int mesFim = scan.nextInt();
					System.out.println("Informe o ano de fim da obra");
					int anoFim = scan.nextInt();
					LocalDate dataFim = LocalDate.of(anoFim, mesFim, diaFim);

					ArrayList<String> cpfsPublicos = new ArrayList<>();
					cpfsPublicos.add(cpfResponsavelPublico);
					sistema.adicionarProjetoPublico(descricao,  cpfsPublicos, dataInicio, dataFim);
					break;
				case 3:
					System.out.println("Informe a descrição do privado");
					String descricaoPrivado = scan.next();
					System.out.println("Informe o cpf do responsável principal");
					String cpfResponsavelPrivado = scan.next();
					System.out.println("Informe a metragem da obra");
					double metragem = scan.nextDouble();
					System.out.println("Informe o tipo da localização da obra \n 1 - Urbana \n 2 - Rural");
					int tipoArea = scan.nextInt();
					TipoArea area = null;
					if (tipoArea == 1) {
						area = TipoArea.AREA_URBANA;
					} else if (tipoArea == 2) {
						area = TipoArea.AREA_RURAL;
					}

					ArrayList<String> cpfsPrivados = new ArrayList<>();
					cpfsPrivados.add(cpfResponsavelPrivado);
					sistema.adicionarProjetoPrivado(descricaoPrivado,  cpfsPrivados, metragem, area);
					break;
				case 4:
					System.out.println("Informe o tipo de relatório que deseja gerar");
					System.out.println("1 - Completo");
					System.out.println("2 - Por tipo");
					System.out.println("3 - Por profissional");
					System.out.println("4 - Resumido");
					System.out.println("5 - Novo relatorio");
					int opcaoRelatorio = scan.nextInt();

					for (Relatorio rel : relatorios) {
						if (opcaoRelatorio == rel.getCodigo()) {
							rel.imprimir(sistema);
						}
					}

					break;
				case 99:
					System.out.println("Saindo do sistema");
					break;
				default:
					System.out.println("Opção inválida, tente novamente");
					break;
			}

		}

		scan.close();
	}

	private static void exibeMenu() {
		System.out.println("1 - Para inserir um profissional");
		System.out.println("2 - Para inserir um projeto público");
		System.out.println("3 - Para inserir um projeto privado");
		System.out.println("4 - Para gerar relatórios");
		System.out.println("99 - Para sair do sistema");


	}
}
