package unidade03.exercicios.lista09;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainLista09 {
	public static void main(String[] args) {

		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Veterinario("André", "333.333.333-44", "4559/CRMV-SC", "Especialista Canino"));
		pessoas.add(new Tutor("João", "001.002.003-45"));
		pessoas.add(new Tutor("José", "222.333.444-55", "3333-1010", "Rua Antônio da Veiga, 140"));
		pessoas.add(new Veterinario("Vet2", "cpf", "crmv", "especialista"));

		for (Pessoa p : pessoas) {
			p.registrarNoSistema();
		}


		Animal animal = new Animal("Apolo", ((Tutor) pessoas.get(1)));

		ArrayList<Atendimento> atendimentos = new ArrayList<>();
		atendimentos.add(new AtendimentoEmergencia(LocalDate.now(), "Atendimento emergência", animal, ((Veterinario) pessoas.get(0))));
		atendimentos.add(new AtendimentoRetorno(LocalDate.now(), "Atendimento de retorno", animal, ((Veterinario) pessoas.get(0))));

		for (Atendimento a : atendimentos) {
			a.registrarNoSistema();
		}


		System.out.println("Get resumo de pessoas");
		for (Pessoa p : pessoas) {
			System.out.println(p.getResumo());
		}

		System.out.println("----------------------------");
		System.out.println("Exibir resumo de atendimento");
		System.out.println("----------------------------");
		for (Atendimento a : atendimentos) {
			System.out.println(a.exibirResumo());
			System.out.println(a.getDescricaoPagamento());
		}

	}
}
