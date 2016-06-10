package senac.agendamento.assets.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import senac.agendamento.dao.AgendamentoDAO;

import javax.swing.JScrollPane;

public class FormBaixarAgendamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdAgendamento;
	private JTable tableBaixarAgendamento;
	private int idAgendamento = 0;

	AgendamentoDAO agendamentoDao = new AgendamentoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBaixarAgendamento frame = new FormBaixarAgendamento();
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
	public FormBaixarAgendamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBaixarAgendamento = new JLabel("Baixar Agendamento");
		lblBaixarAgendamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaixarAgendamento.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBaixarAgendamento.setBounds(0, 0, 337, 51);
		contentPane.add(lblBaixarAgendamento);

		JPanel panel = new JPanel();
		panel.setBounds(0, 53, 337, 202);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblInformeOId = new JLabel("Informe o ID do agendamento:");
		lblInformeOId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInformeOId.setBounds(17, 14, 200, 17);
		panel.add(lblInformeOId);

		txtIdAgendamento = new JTextField();
		txtIdAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdAgendamento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
// este keyTyped bloqueia a inserção de caracteres diferentes de numeros.

				String caracteres = "qwertyuiop´[]~çlkjhgfdsazxcvbnm,.;QWERTYUIOP`{}^ÇLKJHGFDSA|ZXCVBNM<>:";
				if (caracteres.contains(e.getKeyChar() + "")) {
					e.consume();

				}
			}
		});
		txtIdAgendamento.setBounds(215, 13, 98, 20);
		panel.add(txtIdAgendamento);
		txtIdAgendamento.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
// utiliza o idAgendamento digitado pelo operador e faz a busca do agendamento no BD. Se não existir, uma mensagem será exibida.

				idAgendamento = Integer.parseInt(txtIdAgendamento.getText().toString().replaceAll("\\D", " ").trim());

				boolean agendamento = agendamentoDao.atualizarTabelaBaixarCarrosAgendados(idAgendamento,
						tableBaixarAgendamento);

				if (!agendamento)
					JOptionPane.showMessageDialog(null, "Numero de agendamento inexistente!");

			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(215, 44, 101, 23);
		panel.add(btnPesquisar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormBaixarAgendamento.this.setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(228, 165, 89, 23);
		panel.add(btnCancelar);

		JButton btnBaixar = new JButton("Baixar");
		btnBaixar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
// ao clicar em baixar o status do agendamento é alterado para FINALIZADO.

				int opcao = JOptionPane.showConfirmDialog(null, "Confirma a baixa do agendamento?",
						"Baixar Agendamento", JOptionPane.YES_NO_OPTION);

				if (opcao == 0) {

					String status = "FINALIZADO";

					agendamentoDao.cancelarBaixarAgendamento(idAgendamento, status);
					JOptionPane.showMessageDialog(null, "Baixa realizada com sucesso!");
					FormBaixarAgendamento.this.setVisible(false);

				}
			}
		});
		btnBaixar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBaixar.setBounds(129, 165, 89, 23);
		panel.add(btnBaixar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 80, 299, 71);
		panel.add(scrollPane);

		tableBaixarAgendamento = new JTable();
		scrollPane.setViewportView(tableBaixarAgendamento);
		tableBaixarAgendamento
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Placa", "Data", "Status" }));
		tableBaixarAgendamento.setEnabled(false);
	}
}
