package unidade05;

import java.util.HashMap;
import java.util.Map;

public class ExemploMap {

	public static void main(String[] args) {

		Map<Integer, PessoaLista> mapPessoas = new HashMap<>();

		PessoaLista p1 = new PessoaLista(55, "André");
		PessoaLista p2 = new PessoaLista(2, "Felipe");
		PessoaLista p3 = new PessoaLista(3, "José");

		mapPessoas.put(p1.getCodigo(), p1);
		mapPessoas.put(p2.getCodigo(), p2);

		if (!mapPessoas.containsKey(p3.getCodigo())) {
			mapPessoas.put(p3.getCodigo(), p3);
		}

		System.out.println("Imprime o objeto com código/chave 2");
		System.out.println(mapPessoas.get(2));


		System.out.println("Imprime os valores do mapa");
		for (PessoaLista p : mapPessoas.values()) {
			System.out.println(p);
		}



	}
}
