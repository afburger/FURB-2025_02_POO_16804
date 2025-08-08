package unidade01.exercicios.lista01.questao3;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Pessoa pessoa;

        for (int i = 0; i < 3; i++) {
            pessoa = new Pessoa();
            System.out.println("Informe a altura da pessoa " + i + ":");
            pessoa.altura = teclado.nextDouble();

            System.out.println("Informe o peso da pessoa " + i + ":");
            pessoa.peso = teclado.nextDouble();

            double imc = pessoa.calcularImc();
            System.out.println("O IMC calculado é de: " + imc);
        }

        teclado.close();

    }
}
