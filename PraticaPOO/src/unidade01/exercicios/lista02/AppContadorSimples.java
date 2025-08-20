package unidade01.exercicios.lista02;

public class AppContadorSimples {

    public static void main(String[] args) {
        ContadorSimples c1 = new ContadorSimples();
        ContadorSimples c2 = new ContadorSimples();

        for (int i = 0; i < 5; i++) {
            c1.incrementar();
        }

        for (int i = 0; i < 3; i++) {
            c2.decrementar();
        }

        System.out.println("Estado de c1:");
        c1.exibirEstado();
        System.out.println("--------------------");
        System.out.println("Estado de c2:");
        c2.exibirEstado();

        System.out.println("--------------------");
        c1.zerar();

        System.out.println("Estado de c1:");
        c1.exibirEstado();


    }
}
