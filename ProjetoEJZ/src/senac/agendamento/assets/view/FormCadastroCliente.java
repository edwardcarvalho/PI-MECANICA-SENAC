package senac.agendamento.assets.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import senac.agendamento.dao.ClienteDAO;
import senac.agendamento.dao.DAO;
import senac.agendamento.model.Automovel;
import senac.agendamento.model.Cliente;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormCadastroCliente extends JFrame{

	ClienteDAO clienteDAO = new ClienteDAO();

	public static void removeMask(JTextField item) {
		
//		função criada para remover mascara de um JtextFiel.
		
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
		
//		este keyAction tem a função de limitar a entrada de apenas letras no campo nome.
		
		txtNomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321<>.,?;:^~]}[{´`_-+='!@$%¨&*()|";
			       if(caracteres.contains(e.getKeyChar()+"")){
			              e.consume();

			       }
			}
		});
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
		txtCpfCliente.setBounds(66, 47, 125, 20);
		panel.add(txtCpfCliente);
		txtCpfCliente.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(640, 269, 89, 23);
		btnCancelar.setBounds(640, 307, 89, 23);
		panel.add(btnCancelar);
		btnCancelar.setVisible(false);

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
		
//		o focusLost tem como objetivo chamar a função que verifica a existencia da placa digitada no banco de dados, afim de evitar duplicidade.
		txtPlacaVeiculoCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				boolean validou = clienteDAO.validarPlaca(txtPlacaVeiculoCliente.getText().toString());
				if (validou) {
					JOptionPane.showMessageDialog(null, "Placa ja cadastrado!");
					((JFormattedTextField) txtPlacaVeiculoCliente).setValue(null);
					txtPlacaVeiculoCliente.requestFocusInWindow();
				}else{
				}
			}
		});
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


		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
//		ao clicar no botão salvar é feita a verificaçao de inclusao de veiculos para o cliente.
//		o cadastro só é salvo após o preenchimento de todos os campos e inclusão de veiculo(s).
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tableVeiculosCadastrados.getRowCount() > 0) {
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
					FormCadastroCliente.this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Complete todos os campos!");
				}

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

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(405, 356, 89, 23);
		panel.add(btnExcluir);
		btnExcluir.setEnabled(false);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 207, 483, 141);
		panel.add(scrollPane);
		tableVeiculosCadastrados = new JTable();
		tableVeiculosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableVeiculosCadastrados.setColumnSelectionAllowed(false);
		tableVeiculosCadastrados.setCellSelectionEnabled(false);
		tableVeiculosCadastrados.setRowSelectionAllowed(true);
		tableVeiculosCadastrados
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Placa", "Modelo", "Cor", "Ano" }));
		scrollPane.setViewportView(tableVeiculosCadastrados);

		JButton btnCancelar2 = new JButton("Cancelar");
		btnCancelar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCadastroCliente.this.setVisible(false);
			}
		});
		btnCancelar2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar2.setBounds(640, 307, 89, 23);
		panel.add(btnCancelar2);

		JButton btnCadastrarVeiculo = new JButton("Cadastrar Veiculo");
		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				ao clicar em cadastrar veiculo é feita a verificação, se todos os campos com os dados do cliente estão preenchidos.
//				se os dados estiverem incompletos o cadastro não segue adiante.

				if (txtNomeCliente.getText().length() < 4 || txtDataNascimentoCliente.getText().length() < 10
						|| txtCpfCliente.getText().length() < 14 || txtCelularCliente.getText().length() < 15
						|| txtTelefoneCliente.getText().length() < 14) {
					JOptionPane.showMessageDialog(null, "Complete todos os campos!");
					FormCadastroCliente.this.setVisible(true);

				} else {
					
//				com os dados completos é criado um objeto cliente e é chamada a função para inseri-lo no banco de dados.
//				o cliente é cadastrado no banco antes do veiculo, para que o banco gere um ID que será utilizado para fazer o link do veiculo com cliente.

					Cliente cliente = new Cliente(txtNomeCliente.getText().toString(),
							txtCpfCliente.getText().replaceAll("\\D", "").toString(),
							txtTelefoneCliente.getText().replaceAll("\\D", "").toString(),
							txtCelularCliente.getText().replaceAll("\\D", "").toString(),
							txtDataNascimentoCliente.getText().replaceAll("/", "-").toString());

					clienteDAO.salvarCliente(cliente);

//				após o cadastro do cliente ser realizado, é liberado ao usuario o preenchimento dos campos e cadastramento de veiculos para o cliente em questão.
					
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
					btnCancelar2.setVisible(false);
					btnCancelar.setVisible(true);
					tableVeiculosCadastrados.setVisible(true);

					btnCancelar.addActionListener(new ActionListener() {
						
//				caso o usuario chegue até os ultimos passos do cadastro e resolva cancelar a operação, o cliente é excluido do banco de dados.
						public void actionPerformed(ActionEvent e) {
							int opcao = JOptionPane.showConfirmDialog(null, "Cancelar o cadastro?", "Confirmação",
									JOptionPane.YES_NO_OPTION);
							if (opcao == 0) {
								clienteDAO.cancelarCadastro(Integer.valueOf(txtIdCliente.getText()));
								FormCadastroCliente.this.setVisible(false);
							} else {
								
							}
						}
					});

					btnAdicionar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
//				ao clicar em adicionar veiculo, é feita a verificação se todos os campos foram preenchidos corretamente.
//				se não estiverem o processo não segue adiante.
							
							if (txtPlacaVeiculoCliente.getText().equals("   -    ")
									|| comboBoxCorCarro.getSelectedItem().equals("...")
									|| comboBoxModeloCarro.getSelectedItem().equals("...")
									|| comboBoxAnoCarro.getSelectedItem().equals("...")) {

								JOptionPane.showMessageDialog(null, "Complete todos os campos!");
								FormCadastroCliente.this.setVisible(true);

							} else {
								
//				no caso dos campos estarem todos preenchidos, é criado um objeto automovel e passado para a função que irá fazer o insert do veiculo no banco de dados.
//				a tabela de cadastro de automoveis é atualizada e mostra o veiculo cadastrao para aquele cliente.
								
								Automovel automovel = new Automovel(cliente.getIdCliente(),
										comboBoxModeloCarro.getSelectedItem().toString(),
										comboBoxCorCarro.getSelectedItem().toString(),
										comboBoxAnoCarro.getSelectedItem().toString(),
										txtPlacaVeiculoCliente.getText());
								clienteDAO.salvarAutomovel(automovel, cliente);
								clienteDAO.atualizaTabelaCarrosCadastrado(cliente, tableVeiculosCadastrados);
								
//				após o insert do veiculo no banco de dados, o operador pode decidir exclui-lo caso algum dado esteja divergente.
//				este metodo capta a placa do veiculo ao click na linha da tabela.
								tableVeiculosCadastrados.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent arg0) {

										String placa = tableVeiculosCadastrados
												.getValueAt(tableVeiculosCadastrados.getSelectedRow(), 0)
												.toString();
										
//				ao clicar no botão excluir o dado contendo a placa captado anteriormente é passado para a função que faz a exclusão da placa no banco de dados.
										btnExcluir.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {

												clienteDAO.excluirAutomovel(placa);
												clienteDAO.atualizaTabelaCarrosCadastrado(cliente,
														tableVeiculosCadastrados);
											}
										});

									}
								});
								
//				apos inserir o veiculo no banco de dados, o codigo abaixo tem a função de deixar os campos relacionados a veiculo com valores default.			
								((JFormattedTextField) txtPlacaVeiculoCliente).setValue(null);
								comboBoxAnoCarro.setSelectedItem("...");
								comboBoxCorCarro.setSelectedItem("...");
								comboBoxModeloCarro.setSelectedItem("...");

							}
						}
					});

				}

			}
		});
		btnCadastrarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarVeiculo.setBounds(11, 125, 148, 23);
		panel.add(btnCadastrarVeiculo);

//		o botão alterar veiculo só fica visivel caso o CPF digitado esteja cadastrado no banco e o operador deseje alterar o cadastro.
		
		JButton btnAlterarVeiculo = new JButton("Alterar Veiculo");
		btnAlterarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtPlacaVeiculoCliente.setEnabled(true);
				comboBoxAnoCarro.setEnabled(true);
				comboBoxCorCarro.setEnabled(true);
				comboBoxModeloCarro.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnAdicionar.setEnabled(true);
				btnSalvar.setEnabled(true);
				tableVeiculosCadastrados.setVisible(true);

			}
		});
		btnAlterarVeiculo.setVisible(false);
		btnAlterarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarVeiculo.setBounds(10, 126, 148, 23);
		panel.add(btnAlterarVeiculo);
		
//		este focusLost verifica se o cpf digitado esta cadastrado no banco de dados.
		txtCpfCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String cpf = txtCpfCliente.getText().replaceAll("\\D", "").toString();

				boolean validacao = clienteDAO.validarCpf(cpf);
				if (validacao) {
//		caso o CPF exista no banco, ele oferece a opção de editar o cadastro.
					JOptionPane.showMessageDialog(null, "CPF ja cadastrado!");
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja editar?", "Confirmação de Edição",
							JOptionPane.YES_NO_OPTION);

					if (opcao == 0) {
						
//		se a opção escolhida for editar, o cpf é passado para a função que busca e preenche todos os campos com os dados do cliente e seu(s) automovel(is) cadastrado(s).

						Cliente cliente = clienteDAO.buscarCliente(cpf);

						txtIdCliente.setText(String.valueOf(cliente.getIdCliente()));
						txtCpfCliente.setText(cliente.getCpf());
						txtCpfCliente.setEditable(false);
						txtNomeCliente.setText(cliente.getNomeCliente());
						txtDataNascimentoCliente.setText(cliente.getDataNas().replaceAll("\\D", ""));
						txtCelularCliente.setText(cliente.getTelefoneCelular());
						txtTelefoneCliente.setText(cliente.getTelefoneRes());
						btnCancelar.setVisible(true);
						btnCancelar.setEnabled(true);
						btnCancelar2.setVisible(false);
						btnCadastrarVeiculo.setVisible(false);
						btnAlterarVeiculo.setVisible(true);
						clienteDAO.atualizaTabelaCarrosCadastrado(cliente, tableVeiculosCadastrados);
						btnSalvar.setVisible(false);

						JButton btnConcluirAlterao = new JButton("Concluir Altera\u00E7\u00E3o");
						btnConcluirAlterao.setFont(new Font("Tahoma", Font.PLAIN, 14));
						btnConcluirAlterao.setEnabled(false);
						btnConcluirAlterao.setBounds(581, 341, 148, 23);
						panel.add(btnConcluirAlterao);
						btnConcluirAlterao.setEnabled(true);
						
//		se no meio da alteração o operador deseje cancelar o processo, o form se fecha sem promover qualquer alteração.
						
						btnCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int opcao = JOptionPane.showConfirmDialog(null, "Cancelar o alteração?", "Confirmação",
										JOptionPane.YES_NO_OPTION);
								if (opcao == 0) {
									FormCadastroCliente.this.setVisible(false);
								} else {
									
								}
							}
						});

//		este metodo capta a placa do veiculo ao click na linha da tabela.
						tableVeiculosCadastrados.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent arg0) {

								String placa = tableVeiculosCadastrados
										.getValueAt(tableVeiculosCadastrados.getSelectedRow(), 0).toString();

								btnExcluir.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
//		ao clicar no botão excluir o dado contendo a placa captado anteriormente é passado para a função que faz a exclusão da placa no banco de dados.

										clienteDAO.excluirAutomovel(placa);
										clienteDAO.atualizaTabelaCarrosCadastrado(cliente, tableVeiculosCadastrados);
									}
								});

							}
						});
						
//		ao clicar em concluir a alteração é criado um novo objeto cliente e os dados são alterados no banco atraves da função alterarCliente().

						btnConcluirAlterao.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								Cliente altCliente = new Cliente(txtNomeCliente.getText().toString(),
										txtCpfCliente.getText().replaceAll("\\D", "").toString(),
										txtTelefoneCliente.getText().replaceAll("\\D", "").toString(),
										txtCelularCliente.getText().replaceAll("\\D", "").toString(),
										txtDataNascimentoCliente.getText().replaceAll("/", "-").toString());

								boolean atualiza = clienteDAO.alterarCliente(altCliente,
										Integer.valueOf((txtIdCliente.getText())));

//	 	é mostrada uma mensagem, confirmando a alteração.
								if (atualiza) {
									
									JOptionPane.showMessageDialog(null, "Alteração feita com sucesso!");
									FormCadastroCliente.this.setVisible(false);
								}

							}
						});

						btnAdicionar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
//	 		ao clicar em adicionar veiculo, é feita a verificação se todos os campos foram preenchidos corretamente.
//			se não estiverem o processo não segue adiante.

								if (txtPlacaVeiculoCliente.getText().equals("   -    ")
										|| comboBoxCorCarro.getSelectedItem().equals("...")
										|| comboBoxModeloCarro.getSelectedItem().equals("...")
										|| comboBoxAnoCarro.getSelectedItem().equals("...")) {

									JOptionPane.showMessageDialog(null, "Complete todos os campos!");
									FormCadastroCliente.this.setVisible(true);

								} else {
									
//			no caso dos campos estarem todos preenchidos, é criado um objeto automovel e passado para a função que irá fazer o insert do veiculo no banco de dados.
//			a tabela de cadastro de automoveis é atualizada e mostra o veiculo cadastrado/alterado para aquele cliente.
									
									Automovel automovel = new Automovel(cliente.getIdCliente(),
											comboBoxModeloCarro.getSelectedItem().toString(),
											comboBoxCorCarro.getSelectedItem().toString(),
											comboBoxAnoCarro.getSelectedItem().toString(),
											txtPlacaVeiculoCliente.getText());
									clienteDAO.salvarAutomovel(automovel, cliente);

									clienteDAO.atualizaTabelaCarrosCadastrado(cliente, tableVeiculosCadastrados);
									
//				apos inserir o veiculo no banco de dados, o codigo abaixo tem a função de deixar os campos relacionados a veiculo com valores default.	

									((JFormattedTextField) txtPlacaVeiculoCliente).setValue(null);
									comboBoxAnoCarro.setSelectedItem("...");
									comboBoxCorCarro.setSelectedItem("...");
									comboBoxModeloCarro.setSelectedItem("...");
								}
							}
						});

					} else {
						
//		caso o operador opte por não alterar os dados do cliente, o campo CPF retoma o focu do cursor e volta a seu valor default.

						((JFormattedTextField) txtCpfCliente).setValue(null);
						txtCpfCliente.requestFocusInWindow();

					}

				}
			}
		});

	}
}
