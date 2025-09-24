package unidade01.exemplos.aula01;

public class Variaveis {

    // Variável de instância
    int x = 10;

    void testar() {
        // Variável local
        int x = 5;

        System.out.println("Variável local" + x);
        System.out.println("Variável de instância" + this.x);

        do {
            // Vairável de bloco.
           int y = 8;
        } while (true);


    }

}
