package unidade06;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author André Felipe Bürger (afburger@furb.com.br)
 *
 */
public class ArquivoBinario3Manipulacao {

	private static final String FILE_PATH = "C:\\temp\\pessoas.dat";

	public static void main(String[] args) {
		// Adiciona algumas pessoas
		gravarPessoa(new PessoaBin(1, "Felipe", 30));
		gravarPessoa(new PessoaBin(2, "Andre", 34));

		// Atualiza a pessoa com ID 1
		atualizarPessoa(1, "Felipe Atualizado", 31);

		// Lista todas as pessoas
		System.out.println("Lista de Pessoas:");
		listarPessoas();
	}

	// Grava um novo objeto Pessoa no final do arquivo
	public static void gravarPessoa(PessoaBin pessoa) {
		// Mesmo para inserir precisa ler e gravar o arquivo todo novamente, pois o OutputStream cria sempre um cabeçalho a cada inserção.
		File arquivo = new File(FILE_PATH);
		List<PessoaBin> pessoas = new ArrayList<>();

		// Lê todos os objetos do arquivo
		if (arquivo.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
				while (true) {
					try {
						PessoaBin pes = (PessoaBin) ois.readObject();
						pessoas.add(pes);
					} catch (EOFException e) {
						break; // Fim do arquivo
					}
				}
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("Erro ao ler o arquivo: " + e.getMessage());
				return;
			}
		}
		// Adiciona o novo registro ao final da lista
		pessoas.add(pessoa);

		try {
			FileOutputStream fos = new FileOutputStream(arquivo, false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (PessoaBin p : pessoas) {
				oos.writeObject(p);
			}
			// Envia as atualizações para o arquivo.
			oos.flush();
			// Fecha o arquivo.
			oos.close();
		} catch (IOException e) {
			System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
		}
	}

	// Atualiza uma Pessoa pelo ID
	public static void atualizarPessoa(int codigo, String novoNome, int novaIdade) {
		File arquivo = new File(FILE_PATH);
		List<PessoaBin> pessoas = new ArrayList<>();

		// Lê todos os objetos do arquivo
		if (arquivo.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
				while (true) {
					try {
						PessoaBin pessoa = (PessoaBin) ois.readObject();
						pessoas.add(pessoa);
					} catch (EOFException e) {
						break; // Fim do arquivo
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("Erro ao ler o arquivo: " + e.getMessage());
				return;
			}
		}

		// Atualiza a pessoa com o código correspondente
		boolean encontrou = false;
		for (PessoaBin pessoa : pessoas) {
			if (pessoa.getCodigo() == codigo) {
				pessoa.setNome(novoNome);
				pessoa.setIdade(novaIdade);
				encontrou = true;
				break;
			}
		}

		if (!encontrou) {
			System.out.println("Pessoa com código " + codigo + " não encontrada.");
			return;
		}

		// Regrava todas as pessoas no arquivo (sobrescreve o conteúdo)
		// No FileOutputStream, passar true se deseja adicionar informações no arquivo e false se quiser sobreescrever todos os dados.
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo, false))) {
			for (PessoaBin pessoa : pessoas) {
				oos.writeObject(pessoa);
			}
			System.out.println("Arquivo atualizado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	// Exibe todas as Pessoas no arquivo
	public static void listarPessoas() {
		File arquivo = new File(FILE_PATH);
		try {
			FileInputStream fis = new FileInputStream(arquivo);
			// Cria um ObjectInputStream para ler os bytes e converter em objetos.
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Faz a leitura até o final do arquivo.
			while (true) {
				try {
					PessoaBin pessoa = (PessoaBin) ois.readObject();
					System.out.println(pessoa);
				} catch (EOFException e) {
					// Quando lançar a exceção é porquê chegou ao final do arquivo. Então para o loop
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Erro ao ler o arquivo" + e.getMessage());
		}
	}
}
