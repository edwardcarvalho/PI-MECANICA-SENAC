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
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				idAgendamento = (int) tableVeiculosAgendados.getValueAt(tableVeiculosAgendados.getSelectedRow(), 0);
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
		comboBoxHorarios.setBounds(91, 72, 119, 20);
		panelAlteraDadosAgendamento.add(comboBoxHorarios);

		JRadioButton rdbtnFilaDeEspera = new JRadioButton("Fila de Espera");
		rdbtnFilaDeEspera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFilaDeEspera.setBounds(101, 99, 109, 23);
		panelAlteraDadosAgendamento.add(rdbtnFilaDeEspera);

		JLabel lblServios = new JLabel("Servi\u00E7os");
		lblServios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServios.setBounds(10, 125, 71, 20);
		panelAlteraDadosAgendamento.add(lblServios);

		JComboBox comboBoxServicos = new JComboBox();
		comboBoxServicos.setBounds(10, 156, 244, 20);
		panelAlteraDadosAgendamento.add(comboBoxServicos);

		btnCancelarAlteraDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormAlterarAgendamento.this.setVisible(false);
			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String CPF = txtBuscaCPF.getText().replaceAll("\\D", "");
				boolean achouCPF = clienteDAO.validaCpf(CPF);

				if (!achouCPF) {
					JOptionPane.showMessageDialog(null, "CPF não cadastrado!");
				} else {
					txtBuscaCPF.setEditable(false);
					btnEditar.setEnabled(true);
					Cliente cliente = clienteDAO.buscaCliente(CPF);
					txtNomeCliente.setText(cliente.getNomeCliente().toString());
					agendamentoDao.atualizaTabelaCarrosAgendados(cliente.getIdCliente(), tableVeiculosAgendados);
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

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tableVeiculosAgendados.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um agendamento para editar!");
				} else {

					panelAlteraDadosAgendamento.setVisible(true);
					ArrayList<Servico> servicos = agendamentoDao.buscaServicos();
					comboBoxServicos.addItem("...");
					for (Servico s : servicos) {
						comboBoxServicos.addItem(s.getDescricao());
					}

					btnPesquisarData.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int unidade = comboBoxUnidade.getSelectedIndex();
							Object date = dateChooser.getDate();
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							String data = sdf.format(date);
							ArrayList<Agendamento> horarios = agendamentoDao.buscaHorariosDisponiveis(unidade, data);
							comboBoxHorarios.setModel(agendamentoDao.mostraHorariosDisponiveis(horarios));

						}
					});

				}

			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(438, 289, 89, 23);
		contentPane.add(btnEditar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBoxUnidade.getSelectedItem().equals("...") || dateChooser.getDate() == null
						|| comboBoxHorarios.getSelectedItem().equals("...")
						|| comboBoxServicos.getSelectedItem().equals("...")) {

					JOptionPane.showMessageDialog(null, "Complete todos os campos!");
				}
			}
		});
		btnSalvar.setBounds(175, 198, 89, 23);
		panelAlteraDadosAgendamento.add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));

	}
}
