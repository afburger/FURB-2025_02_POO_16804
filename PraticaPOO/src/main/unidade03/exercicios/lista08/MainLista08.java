package unidade03.exercicios.lista08;

import java.time.LocalDate;

public class MainLista08 {
	public static void main(String[] args) {
		Tutor tutor1 = new Tutor("João", "001.002.003-45");
		Tutor tutor2 = new Tutor("José", "222.333.444-55", "3333-1010", "Rua Antônio da Veiga, 140");

		Veterinario veterinario1 = new Veterinario("André", "333.333.333-44", "4559/CRMV-SC", "Especialista Canino");
		Veterinario vet2 = new Veterinario("Vet2", "cpf", "crmv", "especialista");


		System.out.println("Resumo de tutor");
		System.out.println(tutor1.getResumo());
		System.out.println(tutor2.getResumo());

		System.out.println("-------------------");
		System.out.println("Resumo de veterinario");
		System.out.println(veterinario1.getResumo());
		System.out.println(vet2.getResumo());

	}
}
