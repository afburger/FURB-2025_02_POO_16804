package unidade02.revisao;

import java.util.ArrayList;

public class MainPolimorfismo {

	public static void main(String[] args) {
		ArrayList<ObjetoRelatorio> objetos = new ArrayList<>();

		PessoaBean pessoaBean = new PessoaBean("nome", "000.000.000-00");
		objetos.add(pessoaBean);
		PessoaBean pessoa1Bean = new PessoaBean("nome2", "001.000.000-00");
		objetos.add(pessoa1Bean);
		PessoaBean pessoa2Bean = new PessoaBean("nome3", "000.060.000-00");
		objetos.add(pessoa2Bean);

		Veiculo veiculo1 = new Veiculo("LXJ-3650", "Civic", "Honda");
		objetos.add(veiculo1);
		Veiculo veiculo2 = new Veiculo("MMA-6455", "Brasília", "Vw");
		objetos.add(veiculo2);

		GeradorRelatorio.gerarRelatorio(objetos);




	}
}
