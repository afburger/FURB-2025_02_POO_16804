package unidade07.exemplos.exemplo02.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import unidade07.exemplos.exemplo02.model.Estudante;

/**
 * Painel com tabela para exibição dos estudantes
 *
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class PainelTabelaEstudantes extends JPanel {
	private JTable tabela;
	private DefaultTableModel modeloTabela;
	private JButton botaoRemover;

	public PainelTabelaEstudantes() {
		setLayout(new BorderLayout(10, 10));
		setBorder(BorderFactory.createTitledBorder("Estudantes Cadastrados"));

		// Cria o modelo da tabela
		String[] colunas = {"Nome", "Matrícula", "Curso"};
		modeloTabela = new DefaultTableModel(colunas, 0);

		// Cria a tabela
		tabela = new JTable(modeloTabela);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Adiciona a tabela em um scroll pane
		JScrollPane painelRolagem = new JScrollPane(tabela);

		// Cria o botão de remover
		botaoRemover = new JButton("Remover Selecionado");
		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		painelBotoes.add(botaoRemover);

		// Adiciona os componentes
		add(painelRolagem, BorderLayout.CENTER);
		add(painelBotoes, BorderLayout.SOUTH);
	}

	public void atualizarTabela(List<Estudante> estudantes) {
		// Limpa a tabela
		modeloTabela.setRowCount(0);

		// Adiciona os estudantes
		for (Estudante estudante : estudantes) {
			Object[] linha = {estudante.getNome(), estudante.getMatricula(), estudante.getCurso()};
			modeloTabela.addRow(linha);
		}
	}

	public int obterLinhaSelecionada() {
		return tabela.getSelectedRow();
	}

	public void definirAcaoBotaoRemover(ActionListener acao) {
		botaoRemover.addActionListener(acao);
	}
}
