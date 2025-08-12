package unidade01.exemplos.aula01;

public class App {

    public static void main(String[] args) {

        // DECLARAÇÃO DO OBJETO
        Cachorro dog1;

        // CRIAÇÃO DO OBJETO
        dog1 = new Cachorro();

        // UTILIZAÇÃO DO OBJETO (ATRIBUINDO VALORES)
        dog1.nome = "Pingo";
        dog1.raca = "Labrador";
        dog1.cor = "Branco";
        dog1.peso = 12.0;

        // DECLARAÇÃO DO OBJETO E CRIAÇÃO DO OBJETO
        Cachorro dog2 = new Cachorro();

        dog2.nome = "Brutus";
        dog2.raca = "Pastor alemão";
        dog2.cor = "Marrom";
        dog2.peso = 21.0;

        // UTILIZAÇÃO DO OBJETO (LENDO OS VALORES)
        System.out.println("Informações do dog 1");
        System.out.println("Nome: " + dog1.nome);
        System.out.println("Raça: " + dog1.raca);
        System.out.println("Cor: " + dog1.cor);
        System.out.println("Peso: " + dog1.peso);

        // UTILIZAÇÃO DO OBJETO (ALTERANDO O ESTADO/VALOR)
        dog1.peso = dog1.peso + 2;

        System.out.println("Nome: " + dog1.nome);
        System.out.println("Peso: " + dog1.peso);
    }


}
