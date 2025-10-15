package unidade02.revisao;

import java.util.ArrayList;

public class Licitacao {

	private ArrayList<Item> itens = new ArrayList<>();

	public void adicionarItem(String nome, int quantidade, double preco) {
		Item item = new Item(nome, quantidade, preco, this);
		itens.add(item);
	}
}
