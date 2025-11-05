package unidade06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class ArquivoTexto3Manipulacao {

	private static final String FILE_PATH = "C:\\temp\\pessoas.csv";

	public static void main(String[] args) {
		// Adiciona algumas pessoas ao CSV
		adicionarPessoa(new PessoaCSV(1, "João", 30));
		adicionarPessoa(new PessoaCSV(2, "André", 25));

		// Atualiza a pessoa com ID 1
		atualizarPessoa(2, "André Felipe", 37);

		// Lista todas as pessoas
		System.out.println("Lista de Pessoas:");
		for (PessoaCSV p : lerPessoas()) {
			System.out.println(p);
		}

		adicionarPessoa(new PessoaCSV(6, "Pedro", 35));
	}

	// Adiciona uma nova pessoa ao arquivo CSV
	public static void adicionarPessoa(PessoaCSV pessoa) {
		PrintWriter pw = null;
		try {
			FileWriter fw = new FileWriter(FILE_PATH, StandardCharsets.UTF_8, true);
			pw = new PrintWriter(fw);
			pw.println(pessoa.toString());
		} catch (IOException e) {
			System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
		} finally {
			pw.close();
		}
	}

	// Lê todas as pessoas do arquivo CSV
	public static List<PessoaCSV> lerPessoas() {
		// Inicia um arraylist de PessoasCSV
		List<PessoaCSV> pessoas = new ArrayList<>();
		try {
			// Inicia um scanner para fazer a leitura do arquivo.
			Scanner sc = new Scanner(new File(FILE_PATH), "UTF-8");

			String linha;

			// Percorre todas as linhas do arquivo
			while (sc.hasNext()) {
				// faz a leitura da linha
				linha = sc.nextLine();
				// Separa os dados de acordo com as ","
				String[] dados = linha.split(",");
				// converte os dados que estão em texto.
				int id = Integer.parseInt(dados[0]);
				String nome = dados[1];
				int idade = Integer.parseInt(dados[2]);
				// adiciona o objeto no arraylist.
				pessoas.add(new PessoaCSV(id, nome, idade));
			}
			// Retorna o arraylist.
			return pessoas;
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo");
		}
		return null;
	}

	// Atualiza uma pessoa pelo ID no CSV
	public static void atualizarPessoa(int id, String novoNome, int novaIdade) {

		// Faz a leitura das pessoas no arquivo.
		List<PessoaCSV> pessoas = lerPessoas();

		try {
			// Instância o objeto responsável por inserir dados no arquivo.
			PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, StandardCharsets.UTF_8));
			// Faz a leitura das pessoas, que estão no arquivo.
			for (PessoaCSV pessoa : pessoas) {

				// Ao encontrar o registro que precisa ser atualizado.
				if (pessoa.getId() == id) {
					pessoa.setNome(novoNome);
					pessoa.setIdade(novaIdade);
				}
				// Printa todas as pessoas novamente no arquivo.
				pw.println(pessoa.toString());

			}
			pw.close();
		} catch (IOException e) {
			System.out.println("Erro ao gravar o arquivo " + e.getMessage());
		}
	}
}
