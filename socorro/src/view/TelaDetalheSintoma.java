package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.*;

public class TelaDetalheSintoma implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelData = new JLabel("Data do cadastro: ");
	private JTextField valorData;
	private JLabel labelIntensidade = new JLabel("Intensidade: ");
	private JTextField valorIntensidade;
	private JLabel labelLocal = new JLabel("Local: ");
	private JTextField valorLocal;	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	public void inserirEditar(int op, ControleDados d, 
			TelaSintoma p, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro de sintoma mental";
		if (op == 2) s = "Cadastro de sintoma fisico";
		if (op == 3) s = "Detalhe de sintoma mental";
		if (op == 4) s = "Detalhe de sintoma fisico";

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		janela.setBounds(100, 100, 600, 600);		
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

		//Preenche dados com dados do aluno clicado
		if (op == 3) {
			valorNome = new JTextField(dados.getMentais()[pos].getNomeMental(), 200);
			valorData = new JTextField(String.valueOf(dados.getMentais()[pos].getCadastro()), 200);
			valorIntensidade = new JTextField(String.valueOf(dados.getMentais()[pos].getIntensidade()), 200);
					

		} else if (op == 4) { //Preenche dados com dados do professor clicado 
			valorNome = new JTextField(dados.getFisicos()[pos].getNomeFisico(), 200);
			valorLocal = new JTextField(dados.getFisicos()[pos].getLocal(), 200);
			valorData = new JTextField(String.valueOf(dados.getFisicos()[pos].getCadastro()), 200);
			valorIntensidade = new JTextField(String.valueOf(dados.getFisicos()[pos].getIntensidade()), 200);

		} else { //N�o preenche com dados

			valorNome = new JTextField(200);
			valorData = new JTextField(200);
			valorLocal = new JTextField(200);
			valorIntensidade = new JTextField(200);
			

			botaoSalvar.setBounds(245, 175, 115, 30);
		}

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelData.setBounds(30, 50, 150, 25);
		valorData.setBounds(180, 50, 180, 25);
		labelLocal.setBounds(30, 50, 180, 25);
		valorLocal.setBounds(180, 50, 180, 25);		
		labelIntensidade.setBounds(30, 80, 150, 25);
		valorIntensidade.setBounds(180, 80, 180, 25);
		

		//Coloca os campos relacionados a endereco se aluno
		if (op == 1 || op == 3 ) {
			this.janela.add(labelNome);
			this.janela.add(valorNome);

		}

		//Coloca campos relacionados a valor hora/aula se professor
		if (op == 2 || op == 4) {

			this.janela.add(labelLocal);
			this.janela.add(valorLocal);
		}

		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelData);
		this.janela.add(valorData);
		this.janela.add(labelLocal);
		this.janela.add(valorLocal);
		this.janela.add(labelIntensidade);
		this.janela.add(valorIntensidade);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setBounds(100, 100, 600, 600);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) //cadastro de novo aluno
					novoDado[0] = Integer.toString(dados.getQtdMentais());
				else if (opcao == 2) // cadastro de novo prof
					novoDado[0] = Integer.toString(dados.getQtdFisicos());
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);

				novoDado[1] =  valorNome.getText();
				novoDado[3] =  valorData.getText();
				novoDado[4] =  valorLocal.getText();
				novoDado[5] =  valorIntensidade.getText();
				

				if (opcao == 1 || opcao == 3) {
					novoDado[2] =  valorNome.getText();
					res = dados.inserirEditarMental(novoDado);
				} else {
					novoDado[2] =  valorLocal.getText();
					res = dados.inserirEditarFisicos(novoDado);
				}

				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}

		if(src == botaoExcluir) {
			boolean res = false;

			if (opcao == 3) {//exclui aluno
				res = dados.removerMental(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoAluno(); 
			}
				
			if (opcao == 4){ //exclui professor
				res = dados.removerFisico(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoProf(); 
			}


			
		}
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. CPF, identidade, DDD e telefone n�o cont�m apenas n�meros", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoAluno() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o aluno est� matriculado\n"
				+ "em alguma disciplina. Se sim, cancele\n "
				+ "a matricula e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusaoProf() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o professor est� respons�vel\n"
				+ "por alguma disciplina. Se sim, substitua\n "
				+ "o professor e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}
