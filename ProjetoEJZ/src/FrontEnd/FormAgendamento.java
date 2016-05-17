package FrontEnd;

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

import BancoDados.Conexao;
import ClassesAtributos.Automovel;
import ClassesAtributos.Cliente;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.ButtonGroup;
import java.awt.Button;
import java.awt.Canvas;

public class FormAgendamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampoBuscaCliente;
	private JTextField txtCampoBuscaClienteCpf;
	private JTextField txtNomeCadastrado;
	private JTextField txtCPFcadastrado;
	private JTextField txtPlacaVeiculoCadastrado;
	private JTable tableHorariosDisponiveis;
	private Conexao conexao = new Conexao();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Cliente cliente;
	private Automovel automovelCliente;

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
		setBounds(100, 100, 784, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAgendamentoDeHrs = new JLabel("Agendamento de Hor\u00E1rios");
		lblAgendamentoDeHrs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendamentoDeHrs.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAgendamentoDeHrs.setBounds(0, 0, 768, 51);
		contentPane.add(lblAgendamentoDeHrs);

		JPanel panelAgendamento = new JPanel();
		panelAgendamento.setBounds(1, 64, 774, 468);
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

		JComboBox comboBoxStatusAgendamento = new JComboBox();
		comboBoxStatusAgendamento.setBounds(534, 330, 142, 20);
		comboBoxStatusAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxStatusAgendamento.setModel(new DefaultComboBoxModel(
				new String[] { "...", "Agendado", "Em atendimento", "Atendido", "Fila de Espera" }));
		panelAgendamento.add(comboBoxStatusAgendamento);

		JComboBox comboBoxUnidade = new JComboBox();
		comboBoxUnidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxUnidade.setBounds(42, 150, 143, 20);
		comboBoxUnidade.setModel(new DefaultComboBoxModel(new String[] { "...", "Morumbi", "Brooklin" }));
		panelAgendamento.add(comboBoxUnidade);

		JComboBox comboBoxPlacasCadastradas = new JComboBox();
		comboBoxPlacasCadastradas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxPlacasCadastradas.setBounds(637, 87, 91, 20);
		panelAgendamento.add(comboBoxPlacasCadastradas);

		JButton btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cliente = conexao.buscaCliente(txtCampoBuscaClienteCpf.getText().replaceAll("\\D", ""));
				automovelCliente = conexao.buscaAutomovelCliente(cliente.getIdCliente());
				txtNomeCadastrado.setText(cliente.getNomeCliente());
				txtCPFcadastrado.setText(cliente.getCpf().trim());
				comboBoxPlacasCadastradas.removeAllItems();

				ArrayList<String> placas = conexao.buscaPlacaComboBox(cliente);
				for (String a : placas) {
					comboBoxPlacasCadastradas.addItem(a);
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

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(214, 150, 103, 20);
		panelAgendamento.add(dateChooser);

		JLabel lblHorriosDisponiveis = new JLabel("Hor\u00E1rios Marcados");
		lblHorriosDisponiveis.setBounds(42, 217, 129, 23);
		lblHorriosDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblHorriosDisponiveis);

		JLabel lblNewLabel = new JLabel("Status");
		lblNewLabel.setBounds(533, 310, 46, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 251, 476, 151);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelAgendamento.add(scrollPane);

		tableHorariosDisponiveis = new JTable();
		scrollPane.setViewportView(tableHorariosDisponiveis);
		tableHorariosDisponiveis.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Horario", "Placa", "Cliente", "Servi\u00E7o", "Mecanico", "Status"
			}
		));
		tableHorariosDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblReviso = new JLabel("Servi\u00E7o");
		lblReviso.setBounds(534, 247, 61, 17);
		lblReviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblReviso);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(533, 269, 222, 23);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "...", "Revis\u00E3o - 10.000 km",
				"Revis\u00E3o - 20.000 km", "Revis\u00E3o - 30.000 km", "Revis\u00E3o - 40.000 km",
				"Revis\u00E3o - 50.000 km", "Revis\u00E3o - 60.000 km", "Revis\u00E3o - 70.000 km",
				"Revis\u00E3o - 80.000 km", "Revis\u00E3o - 90.000 km", "Revis\u00E3o - 100.000 km",
				"Revis\u00E3o - Acima de 100.000 km" }));
		panelAgendamento.add(comboBox);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(641, 427, 89, 23);
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
		btnAgendar.setBounds(541, 427, 89, 23);
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

		JRadioButton rdbtnManhhs = new JRadioButton("Matutino");
		buttonGroup.add(rdbtnManhhs);
		rdbtnManhhs.setBounds(337, 146, 83, 23);
		panelAgendamento.add(rdbtnManhhs);

		JRadioButton rdbtnTardehs = new JRadioButton("Vespertino");
		buttonGroup.add(rdbtnTardehs);
		rdbtnTardehs.setBounds(337, 165, 83, 23);
		panelAgendamento.add(rdbtnTardehs);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(214, 128, 46, 14);
		panelAgendamento.add(lblData);

		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeriodo.setBounds(342, 128, 61, 14);
		panelAgendamento.add(lblPeriodo);

		JButton btnPesquisaData = new JButton("Pesquisar");
		btnPesquisaData.setBounds(341, 195, 104, 23);
		btnPesquisaData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(btnPesquisaData);
		
		JLabel lblhsh = new JLabel(" (08h:00 \u00E1s 12h:00)");
		lblhsh.setBounds(417, 150, 104, 14);
		panelAgendamento.add(lblhsh);
		
		JLabel lblhsh_1 = new JLabel(" (13h:15 \u00E1s 17h:15)");
		lblhsh_1.setBounds(417, 169, 104, 14);
		panelAgendamento.add(lblhsh_1);
		btnPesquisaData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					
					String unidade = comboBoxUnidade.getSelectedItem().toString();
					String data = dateChooser.getDateFormatString().replaceAll("/", "-");
					String periodo = buttonGroup.getSelection().toString();
					
					conexao.atualizaTabelaAgendamento(unidade, data, periodo, tableHorariosDisponiveis);
					
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
