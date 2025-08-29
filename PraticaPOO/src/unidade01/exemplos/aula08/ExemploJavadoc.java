package unidade01.exemplos.aula08;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Classe que representa uma calculadora simples.
 *
 * @author André Felipe Bürger (afburger@furb.br)
 */
public class ExemploJavadoc {

	/**
	 * Soma dois números inteiros.
	 *
	 * @param primeiroValor primeiro número
	 * @param segundoValor segundo número
	 * @return um int com a soma de a e b
	 */
	public int somar(int primeiroValor, int segundoValor) {
		return primeiroValor + segundoValor;
	}

	/**
	 * Divide dois números inteiros.
	 *
	 * @param primeiroNumero numerador
	 * @param b denominador (não pode ser zero)
	 * @return o resultado da divisão
	 * @throws ArithmeticException se b for zero
	 */
	public int dividir(int primeiroNumero, int b) {
		return primeiroNumero / b;
	}

	/**
	 * Lê um arquivo com as operações disponíveis
	 *
	 * @throws FileNotFoundException - Lança uma exceção de {@link FileNotFoundException} caso não encontre o arquivo
	 */
	public void lerOperacoes() throws FileNotFoundException {
		FileReader fileReader = new FileReader("arquivo.txt");
	}
}
