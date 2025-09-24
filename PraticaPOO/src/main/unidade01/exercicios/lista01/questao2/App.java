package unidade01.exercicios.lista01.questao2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Pessoa marta = new Pessoa();

        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a altura da pessoa:");
        marta.altura = teclado.nextDouble();

        System.out.println("Informe o peso da pessoa");
        marta.peso = teclado.nextDouble();

        teclado.close();

        double imc = marta.calcularImc();

        System.out.println("O IMC calculado é de: " + imc);
    }
}
