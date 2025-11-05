package unidade05;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PessoaLista implements Comparable<PessoaLista> {

	private Integer codigo;
	private String nome;

	public PessoaLista(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return codigo + " - " + nome;
	}

	@Override
	public int compareTo(PessoaLista o) {
//		if (this.codigo < o.getCodigo()) {
//			return -1;
//		}
//		if (this.codigo > o.getCodigo()) {
//			return 1;
//		}
//		return 0;
		return this.codigo.compareTo(o.getCodigo());
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		PessoaLista that = (PessoaLista) o;
		return Objects.equals(codigo, that.codigo) && Objects.equals(nome, that.nome);
	}

	@Override
	public int hashCode() {
		int result = Objects.hashCode(codigo);
		result = 31 * result + Objects.hashCode(nome);
		return result;
	}
}
