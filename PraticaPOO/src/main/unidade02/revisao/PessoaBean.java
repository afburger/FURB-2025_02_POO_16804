package unidade02.revisao;

public class PessoaBean extends ObjetoRelatorio {

	private String nome;
	private String cpf;

	public PessoaBean(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String imprimir() {
		return cpf + " - " + nome;
	}
}
