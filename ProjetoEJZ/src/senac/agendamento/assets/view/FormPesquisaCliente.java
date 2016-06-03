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

public class FormPesquisaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpfCliente;
	private JTextField txtNomeCliente;
	private JTable tableDadosCliente;
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
					FormPesquisaCliente frame = new FormPesquisaCliente();
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
	public FormPesquisaCliente() throws ParseException {
		setBounds(100, 100, 498, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPesquisarCliente = new JLabel("Pesquisar Cliente");
		lblPesquisarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisarCliente.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPesquisarCliente.setBounds(0, 0, 482, 47);
		contentPane.add(lblPesquisarCliente);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(39, 96, 33, 14);
		contentPane.add(lblCpf);
		
		MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
		
		txtCpfCliente = new JFormattedTextField(cpfMask);
		txtCpfCliente.setBounds(87, 95, 94, 20);
		contentPane.add(txtCpfCliente);
		txtCpfCliente.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = txtCpfCliente.getText().replaceAll("\\D", "");
				Cliente cliente = clienteDao.buscarCliente(cpf);
				if (cliente == null) {
					JOptionPane.showMessageDialog(null, "CPF não cadastrado!");
				} else {
					txtNomeCliente.setText(cliente.getNomeCliente());
					txtCelular.setText(cliente.getTelefoneCelular());

					clienteDao.atualizaTabelaCarrosCadastrado(cliente, tableDadosCliente);

					if (tableDadosCliente.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Cliente não possui automovel!");
					}
				}
				
				
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(196, 93, 108, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(39, 137, 46, 14);
		contentPane.add(lblNome);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setBounds(87, 136, 278, 20);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 216, 404, 105);
		contentPane.add(scrollPane);
		
		tableDadosCliente = new JTable();
		tableDadosCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Placa", "Modelo", "Cor", "Ano"
			}
		));
		scrollPane.setViewportView(tableDadosCliente);
		
		JLabel lblCpf_1 = new JLabel("Celular");
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf_1.setBounds(39, 173, 46, 14);
		contentPane.add(lblCpf_1);
		
		MaskFormatter celMask = new MaskFormatter("(##)#####-####");
		txtCelular = new JFormattedTextField(celMask);
		txtCelular.setEditable(false);
		txtCelular.setBounds(87, 170, 94, 20);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
	}
}
