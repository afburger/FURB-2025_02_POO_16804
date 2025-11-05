package unidade06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author André Felipe Bürger (afburger@furb.com.br)
 *
 */
public class ArquivoBinario2Leitura {

	public static void main(String[] args) {
		// Instância e cria ou lê o novo arquivo.
		File arquivo = new File("C:\\temp\\dados.dat");

		try {
			FileInputStream fis = new FileInputStream(arquivo);
			int dado;
			while ((dado = fis.read()) != -1) {
				System.out.println(dado);
			}
			fis.close();
		} catch (IOException e) {
			System.out.println("Erro ao gravar o arquivo:" + e.getMessage());
		}
	}
}
