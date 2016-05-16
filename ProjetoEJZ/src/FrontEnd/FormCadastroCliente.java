package FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import BancoDados.Conexao;
import ClassesAtributos.Automovel;
import ClassesAtributos.Cliente;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormCadastroCliente extends JFrame {

	Conexao conexao = new Conexao();
	Connection conn;
	Statement st;

	public static void removeMask(JTextField item) {
		item.getText().replaceAll("\\D", "");
	}

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtDataNascimentoCliente;
	private JTextField txtCpfCliente;
	private JTextField txtTelefoneCliente;
	private JTextField txtCelularCliente;
	private JTextField txtPlacaVeiculoCliente;
	private JTextField txtIdCliente;
	private JTable tableVeiculosCadastrados;
	private JButton btnAdicionar;
	private JScrollPane scrollPane;

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
	 * 
	 * @throws ParseException
	 */
	public FormCadastroCliente() throws ParseException {
		setBounds(100, 100, 866, 496);
		setBounds(100, 100, 768, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label label = new Label("Cadastro de Clientes");
		label.setFont(new Font("Dialog", Font.BOLD, 28));
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 0, 752, 51);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 59, 752, 441);
		panel.setBounds(0, 59, 752, 398);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCliente.setBounds(10, 11, 59, 14);
		panel.add(lblIdCliente);

		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setBounds(74, 8, 34, 20);
		panel.add(txtIdCliente);
		txtIdCliente.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(214, 50, 46, 14);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(270, 47, 295, 20);
		txtNomeCliente.getText().toUpperCase();
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		MaskFormatter dateMask = new MaskFormatter("##/##/####");
		dateMask.setPlaceholderCharacter('_');

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(10, 90, 135, 14);
		panel.add(lblDataDeNascimento);

		txtDataNascimentoCliente = new JFormattedTextField(dateMask);
		txtDataNascimentoCliente.setBounds(148, 85, 93, 20);
		panel.add(txtDataNascimentoCliente);
		txtDataNascimentoCliente.setColumns(10);

		MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(10, 50, 46, 14);
		panel.add(lblCpf);
		txtCpfCliente = new JFormattedTextField(cpfMask);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Cancelar o cadastro?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (opcao == 0) {
					FormCadastroCliente.this.setVisible(false);
				} else {

				}
			}
		});
		
		txtCpfCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String cpf = txtCpfCliente.getText().replaceAll("\\D", "").toString();

				try {
					boolean validacao = conexao.validaCpf(cpf);
					if (validacao) {
						JOptionPane.showMessageDialog(null, "CPF ja cadastrado!");
						int opcao = JOptionPane.showConfirmDialog(null, "Deseja editar?", "Confirmação de Edição",
								JOptionPane.YES_NO_OPTION);

						if (opcao == 0) {

							ArrayList<Cliente> cliente = conexao.buscaCliente(cpf);

							for (Cliente c : cliente) {
								txtIdCliente.setText(String.valueOf(c.getIdCliente()));
								txtCpfCliente.setText(c.getCpf());
								txtNomeCliente.setText(c.getNomeCliente());
								txtDataNascimentoCliente.setText(c.getDataNas().replaceAll("\\D", ""));
								txtCelularCliente.setText(c.getTelefoneCelular());
								txtTelefoneCliente.setText(c.getTelefoneRes());
								btnCancelar.setEnabled(false);
								conexao.mostraCarroCadastrado(c, tableVeiculosCadastrados);
								
								
								
							}
							
						} else {

							((JFormattedTextField) txtCpfCliente).setValue(null);
							txtCpfCliente.requestFocusInWindow();

						}

					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		txtCpfCliente.setBounds(66, 47, 125, 20);
		panel.add(txtCpfCliente);
		txtCpfCliente.setColumns(10);

		MaskFormatter foneMask = new MaskFormatter("(##) ####-####");

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(255, 88, 59, 14);
		panel.add(lblTelefone);

		txtTelefoneCliente = new JFormattedTextField(foneMask);
		txtTelefoneCliente.setBounds(324, 85, 102, 20);
		panel.add(txtTelefoneCliente);
		txtTelefoneCliente.setColumns(10);

		MaskFormatter celularMask = new MaskFormatter("(##) #####-####");

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(449, 88, 46, 14);
		panel.add(lblCelular);

		txtCelularCliente = new JFormattedTextField(celularMask);
		txtCelularCliente.setColumns(10);
		txtCelularCliente.setBounds(504, 85, 115, 20);
		panel.add(txtCelularCliente);

		MaskFormatter placaMask = new MaskFormatter("UUU-####");

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaca.setBounds(10, 176, 46, 14);
		panel.add(lblPlaca);

		txtPlacaVeiculoCliente = new JFormattedTextField(placaMask);
		txtPlacaVeiculoCliente.setEnabled(false);
		txtPlacaVeiculoCliente.setBounds(66, 173, 93, 20);
		panel.add(txtPlacaVeiculoCliente);
		txtPlacaVeiculoCliente.setColumns(10);

		JLabel lblMarca = new JLabel("Modelo");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(169, 173, 46, 14);
		panel.add(lblMarca);

		JComboBox comboBoxModeloCarro = new JComboBox();
		comboBoxModeloCarro.setEnabled(false);
		comboBoxModeloCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxModeloCarro.setModel(
				new DefaultComboBoxModel(new String[] { "...", "ACCORD", "CITY", "CIVIC", "CR-V", "FIT", "HR-V" }));
		comboBoxModeloCarro.setBounds(226, 170, 115, 20);
		panel.add(comboBoxModeloCarro);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCor.setBounds(351, 173, 46, 14);
		panel.add(lblCor);

		JComboBox comboBoxCorCarro = new JComboBox();
		comboBoxCorCarro.setEnabled(false);
		comboBoxCorCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCorCarro.setModel(new DefaultComboBoxModel(new String[] { "...", "AZUL", "BRANCO", "CINZA", "CHUMBO",
				"DOURADO", "LARANJA", "MARROM", "PRATA", "PRETO", "VERMELHO", "VINHO" }));
		comboBoxCorCarro.setBounds(378, 170, 115, 20);
		panel.add(comboBoxCorCarro);

		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(640, 269, 89, 23);
		btnCancelar.setBounds(640, 307, 89, 23);
		panel.add(btnCancelar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
				FormCadastroCliente.this.setVisible(false);
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(623, 117, 89, 23);
		btnSalvar.setBounds(640, 341, 89, 23);
		panel.add(btnSalvar);

		JLabel lblAnoCarro = new JLabel("Ano");
		lblAnoCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnoCarro.setBounds(503, 173, 29, 14);
		panel.add(lblAnoCarro);

		JComboBox comboBoxAnoCarro = new JComboBox();
		comboBoxAnoCarro.setEnabled(false);
		comboBoxAnoCarro.setModel(new DefaultComboBoxModel(new String[] { "...", "2016", "2015", "2014", "2013", "2012",
				"2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999",
				"1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991" }));
		comboBoxAnoCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxAnoCarro.setBounds(533, 170, 80, 20);
		panel.add(comboBoxAnoCarro);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setEnabled(false);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar.setBounds(623, 168, 104, 23);
		panel.add(btnAdicionar);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 207, 483, 141);
		panel.add(scrollPane);

		tableVeiculosCadastrados = new JTable();
		tableVeiculosCadastrados.setColumnSelectionAllowed(false);
		tableVeiculosCadastrados.setCellSelectionEnabled(false);
		tableVeiculosCadastrados.setRowSelectionAllowed(true);
		tableVeiculosCadastrados
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Placa", "Modelo", "Cor", "Ano" }));
		scrollPane.setViewportView(tableVeiculosCadastrados);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(405, 356, 89, 23);
		panel.add(btnExcluir);

		JButton btnCadastrarVeiculo = new JButton("Cadastrar Veiculo");
		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtNomeCliente.getText().length() < 4 || txtDataNascimentoCliente.getText().length() < 10
						|| txtCpfCliente.getText().length() < 14 || txtCelularCliente.getText().length() < 15
						|| txtTelefoneCliente.getText().length() < 14) {
					JOptionPane.showMessageDialog(null, "Complete todos os campos!");
					FormCadastroCliente.this.setVisible(true);

				} else {

					try {

						Cliente cliente = new Cliente(txtNomeCliente.getText().toString(),
								txtCpfCliente.getText().replaceAll("\\D", "").toString(),
								txtTelefoneCliente.getText().replaceAll("\\D", "").toString(),
								txtCelularCliente.getText().replaceAll("\\D", "").toString(),
								txtDataNascimentoCliente.getText().replaceAll("/", "-").toString());

						conexao.adicionaCliente(cliente);

						txtIdCliente.setText(String.valueOf(cliente.getIdCliente()));
						txtNomeCliente.setEditable(false);
						txtCpfCliente.setEditable(false);
						txtTelefoneCliente.setEditable(false);
						txtCelularCliente.setEditable(false);
						txtDataNascimentoCliente.setEditable(false);
						txtPlacaVeiculoCliente.setEnabled(true);
						comboBoxAnoCarro.setEnabled(true);
						comboBoxCorCarro.setEnabled(true);
						comboBoxModeloCarro.setEnabled(true);
						btnExcluir.setEnabled(true);
						btnAdicionar.setEnabled(true);
						btnSalvar.setEnabled(true);
						tableVeiculosCadastrados.setVisible(true);

						btnAdicionar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								try {
									if (txtPlacaVeiculoCliente.getText().length() < 8
											|| comboBoxCorCarro.getSelectedItem().equals("...")
											|| comboBoxModeloCarro.getSelectedItem().equals("...")
											|| comboBoxAnoCarro.getSelectedItem().equals("...")) {

										JOptionPane.showMessageDialog(null, "Complete todos os campos!");
										FormCadastroCliente.this.setVisible(true);

									} else {
										Automovel automovel = new Automovel(cliente,
												comboBoxModeloCarro.getSelectedItem().toString(),
												comboBoxCorCarro.getSelectedItem().toString(),
												comboBoxAnoCarro.getSelectedItem().toString(),
												txtPlacaVeiculoCliente.getText());
										conexao.adicionaAutomovel(automovel, cliente);

										conexao.mostraCarroCadastrado(cliente, tableVeiculosCadastrados);

										((JFormattedTextField) txtPlacaVeiculoCliente).setValue(null);
										comboBoxAnoCarro.setSelectedItem("...");
										comboBoxCorCarro.setSelectedItem("...");
										comboBoxModeloCarro.setSelectedItem("...");
									}
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});

					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		btnCadastrarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarVeiculo.setBounds(11, 124, 148, 23);
		panel.add(btnCadastrarVeiculo);
	}
}
