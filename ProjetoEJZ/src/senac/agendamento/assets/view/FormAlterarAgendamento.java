package senac.agendamento.assets.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import senac.agendamento.dao.AgendamentoDAO;
import senac.agendamento.dao.ClienteDAO;
import senac.agendamento.model.Agendamento;
import senac.agendamento.model.Automovel;
import senac.agendamento.model.Cliente;
import senac.agendamento.model.Funcionario;
import senac.agendamento.model.Servico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import javax.swing.ImageIcon;

public class FormAlterarAgendamento extends JFrame {

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	ClienteDAO clienteDAO = new ClienteDAO();
	AgendamentoDAO agendamentoDao = new AgendamentoDAO();
	Agendamento agendamento = new Agendamento();

	private JPanel contentPane;
	private JTextField txtBuscaCPF;
	private JTextField txtNomeCliente;
	private JTable tableVeiculosAgendados;
	private int idAgendamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAlterarAgendamento frame = new FormAlterarAgendamento();
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
	public FormAlterarAgendamento() {
		setBounds(100, 100, 831, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlterarDadosDo = new JLabel("Alterar Agendamento");
		lblAlterarDadosDo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAlterarDadosDo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarDadosDo.setBounds(0, 0, 814, 51);
		contentPane.add(lblAlterarDadosDo);

		JLabel lblAtributoPesquisa = new JLabel("Informe o CPF:");
		lblAtributoPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtributoPesquisa.setBounds(15, 91, 105, 17);
		contentPane.add(lblAtributoPesquisa);
		lblAtributoPesquisa.setVisible(true);

		try {
			MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
			txtBuscaCPF = new JFormattedTextField(maskCPF);
			txtBuscaCPF.setBounds(124, 91, 117, 20);
			contentPane.add(txtBuscaCPF);
			txtBuscaCPF.setColumns(10);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JButton btnCancelarAlteraDados = new JButton("Cancelar");
		btnCancelarAlteraDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarAlteraDados.setBounds(713, 323, 89, 23);
		contentPane.add(btnCancelarAlteraDados);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(15, 137, 46, 14);
		contentPane.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setBounds(71, 136, 274, 20);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		
// ao clicar no agendamento mostrado na tabela o click do mouse captura o idAgendamento.
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				idAgendamento = Integer.parseInt(
						tableVeiculosAgendados.getValueAt(tableVeiculosAgendados.getSelectedRow(), 0).toString());
			}
		});
		scrollPane.setBounds(15, 185, 513, 90);
		contentPane.add(scrollPane);

		tableVeiculosAgendados = new JTable();
		tableVeiculosAgendados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableVeiculosAgendados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableVeiculosAgendados.setColumnSelectionAllowed(false);
		tableVeiculosAgendados.setCellSelectionEnabled(false);
		tableVeiculosAgendados.setRowSelectionAllowed(true);

		tableVeiculosAgendados.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Placa", "Data", "Horario Inicial", "Horario Final", "Unidade", "Status" }));
		scrollPane.setViewportView(tableVeiculosAgendados);

		JPanel panelAlteraDadosAgendamento = new JPanel();
		panelAlteraDadosAgendamento.setBounds(538, 91, 264, 221);
		contentPane.add(panelAlteraDadosAgendamento);
		panelAlteraDadosAgendamento.setLayout(null);
		panelAlteraDadosAgendamento.setVisible(false);

		JComboBox comboBoxUnidade = new JComboBox();
		comboBoxUnidade.setModel(new DefaultComboBoxModel(new String[] { "...", "Morumbi", "Brooklin" }));
		comboBoxUnidade.setBounds(91, 11, 119, 20);
		panelAlteraDadosAgendamento.add(comboBoxUnidade);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnidade.setBounds(10, 14, 71, 14);
		panelAlteraDadosAgendamento.add(lblUnidade);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 45, 46, 14);
		panelAlteraDadosAgendamento.add(lblData);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(91, 42, 119, 20);
		panelAlteraDadosAgendamento.add(dateChooser);

		JLabel lblHorrios = new JLabel("Hor\u00E1rios");
		lblHorrios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorrios.setBounds(10, 73, 71, 14);
		panelAlteraDadosAgendamento.add(lblHorrios);

		JComboBox comboBoxHorarios = new JComboBox();
		comboBoxHorarios.setBounds(91, 72, 163, 20);
		panelAlteraDadosAgendamento.add(comboBoxHorarios);

		JRadioButton rdbtnFilaDeEspera = new JRadioButton("Fila de Espera");
		rdbtnFilaDeEspera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFilaDeEspera.setBounds(91, 99, 109, 23);
		panelAlteraDadosAgendamento.add(rdbtnFilaDeEspera);

		JLabel lblServios = new JLabel("Servi\u00E7os");
		lblServios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServios.setBounds(10, 125, 71, 20);
		panelAlteraDadosAgendamento.add(lblServios);

		JComboBox comboBoxServicos = new JComboBox();
		comboBoxServicos.setBounds(10, 156, 244, 20);
		panelAlteraDadosAgendamento.add(comboBoxServicos);
		
