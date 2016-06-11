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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import senac.agendamento.dao.AgendamentoDAO;
import senac.agendamento.dao.DAO;
import senac.agendamento.model.Agendamento;
import senac.agendamento.model.Automovel;
import senac.agendamento.model.Cliente;
import senac.agendamento.model.Funcionario;
import senac.agendamento.model.Servico;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.zip.CheckedOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FormAgendamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampoBuscaCliente;
	private JTextField txtCampoBuscaClienteCpf;
	private JTextField txtNomeCadastrado;
	private JTextField txtCPFcadastrado;
	private JTextField txtPlacaVeiculoCadastrado;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Cliente cliente;
	private Automovel automovelCliente;
	private String horarioInicial;
	private String horarioFinal;
	private ArrayList<Automovel> placas;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Agendamento> horariosDisponiveis;
	private ArrayList<Servico> servicos;

	AgendamentoDAO agendamentoDao = new AgendamentoDAO();
	Agendamento agendamento = new Agendamento();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAgendamento frame = new FormAgendamento();
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
	public FormAgendamento() throws ParseException {
		setBounds(100, 100, 801, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAgendamentoDeHrs = new JLabel("Agendamento de Hor\u00E1rios");
		lblAgendamentoDeHrs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendamentoDeHrs.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAgendamentoDeHrs.setBounds(0, 0, 785, 51);
		contentPane.add(lblAgendamentoDeHrs);

		JPanel panelAgendamento = new JPanel();
		panelAgendamento.setBounds(1, 64, 784, 388);
		contentPane.add(panelAgendamento);
		panelAgendamento.setLayout(null);

		MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
		txtCampoBuscaClienteCpf = new JFormattedTextField(cpfMask);
		txtCampoBuscaClienteCpf.setBounds(86, 50, 104, 20);
		panelAgendamento.add(txtCampoBuscaClienteCpf);
		txtCampoBuscaClienteCpf.setColumns(10);

		txtNomeCadastrado = new JTextField();
		txtNomeCadastrado.setBounds(85, 87, 260, 20);
		txtNomeCadastrado.setEditable(false);
		panelAgendamento.add(txtNomeCadastrado);
		txtNomeCadastrado.setColumns(10);

		MaskFormatter cpfMask2 = new MaskFormatter("###.###.###-##");
		txtCPFcadastrado = new JFormattedTextField(cpfMask2);
		txtCPFcadastrado.setBounds(389, 87, 129, 20);
		txtCPFcadastrado.setEditable(false);
		panelAgendamento.add(txtCPFcadastrado);
		txtCPFcadastrado.setColumns(10);

		JComboBox comboBoxUnidade = new JComboBox();
		comboBoxUnidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxUnidade.setBounds(42, 150, 143, 20);
		comboBoxUnidade.setModel(new DefaultComboBoxModel(new String[] { "...", "Morumbi", "Brooklin" }));
		panelAgendamento.add(comboBoxUnidade);

		JComboBox comboBoxPlacasCadastradas = new JComboBox();
		comboBoxPlacasCadastradas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxPlacasCadastradas.setBounds(637, 87, 91, 20);
		panelAgendamento.add(comboBoxPlacasCadastradas);

		// botão buscar dispara a função para o BD trazer para a tela os dados
		// do cliente cadastrado.
		JButton btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// verifica se o campo CPF foi preenchido para fazer a busca no
				// BD.

				if (txtCampoBuscaClienteCpf.getText().equals("   .   .   -  ")) {

					JOptionPane.showMessageDialog(null, "Digite um CPF para fazer a busca!");

				} else {

					cliente = agendamentoDao.buscarCliente(txtCampoBuscaClienteCpf.getText().replaceAll("\\D", ""));

					// se o CPF for corretamente digitado, mas não estiver
					// cadastrado no BD, retornará uma mensagem com esta
					// informação.
					if (cliente == null) {
						JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
					} else {

						// se o CPF for corretamente digitado e encontrado no
						// BD, os dados de cadastro do cliente aparecerão na
						// tela e
						// um comboBox com a(s) placa(s) do(s) automovel(is)
						// será preenchido.

						automovelCliente = agendamentoDao.buscarAutomovelCliente(cliente.getIdCliente());
						txtNomeCadastrado.setText(cliente.getNomeCliente());
						txtCPFcadastrado.setText(cliente.getCpf().trim());
						comboBoxPlacasCadastradas.removeAllItems();

						placas = agendamentoDao.buscarPlacaComboBox(cliente);
						for (Automovel a : placas) {
							comboBoxPlacasCadastradas.addItem(a.getPlaca());
						}
					}

				}
			}
		});
		btnBuscarCliente.setBounds(203, 48, 89, 23);
		btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(btnBuscarCliente);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(42, 87, 46, 14);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblNome);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(355, 87, 24, 14);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblCpf);

		JLabel lblPlacaDoVeiculo = new JLabel("Placa do Veiculo");
		lblPlacaDoVeiculo.setBounds(528, 90, 104, 14);
		lblPlacaDoVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblPlacaDoVeiculo);

		JDateChooser calendario = new JDateChooser();
		calendario.setBounds(208, 150, 103, 20);
		panelAgendamento.add(calendario);

		JLabel lblHorriosDisponiveis = new JLabel("Hor\u00E1rios Dispon\u00EDveis");
		lblHorriosDisponiveis.setBounds(41, 183, 129, 23);
		lblHorriosDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblHorriosDisponiveis);

		JLabel lblReviso = new JLabel("Servi\u00E7o");
		lblReviso.setBounds(43, 250, 61, 17);
		lblReviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblReviso);

		JComboBox comboBoxServicos = new JComboBox();
		comboBoxServicos.setBounds(42, 272, 222, 23);
		comboBoxServicos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxServicos.addItem("...");
		servicos = agendamentoDao.buscarServicos();
		for (Servico s : servicos) {
			comboBoxServicos.addItem(s.getDescricao());
		}
		panelAgendamento.add(comboBoxServicos);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(647, 333, 89, 23);

		// caso o operador deseje cancelar a operaçao de agendamento, o form se
		// fecha sem qualquer inclusão no BD.
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cancelar o agendamento?",
						"Confirmação de Cancelamento", JOptionPane.YES_NO_OPTION);
				if (opcao == 0) {
					FormAgendamento.this.setVisible(false);
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(btnCancelar);

		JButton btnAgendar = new JButton("Agendar");

		btnAgendar.setBounds(547, 333, 89, 23);
		btnAgendar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(btnAgendar);
		panelAgendamento.add(btnAgendar);

		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setBounds(42, 53, 46, 14);
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblCpf_1);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(42, 126, 61, 14);
		lblUnidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblUnidade);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(209, 128, 46, 14);
		panelAgendamento.add(lblData);

		JComboBox comboBoxHorarioDisponivel = new JComboBox();
		comboBoxHorarioDisponivel.setBounds(41, 210, 165, 20);
		panelAgendamento.add(comboBoxHorarioDisponivel);

		JRadioButton rdbtnFilaDeEspera = new JRadioButton("Fila de Espera");
		rdbtnFilaDeEspera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFilaDeEspera.setBounds(236, 209, 109, 23);
		panelAgendamento.add(rdbtnFilaDeEspera);

		JButton btnPesquisaData = new JButton("Pesquisar");
		btnPesquisaData.setBounds(335, 149, 104, 23);
		btnPesquisaData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(btnPesquisaData);

		// botão de pesquisa de horarios disponiveis
		btnPesquisaData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// verifica se os campos CPF, comboBox Unidade e data de
				// agendamento foram preenchidos corretamente.
				// se algum dos campos não estiverem preenchidos o processo não
				// segue adiante.

				rdbtnFilaDeEspera.setSelected(false);

				if (txtCampoBuscaClienteCpf.getText().equals("   .   .   -  ")
						|| comboBoxUnidade.getSelectedItem().equals("...") || calendario.getDate() == null) {

					JOptionPane.showMessageDialog(null, "Complete todos os campos para fazer a pesquisa!");

				} else {

					// é feita verificação, para saber se a data informada é
					// uma data atual ou futura, válida. Se não for, será
					// apresentada mensagem de erro.

					boolean dataValida = agendamento.verificaDataAgendamentoValida(calendario.getDate());

					if (!dataValida) {
						JOptionPane.showMessageDialog(null, "Data Inválida!");
						calendario.setDate(null);
						comboBoxHorarioDisponivel.removeAllItems();
					} else {

						// com os campos preenchidos corretamente, o
						// comboBoxHorariosDiponiveis é preenchido com base nos
						// dados informados pelo operador.

						int unidade = comboBoxUnidade.getSelectedIndex();
						int id_cliente = cliente.getIdCliente();
						Object date = calendario.getDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String data = sdf.format(date);

						horariosDisponiveis = agendamentoDao.buscarHorariosDisponiveis(unidade, data);
						comboBoxHorarioDisponivel.setModel(agendamento.mostraHorariosDisponiveis(horariosDisponiveis));
					}
				}

				ComboBoxModel comboPesquisa = comboBoxHorarioDisponivel.getModel();

				// se o radioButton "Fila de Espera" for selecionado, no
				// comboBox serão mostrados todos os horarios.

				rdbtnFilaDeEspera.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (rdbtnFilaDeEspera.isSelected()) {
							comboBoxHorarioDisponivel.setModel(new DefaultComboBoxModel(
									new String[] { "...", "Manhã (8h00 às 12h00)", "Tarde (13h15 às 17h15)" }));
						} else {

							// se o radioButton "Fila de Espera" não for
							// selecionado o comboBox volta a apresentar os
							// resultados da pesquisa.
							comboBoxHorarioDisponivel.setModel(new DefaultComboBoxModel());
							for (int i = 0; i < comboPesquisa.getSize(); i++) {
								comboBoxHorarioDisponivel.addItem(comboPesquisa.getElementAt(i));
							}
						}
					}
				});

			}
		});

		// o botão agendar realiza o registro no banco de dados do agendamento.
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// inicialmente é feita a checagem do preenchimento
				// de todos os campos. Se não estiverem todos preenchidos, será
				// apresentada mensagem de erro.

				if (comboBoxUnidade.getSelectedItem().toString().equals("...") || calendario.getDate() == null
						|| comboBoxHorarioDisponivel.getSelectedItem().equals("...")
						|| comboBoxServicos.getSelectedItem().equals("...")
						|| txtCPFcadastrado.getText().equals("   .   .   -  ")) {

					JOptionPane.showMessageDialog(null, "Complete todos os campos!");

				} else {
					// é feita verificação, para saber se a data informada é
					// uma data atual ou futura, válida. Se não for, será
					// apresentada mensagem de erro.

					boolean dataValida = agendamento.verificaDataAgendamentoValida(calendario.getDate());

					if (!dataValida) {
						JOptionPane.showMessageDialog(null, "Data Inválida!");
						calendario.setDate(null);
						comboBoxHorarioDisponivel.removeAllItems();
					} else {

						// com os campos preenchidos corretamente são extraidos
						// da tela os dados para criação de um objeto
						// agendamento.

						Object date = calendario.getDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String data = sdf.format(date);

						String periodo = comboBoxHorarioDisponivel.getSelectedItem().toString();
						if (periodo.contains("Manhã")) {
							horarioInicial = "8:00";
							horarioFinal = "12:00";
						} else {
							horarioInicial = "13:15";
							horarioFinal = "17:15";
						}

						int idAutomovel = 0;
						for (Automovel a : placas) {
							if (a.getPlaca().toString()
									.equalsIgnoreCase(comboBoxPlacasCadastradas.getSelectedItem().toString())) {
								idAutomovel = a.getIdAutomovel();
							}
						}

						int idUnidade = comboBoxUnidade.getSelectedIndex();

						String status = null;
						int idFuncionario;
						if (rdbtnFilaDeEspera.isSelected()) {

							// se o radioButton "Fila de Espera" estiver
							// selecionado, é feita busca no banco dos
							// funcionarios disponiveis e o primeiro(index 0)
							// será incluido no agendamento.
							// o status do agendamento é alterado para "FILA DE
							// ESPERA";

							status = "FILA DE ESPERA";
							ArrayList<Funcionario> funcionariosListaEspera = new ArrayList<>();
							funcionariosListaEspera = agendamentoDao.buscarFuncionariosFilaDeEspera(idUnidade, data,
									horarioInicial);
							idFuncionario = funcionariosListaEspera.get(0).getIdFuncionario();

						} else {

							// se o radioButton "Fila de Espera" não estiver
							// selecionado, é feita busca no banco dos
							// funcionarios disponiveis e o primeiro(index 0)
							// será incluido no agendamento.
							// o status do agendamento é alterado para
							// "AGENDADO";

							status = "AGENDADO";
							funcionarios = agendamentoDao.buscarFuncionariosDisponiveis(idUnidade, data,
									horarioInicial);
							idFuncionario = funcionarios.get(0).getIdFuncionario();
						}

						int idServico = comboBoxServicos.getSelectedIndex();

						// é criado um objeto agendamento com os dados inseridos
						// em tela.

						Agendamento agendamento = new Agendamento();

						agendamento.setIdAutomovel(idAutomovel);
						agendamento.setIdFuncionario(idFuncionario);
						agendamento.setIdServico(idServico);
						agendamento.setStatusAgendamento(status);
						agendamento.setDataAgendamento(data);
						agendamento.setHorarioInicial(horarioInicial);
						agendamento.setHorarioFinal(horarioFinal);
						agendamento.setIdUnidade(idUnidade);

						// antes de salvar o agendamento no BD é feita uma
						// verificação afim de evitar duplicidades, envolvendo a
						// mesma data, horario e veiculo.

						boolean duplicado = agendamentoDao.verificarDuplicidadeAgendamento(agendamento);

						if (duplicado) {
							JOptionPane.showMessageDialog(null,
									"Este veiculo ja possui agendamento para este dia e horario.");
						} else {

							// passando pela verificação de duplicidade o
							// agendamento é inserido no banco de dados.

							boolean agendou = agendamentoDao.agendarCliente(agendamento);

							if (agendou) {
								JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");
								FormAgendamento.this.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "Falha no agendamento. Contate o administrador.");
							}
						}
					}
				}
			}
		});

	}
}
