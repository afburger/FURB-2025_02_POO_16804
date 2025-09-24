package unidade02.exercicios.lista06;

import java.time.LocalDate;

public class MainLista06 {
	public static void main(String[] args) {
		// i. Criar tutores, animais e veterinários.
		// iv. Relacionar veterinários com supervisores.

		// Veterinários
		Veterinario vetSupervisor = new Veterinario("Dr. House", "1234-SC", "Clínico Geral Sênior");
		Veterinario vet1 = new Veterinario("Dr. Chase", "5678-SC", "Clínico Geral");
		Veterinario vet2 = new Veterinario("Dr. Foreman", "9101-SC", "Neurologista");

		// Relacionar veterinários com supervisores
		vet1.setSupervisor(vetSupervisor);
		vet2.setSupervisor(vetSupervisor);

		// Tutores
		Tutor tutor1 = new Tutor("João da Silva", "47 9999-0001", "Rua das Flores, 10");
		Tutor tutor2 = new Tutor("Maria Souza", "47 9888-0002", "Avenida Brasil, 500");

		// ii. Associar animais a seus tutores.
		// Animais
		Animal animal1 = new Animal("Rex", tutor1);
		animal1.setEspecie("Cachorro");
		animal1.setIdade(5);
		animal1.adicionarHistorico("Nascido em 2019. Vacinado.");
		tutor1.adicionarAnimal(animal1);

		Animal animal2 = new Animal("Mimi", tutor1);
		animal2.setEspecie("Gato");
		animal2.setIdade(3);
		animal2.adicionarHistorico("Encontrada na rua em 2021.");
		tutor1.adicionarAnimal(animal2);

		Animal animal3 = new Animal("Loro", tutor2);
		animal3.setEspecie("Papagaio");
		animal3.setIdade(10);
		animal3.adicionarHistorico("Saudável.");
		tutor2.adicionarAnimal(animal3);


		// iii. Criar atendimentos com procedimentos para os animais.
		// Atendimento 1 para o Rex
		Atendimento atendimento1 = new Atendimento(LocalDate.now(), "Consulta de rotina", animal1, vet1);
		Procedimento proc1 = new Procedimento("Exame de sangue");
		proc1.setCusto(120.00);
		proc1.setObservacoes("Coleta realizada com sucesso.");
		atendimento1.adicionarProcedimento(proc1);
		animal1.adicionarAtendimento(atendimento1);

		// Atendimento 2 para a Mimi
		Atendimento atendimento2 = new Atendimento(LocalDate.now().minusDays(1), "Animal apático e sem apetite", animal2, vet2);
		Procedimento proc2 = new Procedimento("Raio-X");
		proc2.setCusto(150.00);
		atendimento2.adicionarProcedimento(proc2);
		Procedimento proc3 = new Procedimento("Medicação intravenosa");
		proc3.setCusto(80.00);
		atendimento2.adicionarProcedimento(proc3);
		animal2.adicionarAtendimento(atendimento2);

		// Exibir os dados para verificação
		System.out.println("--- DADOS DOS VETERINÁRIOS ---");
		System.out.println(vetSupervisor.retornaDados());
		System.out.println(vet1.retornaDados());
		System.out.println(vet2.retornaDados());
		System.out.println("\n--- DADOS DOS ATENDIMENTOS ---");
		System.out.println(atendimento1.exibirDados());
		System.out.println("--------------------");
		System.out.println(atendimento2.exibirDados());

		System.out.println("\n--- DADOS DO TUTOR E SEUS ANIMAIS ---");
		System.out.println("Tutor: " + tutor1.getNome());
		for (Animal animal : tutor1.getAnimais()) {
			System.out.println("  - Animal: " + animal.getNome() + " (" + animal.getEspecie() + ")");
			System.out.println("    Histórico de atendimentos:");
			if (animal.getAtendimentos().isEmpty()) {
				System.out.println("      * Nenhum atendimento registrado.");
			} else {
				for (Atendimento atendimento : animal.getAtendimentos()) {
					System.out.println("      * Data: " + atendimento.getData() + " - Desc: " + atendimento.getDescricao());
				}
			}
		}
	}
}
