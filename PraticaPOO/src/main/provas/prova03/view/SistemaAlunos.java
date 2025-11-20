package provas.prova03.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import provas.prova03.model.Aluno;
import provas.prova03.model.Nota;
import provas.prova03.model.RepositorioAlunos;

public class SistemaAlunos extends JFrame {

	private RepositorioAlunos repositorio;
	private PainelAluno alunoPainel;
	private PainelTabela tabelaPainel;

	public SistemaAlunos() {
		setTitle("Sistema de Alunos e Notas");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		alunoPainel = new PainelAluno();
		tabelaPainel = new PainelTabela();

		add(alunoPainel, BorderLayout.NORTH);
		add(tabelaPainel, BorderLayout.CENTER);

		// Instancia o repositório
		repositorio = new RepositorioAlunos();

		// Carrega os dados do arquivo
		carregar();

		// Atualiza a tabela com os dados do arquivo
		tabelaPainel.atualizarTabela(getAlunos());

		/*
		 * Aqui é implmentada a lógica do botão cadastrar aluno
		 * Vai criar uma classe anônima de ActionListner ao instânicar com  new
		 */
		alunoPainel.definirAcaoBotaoAdicionarAluno(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = alunoPainel.getNome();
				int codigoMatricula = alunoPainel.getMatricula();
				String turma = alunoPainel.getTurma();
				cadastrarAluno(nome, codigoMatricula, turma);
			}
		});

		/*
		 * Aqui é implmentada a lógica do botão Adicionar nota
		 * Vai criar uma classe anônima de ActionListner ao instânicar com  new
		 */
		tabelaPainel.definirAcaoBotaoAdicionarNota(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tabelaPainel.getLinhaSelecionada();
				if (index < 0) {
					JOptionPane.showMessageDialog(null, "Selecione um aluno");
				} else {
					double nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da prova:"));
					int numeroProva = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da prova:"));
					String descricao = JOptionPane.showInputDialog("Informe a descrição da prova");
					adicionarNota(index, nota, numeroProva, descricao);
					salvar();
				}
			}
		});

		/*
		 * Aqui é implementada a lógica para calcular a média.
		 * Vai criar uma classe anônima de ActionListner ao instânicar com  new
		 */
		tabelaPainel.definirAcaoBotaoCalcularMedia(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tabelaPainel.getLinhaSelecionada();
				if (linhaSelecionada < 0 ) {
					throw new IllegalArgumentException("Selecione um aluno");
				}
				double media = calcularMedia(linhaSelecionada);
				JOptionPane.showMessageDialog(null, "A média do aluno é " + media);
			}
		});
	}

	public PainelAluno getAlunoPainel() {
		return alunoPainel;
	}

	public PainelTabela getTabelaPainel() {
		return tabelaPainel;
	}

	/**
	 * Método responsável por cadastrar um aluno
	 * Esse método será chamado no actionListener do botão de adicionar.
	 */
	public void cadastrarAluno(String nome, int codigoMatricula, String turma) {
		Aluno aluno = new Aluno(nome, codigoMatricula, turma);
		repositorio.adicionarAluno(aluno);
		tabelaPainel.atualizarTabela(getAlunos());
		alunoPainel.limparCampos();
		salvar();
	}

	/**
	 * Chama o método do repositório que retorna todos os alunos.
	 */
	public List<Aluno> getAlunos() {
		return repositorio.listar();
	}

	/**
	 * Método responsável por adicionar uma nota em um aluno.
	 */
	public void adicionarNota(int indexAluno, double nota, int numeroProva, String descricao) {
		Aluno aluno = repositorio.getAlunoPorIndex(indexAluno);
		Nota notaAluno = new Nota(nota, numeroProva, descricao);
		aluno.adicionarNota(notaAluno);
		tabelaPainel.atualizarTabela(getAlunos());
	}

	/**
	 * Busca o aluno pelo indice e calcula a média do mesmo.
	 */
	public double calcularMedia(int index) {
		Aluno aluno = repositorio.getAlunoPorIndex(index);
		return aluno.getMedia();
	}

	/**
	 * Chama o método do repoisitório para salvar se necessário
	 */
	public void salvar() {
		repositorio.salvar(RepositorioAlunos.CAMINHO_ARQUIO);
	}

	/**
	 * Chama o método do repoisitório para carregar se necessário
	 */
	public void carregar() {
		repositorio.carregar(RepositorioAlunos.CAMINHO_ARQUIO);
	}
}