package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import control.*;

public class TelaDetalheSintoma implements ActionListener {

	private JFrame janela;
	private JLabel labelMental = new JLabel("Sintoma mental: ");
	private JTextField valorMental;
	private JLabel labelIntensidade = new JLabel("Intensidade: ");
	private JTextField valorIntensidade;
	private JLabel labelCadastro = new JLabel("Data: ");
	private JTextField valorCadastro;
	private JLabel labelFisico = new JLabel("Sintoma físico: ");
	private JTextField valorFisico;
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
			TelaSintoma ts, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro sintomas mentais";
		if (op == 2) s = "Cadastro sintomas fisicos";
		if (op == 3) s = "Detalhe sintomas mentais";
		if (op == 4) s = "Detalhe sintomas fisicos";

		janela = new JFrame(s);

		//Preenche dados com dados do sintoma mental clicado
		if (op == 3) {
			valorIntensidade = new JTextField(dados.getMentais()[pos].getIntensidade());
			valorCadastro = new JTextField(dados.getMentais()[pos].getCadastro());
			valorMental = new JTextField(dados.getMentais()[pos].getNomeMental());
			valorFisico= new JTextField(200);
			
			
				

		} else if (op == 4) { //Preenche dados com dados do sintoma fisico clicado 
			valorIntensidade = new JTextField(dados.getFisicos()[pos].getIntensidade());
			valorCadastro = new JTextField(dados.getMentais()[pos].getCadastro());
			valorFisico = new JTextField(dados.getFisicos()[pos].getNomeFisico());			
			valorMental= new JTextField(200);
		

		} else { //N�o preenche com dados

			valorMental = new JTextField(200);
			valorIntensidade = new JTextField(200);
			valorCadastro = new JTextField(200);
			
			valorFisico = new JTextField(200);
		

			botaoSalvar.setBounds(245, 175, 115, 30);
		}
		
		labelIntensidade.setBounds(30, 20, 150, 25);
		valorIntensidade.setBounds(180, 20, 180, 25);
		labelCadastro.setBounds(30, 50, 150, 25);
		valorCadastro.setBounds(180, 50, 180, 25);
		labelMental.setBounds(30, 80, 150, 25);
		valorMental.setBounds(180, 80, 180, 25);
		labelFisico.setBounds(30, 80, 180, 25);
		valorFisico.setBounds(180, 80, 180, 25);				
		
		
		//Coloca os campos relacionados ao nome do sintoma mental
		if (op == 1 || op == 3 ) {
			this.janela.add(labelMental);
			this.janela.add(valorMental);

		}

		//Coloca campos relacionados ao sintoma fisico
		if (op == 2 || op == 4) {

			this.janela.add(labelFisico);
			this.janela.add(valorFisico);
			
		}

		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelMental);
		this.janela.add(valorMental);
		this.janela.add(labelIntensidade);
		this.janela.add(valorIntensidade);
		this.janela.add(labelCadastro);
		this.janela.add(valorCadastro);
		this.janela.add(labelFisico);
		this.janela.add(valorFisico);
		
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 250);
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

				novoDado[1] =  valorIntensidade.getText();
				novoDado[2] =  valorCadastro.getText();
				

				if (opcao == 1 || opcao == 3) {
					novoDado[3] =  valorMental.getText();
					res = dados.inserirEditarMental(novoDado);
				} else {
					novoDado[3] =  valorFisico.getText();
					
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
				else mensagemErroExclusaoMental(); 
			}
				
			if (opcao == 4){ //exclui professor
				res = dados.removerFisico(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoFisico(); 
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

	public void mensagemErroExclusaoMental() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o aluno est� matriculado\n"
				+ "em alguma disciplina. Se sim, cancele\n "
				+ "a matricula e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusaoFisico() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o professor est� respons�vel\n"
				+ "por alguma disciplina. Se sim, substitua\n "
				+ "o professor e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}