// caso o operador queira cancelar a altera��o do agendamento, o form se fecha sem qualquer mudan�a no BD.
		btnCancelarAlteraDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormAlterarAgendamento.this.setVisible(false);
			}
		});

		JButton btnSalvarCancelamento = new JButton("Salvar");
		btnSalvarCancelamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvarCancelamento.setBounds(339, 289, 89, 23);
		contentPane.add(btnSalvarCancelamento);
		btnSalvarCancelamento.setVisible(false);

		JButton btnCancelarAgendamento = new JButton("Cancelar Agendamento");
		
// 	ao selecionar o agendamento na tabela o operador pode optar pelo cancelamento do agendamento. 
// 	neste caso � feito um update no banco alterando o status para "CANCELADO".
		btnCancelarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String status = "CANCELADO";
				btnSalvarCancelamento.setVisible(true);
				btnCancelarAgendamento.setVisible(false);
				btnSalvarCancelamento.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						idAgendamento = Integer.parseInt(tableVeiculosAgendados
								.getValueAt(tableVeiculosAgendados.getSelectedRow(), 0).toString());
						boolean cancelado = agendamentoDao.cancelarBaixarAgendamento(idAgendamento, status);

						if (cancelado) {
							JOptionPane.showMessageDialog(null, "Agendamento cancelado com sucesso!");
							FormAlterarAgendamento.this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Falha no cancelamento. Contate o administrador.");
							FormAlterarAgendamento.this.setVisible(false);
						}
					}
				});

			}
		});
		btnCancelarAgendamento.setEnabled(false);
		btnCancelarAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarAgendamento.setBounds(244, 289, 184, 23);
		contentPane.add(btnCancelarAgendamento);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
// verifica se o CPF digitado para busca, esta cadastrado no BD. Se n�o estiver, � disparada uma mensagem.

				String CPF = txtBuscaCPF.getText().replaceAll("\\D", "");
				boolean achouCPF = clienteDAO.validarCpf(CPF);

				if (!achouCPF) {
					JOptionPane.showMessageDialog(null, "CPF n�o cadastrado!");
				} else {
					
// com o CPF digitado cadastrado no BD, os dados do cliente s�o apresentados na tela.
					
					txtBuscaCPF.setEditable(false);
					btnCancelarAgendamento.setEnabled(true);
					btnEditar.setEnabled(true);
					Cliente cliente = clienteDAO.buscarCliente(CPF);
					txtNomeCliente.setText(cliente.getNomeCliente().toString());
					agendamentoDao.atualizarTabelaCarrosAgendados(cliente.getIdCliente(), tableVeiculosAgendados);

					if (tableVeiculosAgendados.getRowCount() == 0) {
						
// caso o cliente possua cadastro, mas n�o possua agendamento para ser mostrado, � disparado uma mensagem.
						
						JOptionPane.showMessageDialog(null, "Cliente n�o possui agendamento!");
						FormAlterarAgendamento.this.setVisible(false);
					}
				}

			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(256, 89, 89, 23);
		contentPane.add(btnBuscar);

		JButton btnPesquisarData = new JButton("");
		btnPesquisarData.setIcon(
				new ImageIcon(FormAlterarAgendamento.class.getResource("/senac/agendamento/assets/images/lupa.png")));
		btnPesquisarData.setBounds(218, 41, 36, 23);
		panelAlteraDadosAgendamento.add(btnPesquisarData);

// o bot�o editar libera a altera��o dos dados do agendamento.
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

// o operador deve selecionar um agendamento apresentado em tela, caso contrario n�o � possivel prosseguir com a edi��o.
				
				if (tableVeiculosAgendados.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um agendamento para editar!");
				} else {
					
// � feito o preenchimento do comboBox com os servi�os, cadastrado no BD.

					btnCancelarAgendamento.setEnabled(false);
					panelAlteraDadosAgendamento.setVisible(true);
					ArrayList<Servico> servicos = agendamentoDao.buscarServicos();
					comboBoxServicos.addItem("...");
					for (Servico s : servicos) {
						comboBoxServicos.addItem(s.getDescricao());
					}

					btnPesquisarData.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
// ao clicar em pesquisar os horarios disponiveis � feita a verifica��o se o campo Unidade e Data, est�o corretamente preenchidos.

							if (comboBoxUnidade.getSelectedItem().equals("...")) {
								JOptionPane.showMessageDialog(null, "Selecione uma unidade!");

							} else if (dateChooser.getDate() == null) {
								JOptionPane.showMessageDialog(null, "Selecione uma data para pesquisa!");

							} else {
								
// com os campos corretamente preenchidos, s�o mostrados em tela os horarios disponiveis.

								rdbtnFilaDeEspera.setSelected(false);
								int unidade = comboBoxUnidade.getSelectedIndex();
								Object date = dateChooser.getDate();
								SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
								String data = sdf.format(date);
								ArrayList<Agendamento> horarios = agendamentoDao.buscarHorariosDisponiveis(unidade,
										data);
								comboBoxHorarios.setModel(agendamento.mostraHorariosDisponiveis(horarios));

								ComboBoxModel comboPesquisa = comboBoxHorarios.getModel();
								rdbtnFilaDeEspera.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										
// se o radioButton "Fila de Espera" for selecionado, no comboBox ser�o mostrados todos os horarios.
										
										if (rdbtnFilaDeEspera.isSelected()) {
											comboBoxHorarios.setModel(new DefaultComboBoxModel(new String[] { "...",
													"Manh� (8h00 �s 12h00)", "Tarde (13h15 �s 17h15)" }));
										} else {
											
// se o radioButton "Fila de Espera" n�o for selecionado o comboBox volta a apresentar os resultados da pesquisa.
											
											comboBoxHorarios.setModel(new DefaultComboBoxModel());
											for (int i = 0; i < comboPesquisa.getSize(); i++) {
												comboBoxHorarios.addItem(comboPesquisa.getElementAt(i));
											}
										}
									}
								});
							}

						}

					});

				}

			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(438, 289, 89, 23);
		contentPane.add(btnEditar);
		
