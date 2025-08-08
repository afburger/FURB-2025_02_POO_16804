package unidade01.exercicios.lista01.questao04;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[3];

        Scanner teclado = new Scanner(System.in);
        Pessoa p;
        for (int i = 0; i < pessoas.length; i++) {
            p = new Pessoa();

            System.out.println("Informe o nome da pessoa " + i + ":");
            p.nome = teclado.next();

            System.out.println("Informe o peso da pessoa " + i + ":");
            p.peso = teclado.nextDouble();

            System.out.println("Informe a altura da pessoa " + i + ":");
            p.altura = teclado.nextDouble();

            pessoas[i] = p;
        }

        teclado.close();

        for (int i = pessoas.length - 1; i >= 0; i--) {
            Pessoa pDados = pessoas[i];
            pDados.exibirDados();
        }
    }
}
