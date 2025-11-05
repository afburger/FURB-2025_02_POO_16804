package unidade06;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author André Felipe Bürger (afburger@furb.com.br)
 *
 */
public class ArquivoBinario1Escrita {

	public static void main(String[] args) {
		// Instância e cria ou lê o novo arquivo.
		File arquivo = new File("C:\\temp\\dados.dat");
		try {
			// Instância um gerenciador responsável por gravar dados no arquivo.
			FileOutputStream fos = new FileOutputStream(arquivo);
			fos.write(79);
			fos.write(105);
			fos.write(32);
			fos.close();

			// O parâmetro true indica se deseja adicionar dados ao arquivo.
			FileOutputStream fos2 = new FileOutputStream(arquivo, true);

			fos2.write(65);
			fos2.write(32);
			// Exemplo para adicionar um texto em um arquivo binário
			String texto = "mensagem que vai ser adicionada em um arquivo";
			fos2.write(texto.getBytes());
			fos.close();

		} catch (IOException e) {
			System.out.println("Erro ao gravar o arquivo:" + e.getMessage());
		}

	}
}
