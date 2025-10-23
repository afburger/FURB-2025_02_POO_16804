package unidade03.exercicios.lista10.relatorios;

import unidade03.exercicios.lista10.Profissional;
import unidade03.exercicios.lista10.Projeto;
import unidade03.exercicios.lista10.Sistema;
import unidade03.exercicios.lista10.SistemaUtils;

import java.util.Scanner;

public class RelatorioPorProfissional implements Relatorio {

	private Scanner scan;

	public RelatorioPorProfissional(Scanner scan) {
		this.scan = scan;
	}

	@Override
	public int getCodigo() {
		return 3;
	}

	@Override
	public void imprimir(Sistema sistema) {
		System.out.println("Informe o cpf do profissional:");
		String cpf = scan.next();

		Profissional profissional = sistema.getProfissionalPorCpf(cpf);
		System.out.println("---------------------------------------------");
		System.out.println("Relatório de projetos do " + profissional.getNome());
		System.out.println("---------------------------------------------");
		System.out.println("Número | Tipo projeto | Descrição | Data Inclusão");
		System.out.println("---------------------------------------------");
		for (Projeto projeto : profissional.getProjetos()) {
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
