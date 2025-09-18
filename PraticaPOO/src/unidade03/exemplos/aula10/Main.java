package unidade03.exemplos.aula10;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Veiculo fusca = new Veiculo("LXX-1010", "Fusca 1300", 1979);

		EventoAbastecimento abastecimento1 = new EventoAbastecimento(fusca);
		abastecimento1.setDescricao("Abastecimento dia 10/09");
		abastecimento1.setQuilomtragemRodada(300);
		abastecimento1.setData(LocalDate.now());

		Evento evento = new Evento(fusca);
		evento.setVeiculo(fusca);
		evento.setDescricao("Evento qualquer");

		System.out.println(abastecimento1.retornaDados());

		System.out.println(" ------------------------");

		System.out.println(evento.retornaDados());
	}
}
