package FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.SwingConstants;

public class FormMainEJZ extends JFrame {

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
	public FormMainEJZ() {
		setTitle("SCA - Sistema de Controle de Agendamento");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1200, 660);
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
		mntmNovo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAgendamento.add(mntmNovo);

		JMenuItem mntmAlterar_2 = new JMenuItem("Alterar");
		mntmAlterar_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAgendamento.add(mntmAlterar_2);

		JMenuItem mntmExcluir_1 = new JMenuItem("Excluir");
		mntmExcluir_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAgendamento.add(mntmExcluir_1);

		JMenu mnAbrirOrdemDe = new JMenu("Ordem de Servi\u00E7o");
		mnAbrirOrdemDe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnArquivo.add(mnAbrirOrdemDe);

		JMenuItem mntmNova = new JMenuItem("Nova");
		mntmNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormOrdemServico ordemServico = new FormOrdemServico();
				ordemServico.setVisible(true);
			}
		});
		mntmNova.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAbrirOrdemDe.add(mntmNova);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormAlterarOrdemServico alterarOrdemServico = new FormAlterarOrdemServico();

				alterarOrdemServico.setVisible(true);
			}
		});
		mntmAlterar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAbrirOrdemDe.add(mntmAlterar);

		JMenuItem mntmEncerrar = new JMenuItem("Baixar");
		mntmEncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FormBaixarOrdemServico baixarOrdemServico = new FormBaixarOrdemServico();
				baixarOrdemServico.setVisible(true);
			}
		});
		mntmEncerrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAbrirOrdemDe.add(mntmEncerrar);

		JMenuItem mntmExcluir_2 = new JMenuItem("Excluir");
		mntmExcluir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormExcluirOrdemServico excluirOrdemServico = new FormExcluirOrdemServico();

				excluirOrdemServico.setVisible(true);
			}
		});
		mntmExcluir_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAbrirOrdemDe.add(mntmExcluir_2);
		mnArquivo.add(mntmSair);

		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnCadastro);

		JMenu mnNovo = new JMenu("Novo");
		mnNovo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnCadastro.add(mnNovo);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormCadastroCliente cadastroCliente = null;
				try {
					cadastroCliente = new FormCadastroCliente();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cadastroCliente.setVisible(true);
			}
		});
		mntmCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNovo.add(mntmCliente);

		JMenuItem mntmFuncionrio_1 = new JMenuItem("Funcion\u00E1rio");
		mntmFuncionrio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCadastroFuncionario cadastroFuncionario = null;
				try {
					cadastroFuncionario = new FormCadastroFuncionario();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cadastroFuncionario.setVisible(true);
			}
		});
		mntmFuncionrio_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNovo.add(mntmFuncionrio_1);

		JMenuItem mntmAlterar_1 = new JMenuItem("Alterar");
		mntmAlterar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormAlteraClienteFuncionario alteraClienteFuncionario = new FormAlteraClienteFuncionario();

				alteraClienteFuncionario.setVisible(true);
			}
		});
		mntmAlterar_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnCadastro.add(mntmAlterar_1);

		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormExcluirClienteFuncionario excluirClienteFuncionario = new FormExcluirClienteFuncionario();
				excluirClienteFuncionario.setVisible(true);
			}
		});
		mntmExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnCadastro.add(mntmExcluir);

		JMenu mnPesquisa = new JMenu("Pesquisar");
		mnPesquisa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnPesquisa);

		JMenuItem mntmAgendamento = new JMenuItem("Agendamento");
		mntmAgendamento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnPesquisa.add(mntmAgendamento);

		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnPesquisa.add(mntmCliente_1);

		JMenuItem mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
		mntmFuncionrio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnPesquisa.add(mntmFuncionrio);

		JMenuItem mntmOrdemDeServio = new JMenuItem("Ordem de Servi\u00E7o");
		mntmOrdemDeServio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnPesquisa.add(mntmOrdemDeServio);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		mnRelatrios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnRelatrios);

		JMenu mnSobre = new JMenu("Ajuda");
		mnSobre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnSobre);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormSobre telaSobre = new FormSobre();
				telaSobre.setVisible(true);

			}
		});
		mnSobre.add(mntmSobre);

		JLabel lblPlanoDeFundo = new JLabel("Plano de Fundo");
		lblPlanoDeFundo.setBounds(0, 0, 1196, 634);
		contentPane.add(lblPlanoDeFundo);
		lblPlanoDeFundo.setIcon(new ImageIcon(
				FormMainEJZ.class.getResource("/Imagens/119344_Papel-de-Parede-Fundo-de-Luz_1680x1050.jpg")));
	}
}
