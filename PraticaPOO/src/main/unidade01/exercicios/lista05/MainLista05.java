package unidade01.exercicios.lista05;

public class MainLista05 {
	public static void main(String[] args) {
		// Cadastrando 2 tutores
		Tutor tutor1 = new Tutor("João", "9999-8888", "Rua A, 123");
		Tutor tutor2 = new Tutor("Maria", "1111-2222", "Rua B, 456");

		System.out.println("Tutores cadastrados:");
		System.out.println("- " + tutor1.getNome());
		System.out.println("- " + tutor2.getNome());
		System.out.println("--------------------");


		// Criando 3 animais
		Animal animal1 = new Animal("Rex", "Cachorro", 5, "Nenhuma vacina");
		animal1.adicionarHistorico("Vacinado contra raiva");
		Animal animal2 = new Animal("Mimi", "Gato", 2, "Castrada");
		Animal animal3 = new Animal("Loro", "Papagaio", 10, "Saudável");

		System.out.println("Animais cadastrados:");
		System.out.println("- " + animal1.getNome() + ", Histórico: " + animal1.getHistorico());
		System.out.println("- " + animal2.getNome() + ", Histórico: " + animal2.getHistorico());
		System.out.println("- " + animal3.getNome() + ", Histórico: " + animal3.getHistorico());
		System.out.println("--------------------");


		// Testando casos de exceção
		System.out.println("Testando exceções:");

		// Teste 1: Animal com idade negativa
		try {
			new Animal("Fantasma", "Desconhecido", -1, "Nenhum");
		} catch (IllegalArgumentException e) {
			System.out.println("Exceção capturada ao criar animal com idade negativa: " + e.getMessage());
		}

		// Teste 2: Tutor sem telefone
		try {
			new Tutor("José", null, "Rua C, 789");
		} catch (IllegalArgumentException e) {
			System.out.println("Exceção capturada ao criar tutor sem telefone: " + e.getMessage());
		}

		System.out.println("--------------------");
		System.out.println("Execução finalizada corretamente.");
	}
}
