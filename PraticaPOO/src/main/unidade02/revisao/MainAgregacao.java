package unidade02.revisao;

public class MainAgregacao {

	public static void main(String[] args) {

		Musica musica1 = new Musica();
		musica1.setNome("Bla bla");

		Playlist p1 = new Playlist();
		p1.adicionarMusica(musica1);

		Playlist p2 = new Playlist();
		p2.adicionarMusica(musica1);

	}
}
