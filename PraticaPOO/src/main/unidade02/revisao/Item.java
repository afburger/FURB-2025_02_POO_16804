package unidade02.revisao;

public class Item {

	private String nome;
	private int quantidade;
	private double valorUnitario;
	private Licitacao licitacao;

	public Item(String nome, int quantidade, double valor, Licitacao licitacao) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorUnitario = valor;
		this.licitacao = licitacao;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}
}
