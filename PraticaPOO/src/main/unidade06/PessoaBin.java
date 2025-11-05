package unidade06;

import java.io.Serializable;

/**
 *
 * @author André Felipe Bürger (afburger@furb.com.br)
 *
 */
public class PessoaBin implements Serializable {

	private int codigo;
	private String nome;
	private int idade;

	public PessoaBin(int codigo, String nome, int idade) {
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Código: ").append(getCodigo()).append(" - ").append("Nome: ").append(getNome()).append(" - ").append("Idade: ").append(getIdade());
		return sb.toString();
	}
}
