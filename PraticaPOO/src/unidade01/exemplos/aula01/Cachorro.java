package unidade01.exemplos.aula01;

/**
 * Exemplo de DECLARAÇÃO DE CLASSE
 */
public class Cachorro {

    String nome;
    String raca;
    String cor;
    double peso;

    void latir() {
        System.out.println("AU AU!");
    }

    void abanarRabo() {
       System.out.println("Abanando o rabo.");
    }

    void pegarCoisa(String coisa) {
        System.out.println("Pegando " + coisa);
    }
}
