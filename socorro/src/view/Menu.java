package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Menu extends JFrame implements ActionListener {
	
		private static JFrame janela = new JFrame("Meu Diário Menstrual");
		private static JLabel titulo = new JLabel("O que você deseja fazer?");
		private static JButton cadastro_pessoa = new JButton("Cadastrar Pessoa");
		private static JButton cadastro_ciclo = new JButton("Cadastrar novo Ciclo Menstrual");
		private static JButton cadastro_sintoma_fisico = new JButton("Cadastrar um Sintoma Físico");
		private static JButton cadastro_sintoma_mental = new JButton("Cadastrar um Sintoma Mental");
		private static JButton relatorio = new JButton("Diários");
		private JPanel painel = new JPanel (); 
		//private JLabel fundo = new JLabel ("");

	//	public static ControleDados dados = new ControleDados();
	 
		private static final long serialVersionUID = 1L;

		
		public Menu() {	
			
			
			//fundo.setBounds(680, 382, 100, 69);
			//fundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/view/imagens/back.png")));
			///add(fundo);
			
			//setBackground(new Color(245, 245, 220));
			//setBounds(100, 100, 830, 522);
			//setLayout(null);
			
			
				
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//janela.setSize(400, 250);
			
			janela.setBounds(100, 100, 600, 600);
			titulo.setBounds(50, 0, 500, 50);

			//janela.setContentPane(pane);	
			painel.setBorder(new EmptyBorder(5, 5, 5, 5));
			painel.setLayout(new BorderLayout(0, 0));

			
			titulo.setFont(new Font("Arial", Font.BOLD, 22));
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(cadastro_pessoa);
			janela.add(cadastro_ciclo);
			janela.add(cadastro_sintoma_fisico);
			janela.add(cadastro_sintoma_mental);
			janela.add(relatorio);

			janela.setVisible(true);
			
			

			cadastro_pessoa.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_pessoa.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));		
			cadastro_pessoa.setOpaque(true);
			cadastro_pessoa.setBackground(new Color(205, 180, 219));
			cadastro_pessoa.setForeground(Color.BLACK);
			cadastro_pessoa.setBounds(50, 70, 500, 50);
			
			cadastro_ciclo.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_ciclo.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
			cadastro_ciclo.setOpaque(true);
			cadastro_ciclo.setBackground(new Color(255, 200, 221));
			cadastro_ciclo.setForeground(Color.BLACK);
			cadastro_ciclo.setBounds(50, 150, 500, 50);
			
			cadastro_sintoma_fisico.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_sintoma_fisico.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
			cadastro_sintoma_fisico.setOpaque(true);
			cadastro_sintoma_fisico.setBackground(new Color(255, 175, 204));
			cadastro_sintoma_fisico.setForeground(Color.BLACK);
			cadastro_sintoma_fisico.setBounds(50, 230, 500, 50);
			
			cadastro_sintoma_mental.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_sintoma_mental.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
			cadastro_ciclo.setOpaque(true);
			cadastro_sintoma_mental.setBackground(new Color(189, 224, 254));
			cadastro_sintoma_mental.setForeground(Color.DARK_GRAY);			
			cadastro_sintoma_mental.setBounds(50, 310, 500, 50);
			
			relatorio.setFont(new Font("Arial", Font.PLAIN, 20));
			relatorio.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
			relatorio.setOpaque(true);
			relatorio.setBackground(new Color(162, 210, 255));
			relatorio.setForeground(Color.DARK_GRAY);			
			relatorio.setBounds(50, 390, 500, 50);
			
			
		}
		
		
		public static void main(String[] args) {
			Menu menu = new Menu();
			
			
			
						
			cadastro_pessoa.addActionListener(menu);
			cadastro_ciclo.addActionListener(menu);
			cadastro_sintoma_fisico.addActionListener(menu);
			cadastro_sintoma_mental.addActionListener(menu);
			relatorio.addActionListener(menu);
		}

		public void actionPerformed(ActionEvent e) {
			Object click = e.getSource();

			if(click == cadastro_pessoa) {
				new CadastrarPessoa();
				janela.setVisible(false);
			}
				
			
			if(click == cadastro_ciclo) {
				new CadastrarCiclo();
				janela.setVisible(false);
			}
				
			
			if(click == cadastro_sintoma_fisico) {
				new TelaSintoma().mostrarDados(dados, 1);
				janela.setVisible(false);
			}
				
			
			if(click == cadastro_sintoma_mental) {
				new TelaSintoma().mostrarDados(dados, 2);
				janela.setVisible(false);
			}
				
			
			if(click == relatorio) {
				new TelaDiario();
				janela.setVisible(false);
			}
				
		
		}
		
		
		
						
			
	}