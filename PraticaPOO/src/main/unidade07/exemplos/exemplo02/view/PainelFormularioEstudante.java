package unidade07.exemplos.exemplo02.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import unidade07.exemplos.exemplo02.model.Estudante;

/**
 * Painel com formulário para cadastro de estudantes
 *
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class PainelFormularioEstudante extends JPanel {
	private JTextField campoNome;
	private JTextField campoMatricula;
	private JComboBox<String> comboCurso;
	private JButton botaoCadastrar;

	public PainelFormularioEstudante() {
		// Configura o layout
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Cadastro de Novo Estudante"));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Cria os componentes
		JLabel rotuloNome = new JLabel("Nome:");
		JLabel rotuloMatricula = new JLabel("Matrícula:");
		JLabel rotuloCurso = new JLabel("Curso:");

		campoNome = new JTextField(20);
		campoMatricula = new JTextField(10);

		String[] cursos = {"Ciência da Computação", "Engenharia de Software",
				"Sistemas de Informação", "Engenharia da Computação"};
		comboCurso = new JComboBox<>(cursos);

		botaoCadastrar = new JButton("Cadastrar");

		// Adiciona os componentes usando GridBagLayout
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(rotuloNome, gbc);

		gbc.gridx = 1;
		gbc.weightx = 1.0;
		add(campoNome, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		add(rotuloMatricula, gbc);

		gbc.gridx = 1;
		gbc.weightx = 1.0;
		add(campoMatricula, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		add(rotuloCurso, gbc);

		gbc.gridx = 1;
		gbc.weightx = 1.0;
		add(comboCurso, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		add(botaoCadastrar, gbc);
	}

	public void definirAcaoBotaoCadastrar(ActionListener acao) {
		botaoCadastrar.addActionListener(acao);
	}

	public Estudante obterEstudanteDoFormulario() {
		String nome = campoNome.getText().trim();
		String matricula = campoMatricula.getText().trim();
		String curso = (String) comboCurso.getSelectedItem();

		if (nome.isEmpty() || matricula.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Por favor, preencha todos os campos obrigatórios.",
					"Campos Incompletos",
					JOptionPane.WARNING_MESSAGE);
			return null;
		}

		return new Estudante(nome, matricula, curso);
	}

	public void limparFormulario() {
		campoNome.setText("");
		campoMatricula.setText("");
		comboCurso.setSelectedIndex(0);
		campoNome.requestFocus();
	}
}