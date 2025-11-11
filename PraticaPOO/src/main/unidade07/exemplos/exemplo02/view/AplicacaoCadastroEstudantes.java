package unidade07.exemplos.exemplo02.view;

import javax.swing.SwingUtilities;

/**
 * Aplicação de Cadastro de Estudantes usando Java Swing
 * Demonstra conceitos de POO e GUI
 *
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class AplicacaoCadastroEstudantes {

	public static void main(String[] args) {
		// Inicia a aplicação na thread de eventos do Swing
		SwingUtilities.invokeLater(() -> {
			JanelaCadastroEstudantes janela = new JanelaCadastroEstudantes();
			janela.setVisible(true);
		});
	}
}
