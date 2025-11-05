package unidade05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploListaOrdenacao {

	public static void main(String[] args) {
		List<PessoaLista> listaPessoa = new ArrayList<>();

		PessoaLista p1 = new PessoaLista(55, "André");
		PessoaLista p2 = new PessoaLista(2, "Felipe");
		PessoaLista p3 = new PessoaLista(3, "José");

		listaPessoa.add(p1);
		listaPessoa.add(p2);
		listaPessoa.add(p3);

		System.out.println("Imprime a lista sem ordenação");
		for(PessoaLista p : listaPessoa) {
			System.out.println(p);
		}

		System.out.println("Imprime a lista com ordenação natural (código)");

		Collections.sort(listaPessoa);

		listaPessoa.add(new PessoaLista(1, "AAA"));

		for(PessoaLista p : listaPessoa) {
			System.out.println(p);
		}

		System.out.println("Imprime a lista com ordenação artificial (alfabética)");

		Comparator<PessoaLista> comparador = new Comparator<PessoaLista>() {
			@Override
			public int compare(PessoaLista o1, PessoaLista o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		};

		Collections.sort(listaPessoa, comparador);

		for(PessoaLista p : listaPessoa) {
			System.out.println(p);
		}


		PessoaLista pX = new PessoaLista(99, "Zequinha");
		PessoaLista py = new PessoaLista(99, "Zequinha");

		if (pX.equals(py)) {
			System.out.println("Objetos iguais");
		} else {
			System.out.println("Objetos diferentes");
		}


	}
}
