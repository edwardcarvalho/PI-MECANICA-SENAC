package FrontEnd;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormExcluirClienteFuncionario extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtMostraDadosExcluir;
	private JTextField txtMostraDadosExcluir_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormExcluirClienteFuncionario frame = new FormExcluirClienteFuncionario();
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
	public FormExcluirClienteFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblExcluirCliente = new JLabel("Excluir Cliente / Funcionario");
		lblExcluirCliente.setFont(new Font("Dialog", Font.BOLD, 28));
		lblExcluirCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirCliente.setBounds(0, 0, 456, 47);
		contentPane.add(lblExcluirCliente);

		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		buttonGroup.add(rdbtnCliente);
		rdbtnCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCliente.setBounds(26, 54, 69, 23);
		contentPane.add(rdbtnCliente);

		JRadioButton rdbtnFuncionario = new JRadioButton("Funcionario");
		buttonGroup.add(rdbtnFuncionario);
		rdbtnFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFuncionario.setBounds(100, 54, 101, 23);
		contentPane.add(rdbtnFuncionario);

		JLabel lblMtodoDePesquisa = new JLabel("M\u00E9todo de Pesquisa ");
		lblMtodoDePesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtodoDePesquisa.setBounds(34, 96, 133, 14);
		contentPane.add(lblMtodoDePesquisa);

		JLabel lblMostraDadosExcluir = new JLabel("Nome");
		lblMostraDadosExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMostraDadosExcluir.setBounds(35, 154, 46, 14);
		contentPane.add(lblMostraDadosExcluir);
		lblMostraDadosExcluir.setVisible(false);

		txtMostraDadosExcluir = new JTextField();
		txtMostraDadosExcluir.setEditable(false);
		txtMostraDadosExcluir.setBounds(81, 153, 319, 20);
		contentPane.add(txtMostraDadosExcluir);
		txtMostraDadosExcluir.setColumns(10);
		txtMostraDadosExcluir.setVisible(false);

		JLabel lblMostraDadosExcluir_2 = new JLabel("CPF");
		lblMostraDadosExcluir_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMostraDadosExcluir_2.setBounds(37, 192, 46, 14);
		contentPane.add(lblMostraDadosExcluir_2);
		lblMostraDadosExcluir_2.setVisible(false);

		txtMostraDadosExcluir_2 = new JTextField();
		txtMostraDadosExcluir_2.setEditable(false);
		txtMostraDadosExcluir_2.setBounds(81, 191, 132, 20);
		contentPane.add(txtMostraDadosExcluir_2);
		txtMostraDadosExcluir_2.setColumns(10);
		txtMostraDadosExcluir_2.setVisible(false);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int option = JOptionPane.showConfirmDialog(null, "Confirma a Exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION);
				if(option == 0){
					FormExcluirClienteFuncionario.this.setVisible(false);
				}else{
					
				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(236, 246, 89, 23);
		contentPane.add(btnExcluir);

		JComboBox comboBoxPesquisa = new JComboBox();
		comboBoxPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxPesquisa.setModel(new DefaultComboBoxModel(new String[] { "...", "ID", "Nome", "CPF" }));
		comboBoxPesquisa.setBounds(35, 115, 114, 20);
		contentPane.add(comboBoxPesquisa);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FormExcluirClienteFuncionario.this.setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(337, 246, 89, 23);
		contentPane.add(btnCancelar);

		comboBoxPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBoxPesquisa.getSelectedItem().equals("ID")) {

					String exclusaoID = JOptionPane.showInputDialog("Informe o ID para exclusão:");
					if (exclusaoID != null) {
						lblMostraDadosExcluir.setVisible(true);
						lblMostraDadosExcluir_2.setVisible(true);
						txtMostraDadosExcluir.setVisible(true);
						txtMostraDadosExcluir_2.setVisible(true);
					}else{
						lblMostraDadosExcluir.setVisible(false);
						lblMostraDadosExcluir_2.setVisible(false);
						txtMostraDadosExcluir.setVisible(false);
						txtMostraDadosExcluir_2.setVisible(false);
					}

				} else if (comboBoxPesquisa.getSelectedItem().equals("Nome")) {

					String exclusaoNome = JOptionPane.showInputDialog("Informe o nome para exclusão:");
					if (exclusaoNome != null) {
						lblMostraDadosExcluir.setVisible(true);
						lblMostraDadosExcluir_2.setVisible(true);
						txtMostraDadosExcluir.setVisible(true);
						txtMostraDadosExcluir_2.setVisible(true);
					}else{
						lblMostraDadosExcluir.setVisible(false);
						lblMostraDadosExcluir_2.setVisible(false);
						txtMostraDadosExcluir.setVisible(false);
						txtMostraDadosExcluir_2.setVisible(false);
					}

				} else if (comboBoxPesquisa.getSelectedItem().equals("CPF")) {

					String exclusaoCPF = JOptionPane.showInputDialog("Informe o CPF para exclusão:");
					if (exclusaoCPF != null) {
						lblMostraDadosExcluir.setVisible(true);
						lblMostraDadosExcluir_2.setVisible(true);
						txtMostraDadosExcluir.setVisible(true);
						txtMostraDadosExcluir_2.setVisible(true);
					}else{
						lblMostraDadosExcluir.setVisible(false);
						lblMostraDadosExcluir_2.setVisible(false);
						txtMostraDadosExcluir.setVisible(false);
						txtMostraDadosExcluir_2.setVisible(false);
					}

				}
			}
		});
	}
}
