package unidade03.exercicios.lista10;

import java.util.ArrayList;
import java.util.Objects;

public class Profissional {

	private int id;
	private String cpf;
	private String nome;
	private static int contador = 0;
	private ArrayList<Projeto> projetos = new ArrayList<>();

	public Profissional() {
		this.id = ++contador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}

	public void adicionaProjeto(Projeto projeto) {
		this.projetos.add(projeto);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Profissional outro = (Profissional) o;
		return Objects.equals(cpf, outro.cpf);
	}

}
