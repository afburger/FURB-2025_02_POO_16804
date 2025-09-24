package unidade01.exercicios.lista01.questao2;

public class Pessoa {

    double altura;
    double peso;

    double calcularImc() {
        return peso / (altura * altura);
    }
}
