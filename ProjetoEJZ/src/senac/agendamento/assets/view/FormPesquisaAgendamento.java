package senac.agendamento.assets.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class FormPesquisaAgendamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpfCliente;
	private JTextField txtNomeCliente;
	private JTable tableAgendamento;
	private JTextField txtCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPesquisaAgendamento frame = new FormPesquisaAgendamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FormPesquisaAgendamento() throws ParseException {
		setBounds(100, 100, 617, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPesquisarCliente = new JLabel("Pesquisar Agendamento");
		lblPesquisarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisarCliente.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPesquisarCliente.setBounds(0, 0, 601, 47);
		contentPane.add(lblPesquisarCliente);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(41, 96, 33, 14);
		contentPane.add(lblCpf);
		
		MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
		
		txtCpfCliente = new JFormattedTextField(cpfMask);
		txtCpfCliente.setBounds(85, 95, 94, 20);
		contentPane.add(txtCpfCliente);
		txtCpfCliente.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(194, 93, 108, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(39, 137, 46, 14);
		contentPane.add(lblNome);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setBounds(86, 136, 278, 20);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 216, 519, 105);
		contentPane.add(scrollPane);
		
		tableAgendamento = new JTable();
		tableAgendamento.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Horario", "Placa", "Modelo", "Cor", "Ano", "Status"
			}
		));
		scrollPane.setViewportView(tableAgendamento);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(39, 176, 46, 14);
		contentPane.add(lblCelular);
		
		MaskFormatter celMask = new MaskFormatter("(##)#####-####");
		txtCelular = new JFormattedTextField(celMask);
		txtCelular.setEditable(false);
		txtCelular.setBounds(86, 173, 86, 20);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
	}
}
