package provas.prova03.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import provas.prova03.model.Aluno;

public class PainelTabela extends JPanel {

	private JTable tabela;
	private JButton btnAdicionarNota;
	private JButton btnCalcularMedia;
	public DefaultTableModel modelo;

	public PainelTabela() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		modelo = new DefaultTableModel(
				new Object[]{"Nome", "Matrícula", "Turma", "Qtd Notas"}, 0
		);
		tabela = new JTable(modelo);

		JScrollPane scroll = new JScrollPane(tabela);

		JPanel painelBotoes = new JPanel();
		btnAdicionarNota = new JButton("Adicionar Nota");
		btnCalcularMedia = new JButton("Calcular Média");

		painelBotoes.add(btnAdicionarNota);
		painelBotoes.add(btnCalcularMedia);

		add(scroll, BorderLayout.CENTER);
		add(painelBotoes, BorderLayout.SOUTH);
	}

	public JTable getTabela() {
		return tabela;
	}

	public void definirAcaoBotaoAdicionarNota(ActionListener acao) {
		btnAdicionarNota.addActionListener(acao);
	}

	public void definirAcaoBotaoCalcularMedia(ActionListener acao) {
		btnCalcularMedia.addActionListener(acao);
	}

	/**
	 * Retorna a linha selecionada da tabela (Para retornar o index)
	 * @return
	 */
	public int getLinhaSelecionada() {
		return tabela.getSelectedRow();
	}

	/**
	 * Atualiza a tabela
	 */
	public void atualizarTabela(List<Aluno> alunos) {
		// Limpa a tabela
		modelo.setRowCount(0);

		// Adiciona os estudantes
		for (Aluno aluno : alunos) {
			Object[] linha = {aluno.getNome(), aluno.getCodigoMatricula(), aluno.getTurma(), aluno.getNotas().size()};
			modelo.addRow(linha);
		}
	}
}

