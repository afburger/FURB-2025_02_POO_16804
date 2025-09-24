package unidade01.exemplos.aula07;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TratarException {

	public void lerArquivo() {
		try {
			FileReader file = new FileReader("arquivo.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
	}
}
