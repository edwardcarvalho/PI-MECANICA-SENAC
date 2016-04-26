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
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class FormCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeFuncionario;
	private JTextField txtCpfFuncionario;
	private JTextField txtDtNascimentoFuncionario;
	private JTextField txtTelefoneFuncionario;
	private JTextField txtCelularFuncionario;
	private JTextField txtIdFuncionario;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCadastroFuncionario frame = new FormCadastroFuncionario();
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
	public FormCadastroFuncionario() throws ParseException {
		setBounds(100, 100, 651, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label label = new Label("Cadastro de Funcion\u00E1rios");
		label.setFont(new Font("Dialog", Font.BOLD, 28));
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 0, 635, 58);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBounds(0, 64, 635, 345);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 68, 46, 14);
		lblNome.getText().toUpperCase();
		panel.add(lblNome);

		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setBounds(66, 65, 243, 20);
		panel.add(txtNomeFuncionario);
		txtNomeFuncionario.setColumns(10);

		MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(10, 104, 46, 14);
		panel.add(lblCpf);

		txtCpfFuncionario = new JFormattedTextField(cpfMask);
		txtCpfFuncionario.setBounds(65, 101, 106, 20);
		panel.add(txtCpfFuncionario);
		txtCpfFuncionario.setColumns(10);

		MaskFormatter dateMask = new MaskFormatter("##/##/####");
		dateMask.setPlaceholderCharacter('_');

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(334, 68, 131, 14);
		panel.add(lblDataDeNascimento);

		txtDtNascimentoFuncionario = new JFormattedTextField(dateMask);
		txtDtNascimentoFuncionario.setBounds(464, 67, 75, 20);
		panel.add(txtDtNascimentoFuncionario);
		txtDtNascimentoFuncionario.setColumns(10);

		MaskFormatter foneMask = new MaskFormatter("(##) ####-####");
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(10, 140, 56, 14);
		panel.add(lblTelefone);

		txtTelefoneFuncionario = new JFormattedTextField(foneMask);
		txtTelefoneFuncionario.setBounds(66, 139, 105, 20);
		panel.add(txtTelefoneFuncionario);
		txtTelefoneFuncionario.setColumns(10);

		MaskFormatter celularMask = new MaskFormatter("(##) #####-####");

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(12, 180, 46, 14);
		panel.add(lblCelular);

		txtCelularFuncionario = new JFormattedTextField(celularMask);
		txtCelularFuncionario.setBounds(68, 177, 104, 20);
		panel.add(txtCelularFuncionario);
		txtCelularFuncionario.setColumns(10);

		JLabel lblIdFuncionario = new JLabel("ID Matricula");
		lblIdFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdFuncionario.setBounds(12, 13, 98, 14);
		panel.add(lblIdFuncionario);

		txtIdFuncionario = new JTextField();
		txtIdFuncionario.setEditable(false);
		txtIdFuncionario.setBounds(114, 12, 58, 20);
		panel.add(txtIdFuncionario);
		txtIdFuncionario.setColumns(10);

		JButton btnSalvarCadastroFuncionario = new JButton("Salvar");
		btnSalvarCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNomeFuncionario.getText().isEmpty() || txtDtNascimentoFuncionario.getText().equals("__/__/____")
						|| txtCpfFuncionario.getText().equals("   .   .   -  ")
						|| txtTelefoneFuncionario.getText().equals("(  )     -    ")
						|| txtCelularFuncionario.getText().equals("(  )      -    ")) {

					JOptionPane.showMessageDialog(null, "Complete todos os campos!");
					FormCadastroFuncionario.this.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "Cadastro feito com Sucesso!");
					FormCadastroFuncionario.this.setVisible(false);
				}
			}
		});
		btnSalvarCadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvarCadastroFuncionario.setBounds(334, 264, 89, 23);
		panel.add(btnSalvarCadastroFuncionario);

		JButton btnCancelarCadastroFuncionario = new JButton("Cancelar");
		btnCancelarCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Cancelar o cadastro?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (opcao == 0) {
					FormCadastroFuncionario.this.setVisible(false);
				} else {

				}
			}
		});
		btnCancelarCadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarCadastroFuncionario.setBounds(458, 264, 89, 23);
		panel.add(btnCancelarCadastroFuncionario);

		JRadioButton rdbtnFuncionarioAdministrativo = new JRadioButton("Administrativo");
		rdbtnFuncionarioAdministrativo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rdbtnFuncionarioAdministrativo);
		rdbtnFuncionarioAdministrativo.setBounds(334, 140, 122, 23);
		panel.add(rdbtnFuncionarioAdministrativo);

		JRadioButton rdbtnFuncionarioOperacional = new JRadioButton("Operacional");
		rdbtnFuncionarioOperacional.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rdbtnFuncionarioOperacional);
		rdbtnFuncionarioOperacional.setBounds(334, 174, 109, 23);
		panel.add(rdbtnFuncionarioOperacional);
	}
}
