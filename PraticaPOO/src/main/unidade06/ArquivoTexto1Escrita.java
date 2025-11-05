package unidade06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author André Felipe Bürger (afburger@furb.com.br)
 *
 */
public class ArquivoTexto1Escrita {

	public static void main(String[] args) {
		// Instância e cria o arquivo se necessário.
		File arquivo = new File("C:\\temp\\arquiviTexto.txt");
		try {
			// Instância o objeto responsável por inserir dados no arquivo.
			PrintWriter arquivoTexto = new PrintWriter(arquivo, "UTF-8");
			// Adiciona as informações
			arquivoTexto.println("Texto linha um");
			arquivoTexto.println(true);
			arquivoTexto.println(2.50);
			// Fecha e grava o arquivo
			arquivoTexto.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("Erro ao criar o arquivo");
		}
	}
}