// o bot�o salvar dispara a a��o de gravar os dados alterados no BD.
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(175, 198, 89, 23);
		panelAlteraDadosAgendamento.add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int idUnidade;
				String horario;
				String horarioInicial;
				String horarioFinal;
				int idServico;
				
// inicialmente � feita verifica��o da data de agendamento, se � valida (atual ou futura).Caso contrario ser� apresentado uma mensagem.

				boolean dataValida = agendamento.verificaDataAgendamentoValida(dateChooser.getDate());

				if (!dataValida) {
					JOptionPane.showMessageDialog(null, "Data Inv�lida!");
					
				} else {
					
// � feita a checagem se todos os campos foram preenchidos com as op��es disponiveis. Caso n�o, � apresentado uma mensagem.

					if (comboBoxUnidade.getSelectedItem().equals("...") || dateChooser.getDate() == null
							|| comboBoxHorarios.getSelectedItem().equals("...")
							|| comboBoxServicos.getSelectedItem().equals("...")) {
						
						JOptionPane.showMessageDialog(null, "Complete todos os campos!");

					} else {
						
// passando dos requisitos anteriores, � criado um novo objeto agendamento, com as informa��es extraidas da tela.

						Agendamento updateAgendamento = new Agendamento();

						idUnidade = comboBoxUnidade.getSelectedIndex();
						updateAgendamento.setIdUnidade(idUnidade);

						Object date = dateChooser.getDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String data = sdf.format(date);
						updateAgendamento.setDataAgendamento(data);

						horario = comboBoxHorarios.getSelectedItem().toString();
						if (horario.contains("Manh�")) {
							horarioInicial = "8:00";
							horarioFinal = "12:00";
						} else {
							horarioInicial = "13:15";
							horarioFinal = "17:15";
						}
						updateAgendamento.setHorarioInicial(horarioInicial);
						updateAgendamento.setHorarioFinal(horarioFinal);

						idServico = comboBoxServicos.getSelectedIndex();
						updateAgendamento.setIdServico(idServico);

						int idFuncionario;
						String status;
						if (rdbtnFilaDeEspera.isSelected()) {
							
// se o radioButton "Fila de Espera" estiver selecionado, � feita busca no banco dos funcionarios disponiveis e o primeiro(index 0) ser� incluido no agendamento.
// o status do agendamento � alterado para "FILA DE ESPERA";
							
							status = "FILA DE ESPERA";
							ArrayList<Funcionario>funcionariosListaEspera = new ArrayList<>();
							funcionariosListaEspera = agendamentoDao.buscarFuncionariosFilaDeEspera(idUnidade, data, horarioInicial);
							idFuncionario = funcionariosListaEspera.get(0).getIdFuncionario();
						} else {
							
// se o radioButton "Fila de Espera" n�o estiver selecionado, � feita busca no banco dos funcionarios disponiveis e o primeiro(index 0) ser� incluido no agendamento.
// o status do agendamento � alterado para "AGENDADO";
							
							ArrayList<Funcionario> funcionario = agendamentoDao.buscarFuncionariosDisponiveis(idUnidade,
									data, horarioFinal);
							idFuncionario = funcionario.get(0).getIdFuncionario();
							status = "AGENDADO";
						}
						
						updateAgendamento.setStatusAgendamento(status);
						updateAgendamento.setIdFuncionario(idFuncionario);
						idAgendamento = Integer.parseInt(tableVeiculosAgendados
								.getValueAt(tableVeiculosAgendados.getSelectedRow(), 0).toString());
						updateAgendamento.setIdAgendamento(idAgendamento);

// � feita a altera��o do agendamento no BD.
						
						boolean agendar = agendamentoDao.alterarAgendamento(updateAgendamento);

						if (agendar) {
							JOptionPane.showMessageDialog(null, "Altera��o realizada com sucesso!");
							FormAlterarAgendamento.this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Falha na altera��o. Contate o administrador.");
							FormAlterarAgendamento.this.setVisible(false);
						}

					}
				}
			}
		});

	}
}
