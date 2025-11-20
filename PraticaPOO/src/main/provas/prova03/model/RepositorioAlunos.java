package provas.prova03.model;

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
 * Classe que representa o repositório conforme o diagrama
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class RepositorioAlunos {

	public static final String CAMINHO_ARQUIO = "C:\\temp\\prova3alunos.bin";

	private List<Aluno> alunos;

	public RepositorioAlunos() {
		this.alunos = new ArrayList<>();
	}

	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public List<Aluno> listar() {
		return alunos;
	}

	/**
	 * Retorna o aluno de acordo com indice.
	 */
	public Aluno getAlunoPorIndex(int index) {
		return alunos.get(index);
	}

	/**
	 * Salva a lista atualizada no arquivo.
	 * Sempre sobreescrevendo todo o arquivo.
	 */
	public void salvar(String caminhoArquivo) {
		File arquivo = new File(caminhoArquivo);

		try {
			FileOutputStream fos = new FileOutputStream(arquivo, false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (Aluno aluno : alunos) {
				oos.writeObject(aluno);
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Carrega os dados do arquivo para a lista e atualiza a lista do repositório.
	 * @param caminhoArquivo
	 */
	public void carregar(String caminhoArquivo) {
		File arquivo = new File(caminhoArquivo);
		try {
			FileInputStream fis = new FileInputStream(arquivo);
			// Cria um ObjectInputStream para ler os bytes e converter em objetos.
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Instância uma nova lista
			alunos = new ArrayList<>();

			// Faz a leitura até o final do arquivo.
			while (true) {
				try {
					// Lê a informação do arquivo
					Aluno aluno = (Aluno) ois.readObject();
					// Adiciona na lista atualizada.
					alunos.add(aluno);
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
