package provas.prova03.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelAluno extends JPanel {

	private JTextField txtNome;
	private JTextField txtMatricula;
	private JTextField txtTurma;
	private JButton btnAdicionar;

	public PainelAluno() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;

		txtNome = new JTextField(20);
		txtMatricula = new JTextField(20);
		txtTurma = new JTextField(20);
		btnAdicionar = new JButton("Adicionar Aluno");

		add(new JLabel("Nome do Aluno:"), c);
		add(txtNome, c);

		add(new JLabel("Código de Matrícula:"), c);
		add(txtMatricula, c);

		add(new JLabel("Turma:"), c);
		add(txtTurma, c);

		c.insets = new Insets(10, 0, 0, 0);
		add(btnAdicionar, c);
	}

	public void definirAcaoBotaoAdicionarAluno(ActionListener acao) {
		btnAdicionar.addActionListener(acao);
	}

	/**
	 * Para retornar a informação do nome
	 */
	public String getNome() {
		return txtNome.getText();
	}

	/**
	 * Para retornar a informação da matrícula
	 */
	public int getMatricula() {
		return Integer.valueOf(txtMatricula.getText());
	}

	/**
	 * Para retornar a informação da turma
	 */
	public String getTurma() {
		return txtTurma.getText();
	}

	/**
	 * Método para limpar os campos do formulário.
	 */
	public void limparCampos() {
		txtNome.setText(null);
		txtMatricula.setText(null);
		txtTurma.setText(null);
	}

}

