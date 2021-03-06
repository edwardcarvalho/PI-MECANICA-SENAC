package senac.agendamento.assets.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import senac.agendamento.dao.DAO;

import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

import java.awt.Toolkit;
import java.awt.Label;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.SwingConstants;

public class FormMainEJZ extends JFrame {
	
	DAO conn = new DAO();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FormMainEJZ frame = new FormMainEJZ();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public FormMainEJZ() throws SQLException {
		
		setTitle("SCA - Sistema de Controle de Agendamento");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 30, 1200, 660);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(32767, 32767));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1366, 37);
		contentPane.add(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnArquivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcao = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?",
						"Confirmação de Encerramento", JOptionPane.YES_NO_OPTION);
				if (opcao == 0) {
					System.exit(0);
				}
			}
		});

		JMenu mnAgendamento = new JMenu("Agendamento");
		mnAgendamento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnArquivo.add(mnAgendamento);

		JMenuItem mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FormAgendamento agendamento;
				try {
					agendamento = new FormAgendamento();
					agendamento.setVisible(true);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		mntmNovo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAgendamento.add(mntmNovo);

		JMenuItem mntmAlterar_2 = new JMenuItem("Alterar");
		mntmAlterar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			FormAlterarAgendamento alterarAgendamento = new FormAlterarAgendamento();
			
			alterarAgendamento.setVisible(true);
				
					
			}
		});
		mntmAlterar_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAgendamento.add(mntmAlterar_2);
		
		JMenuItem mntmBaixar = new JMenuItem("Baixar");
		mntmBaixar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormBaixarAgendamento baixarAgendamento = new FormBaixarAgendamento();
				baixarAgendamento.setVisible(true);
			}
		});
		mntmBaixar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAgendamento.add(mntmBaixar);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnArquivo.add(mnCliente);
		
		JMenuItem mntmCadastrarEditar = new JMenuItem("Novo / Alterar");
		mntmCadastrarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FormCadastroCliente cadastroCliente = new FormCadastroCliente();
					cadastroCliente.setVisible(true);
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		mntmCadastrarEditar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnCliente.add(mntmCadastrarEditar);
		mnArquivo.add(mntmSair);

		JMenu mnPesquisa = new JMenu("Pesquisar");
		mnPesquisa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnPesquisa);

		JMenuItem mntmAgendamento = new JMenuItem("Agendamento");
		mntmAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FormPesquisaAgendamento pesquisaAgendamento = new FormPesquisaAgendamento();
					pesquisaAgendamento.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		mntmAgendamento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnPesquisa.add(mntmAgendamento);

		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormPesquisaCliente pesquisaCLiente;
				try {
					pesquisaCLiente = new FormPesquisaCliente();
					pesquisaCLiente.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		mntmCliente_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnPesquisa.add(mntmCliente_1);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		mnRelatrios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmGerarRelatorios = new JMenuItem("Gerar Relatorios");
		mntmGerarRelatorios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmGerarRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormRelatorios relatorios = new FormRelatorios();
				relatorios.setVisible(true);
			}
		});
		mnRelatrios.add(mntmGerarRelatorios);

		JMenu mnSobre = new JMenu("Ajuda");
		mnSobre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnSobre);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormSobre sobre = new FormSobre();
				sobre.setVisible(true);

			}
		});
		mnSobre.add(mntmSobre);

		JLabel lblPlanoDeFundo = new JLabel("Plano de Fundo");
		lblPlanoDeFundo.setBounds(0, 0, 1196, 634);
		contentPane.add(lblPlanoDeFundo);
		lblPlanoDeFundo.setIcon(new ImageIcon(FormMainEJZ.class.getResource("/senac/agendamento/assets/images/119344_Papel-de-Parede-Fundo-de-Luz_1680x1050.jpg")));
	}
}
