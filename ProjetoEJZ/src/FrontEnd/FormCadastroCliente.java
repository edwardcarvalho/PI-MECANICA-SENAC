package FrontEnd;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ButtonGroup;

public class FormCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtDataNascimentoCliente;
	private JTextField txtCpfCliente;
	private JTextField txtTelefoneCliente;
	private JTextField txtCelularCliente;
	private JTextField txtPlacaVeiculoCliente;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtIdCliente;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCadastroCliente frame = new FormCadastroCliente();
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
	public FormCadastroCliente() throws ParseException {
		setBounds(100, 100, 651, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label label = new Label("Cadastro de Clientes");
		label.setFont(new Font("Dialog", Font.BOLD, 28));
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 0, 638, 51);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 59, 635, 343);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 66, 46, 14);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(66, 63, 295, 20);
		txtNomeCliente.getText().toUpperCase();
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		MaskFormatter dateMask = new MaskFormatter("##/##/####");
		dateMask.setPlaceholderCharacter('_');

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(382, 66, 135, 14);
		panel.add(lblDataDeNascimento);

		txtDataNascimentoCliente = new JFormattedTextField(dateMask);
		txtDataNascimentoCliente.setBounds(520, 61, 93, 20);
		panel.add(txtDataNascimentoCliente);
		txtDataNascimentoCliente.setColumns(10);

		MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(10, 104, 46, 14);
		panel.add(lblCpf);

		txtCpfCliente = new JFormattedTextField(cpfMask);
		txtCpfCliente.setBounds(66, 101, 146, 20);
		panel.add(txtCpfCliente);
		txtCpfCliente.setColumns(10);

		MaskFormatter foneMask = new MaskFormatter("(##) ####-####");

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(231, 104, 59, 14);
		panel.add(lblTelefone);

		txtTelefoneCliente = new JFormattedTextField(foneMask);
		txtTelefoneCliente.setBounds(300, 101, 102, 20);
		panel.add(txtTelefoneCliente);
		txtTelefoneCliente.setColumns(10);

		MaskFormatter celularMask = new MaskFormatter("(##) #####-####");

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(425, 104, 46, 14);
		panel.add(lblCelular);

		txtCelularCliente = new JFormattedTextField(celularMask);
		txtCelularCliente.setColumns(10);
		txtCelularCliente.setBounds(480, 101, 115, 20);
		panel.add(txtCelularCliente);

		MaskFormatter placaMask = new MaskFormatter("UUU-####");

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaca.setBounds(10, 187, 46, 14);
		panel.add(lblPlaca);

		txtPlacaVeiculoCliente = new JFormattedTextField(placaMask);
		txtPlacaVeiculoCliente.setBounds(66, 184, 93, 20);
		panel.add(txtPlacaVeiculoCliente);
		txtPlacaVeiculoCliente.setColumns(10);

		JLabel lblMarca = new JLabel("Modelo");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(169, 184, 46, 14);
		panel.add(lblMarca);

		JComboBox comboBoxModeloCarro = new JComboBox();
		comboBoxModeloCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxModeloCarro.setModel(
				new DefaultComboBoxModel(new String[] { "...", "ACCORD", "CITY", "CIVIC", "CR-V", "FIT", "HR-V" }));
		comboBoxModeloCarro.setBounds(226, 181, 115, 20);
		panel.add(comboBoxModeloCarro);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCor.setBounds(351, 184, 46, 14);
		panel.add(lblCor);

		JComboBox comboBoxCorCarro = new JComboBox();
		comboBoxCorCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCorCarro.setModel(new DefaultComboBoxModel(new String[] { "...", "AZUL", "BRANCO", "CINZA", "CHUMBO",
				"DOURADO", "LARANJA", "MARROM", "PRATA", "PRETO", "VERMELHO", "VINHO" }));
		comboBoxCorCarro.setBounds(378, 181, 115, 20);
		panel.add(comboBoxCorCarro);

		JLabel lblCambioManual = new JLabel("C\u00E2mbio");
		lblCambioManual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCambioManual.setBounds(10, 230, 46, 14);
		panel.add(lblCambioManual);

		JRadioButton rdbtnCambioManual = new JRadioButton("Mec\u00E2nico");
		buttonGroup.add(rdbtnCambioManual);
		rdbtnCambioManual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCambioManual.setBounds(66, 226, 86, 23);
		panel.add(rdbtnCambioManual);

		JRadioButton rdbtnCambioAutomtico = new JRadioButton("Autom\u00E1tico");
		buttonGroup.add(rdbtnCambioAutomtico);
		rdbtnCambioAutomtico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCambioAutomtico.setBounds(161, 226, 116, 23);
		panel.add(rdbtnCambioAutomtico);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Cancelar o cadastro?", "Confirma��o",
						JOptionPane.YES_NO_OPTION);
				if (opcao == 0) {
					FormCadastroCliente.this.setVisible(false);
				} else {

				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(524, 281, 89, 23);
		panel.add(btnCancelar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtNomeCliente.getText().isEmpty() ||
						txtDataNascimentoCliente.getText().equals("__/__/__") ||
						txtCpfCliente.getText().equals("   .   .   -  ") ||
						txtCelularCliente.getText().equals("(  )      -    ") ||
						txtTelefoneCliente.getText().equals("(  )     -    )") ||
						txtEmail.getText().isEmpty() ||
						txtPlacaVeiculoCliente.getText().equals("   -    ") || 
						comboBoxCorCarro.getSelectedItem().equals("...") ||
						comboBoxModeloCarro.getSelectedItem().equals("...")) {

					JOptionPane.showMessageDialog(null, "Complete todos os campos!");
					FormCadastroCliente.this.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "Cadastro feito com Sucesso!");
					FormCadastroCliente.this.setVisible(false);
				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(402, 283, 89, 23);
		panel.add(btnSalvar);

		JLabel lblAnoCarro = new JLabel("Ano");
		lblAnoCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnoCarro.setBounds(503, 184, 29, 14);
		panel.add(lblAnoCarro);

		JComboBox comboBoxAnoCarro = new JComboBox();
		comboBoxAnoCarro.setModel(new DefaultComboBoxModel(new String[] { "...", "2016", "2015", "2014", "2013", "2012",
				"2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999",
				"1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991" }));
		comboBoxAnoCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxAnoCarro.setBounds(533, 181, 80, 20);
		panel.add(comboBoxAnoCarro);
		
		JLabel lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCliente.setBounds(10, 11, 59, 14);
		panel.add(lblIdCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setBounds(73, 8, 58, 20);
		panel.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 144, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(66, 143, 246, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
	}
}