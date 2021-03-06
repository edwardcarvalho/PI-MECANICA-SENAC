package senac.agendamento.assets.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import senac.agendamento.dao.AgendamentoDAO;
import senac.agendamento.dao.ClienteDAO;
import senac.agendamento.model.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPesquisaAgendamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpfCliente;
	private JTextField txtNomeCliente;
	private JTable tableAgendamento;
	private JTextField txtCelular;

	ClienteDAO clienteDao = new ClienteDAO();
	AgendamentoDAO agendamentoDao = new AgendamentoDAO();

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
	 * 
	 * @throws ParseException
	 */
	public FormPesquisaAgendamento() throws ParseException {
		setBounds(100, 100, 773, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPesquisarCliente = new JLabel("Pesquisar Agendamento");
		lblPesquisarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisarCliente.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPesquisarCliente.setBounds(0, 0, 757, 47);
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

		// faz a busca atraves do CPF e apresenta em uma tabela o agendamento do
		// cliente. Se o CPF n�o estiver cadastrado, uma mensagem ser� exibida.
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtCpfCliente.getText().equals("   .   .   -  ")) {
					JOptionPane.showMessageDialog(null, "Digite um CPF para pesquisa!");
				} else {

					String cpf = txtCpfCliente.getText().replaceAll("\\D", "");
					Cliente cliente = clienteDao.buscarCliente(cpf);
					if (cliente == null) {
						JOptionPane.showMessageDialog(null, "CPF n�o cadastrado!");
					} else {
						txtNomeCliente.setText(cliente.getNomeCliente());
						txtCelular.setText(cliente.getTelefoneCelular());

						agendamentoDao.atualizarTabelaCarrosAgendados(cliente.getIdCliente(), tableAgendamento);

						if (tableAgendamento.getRowCount() == 0) {
							JOptionPane.showMessageDialog(null, "Cliente n�o possui agendamento!");
						}
					}
				}

			}
		});
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
		scrollPane.setBounds(39, 216, 682, 105);
		contentPane.add(scrollPane);

		tableAgendamento = new JTable();
		tableAgendamento.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Placa", "Data", "Horario Inicial", "Horario Final", "Unidade", "Status" }));
		scrollPane.setViewportView(tableAgendamento);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(39, 176, 46, 14);
		contentPane.add(lblCelular);

		MaskFormatter celMask = new MaskFormatter("(##)#####-####");
		txtCelular = new JFormattedTextField(celMask);
		txtCelular.setEditable(false);
		txtCelular.setBounds(86, 173, 93, 20);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
	}
}
