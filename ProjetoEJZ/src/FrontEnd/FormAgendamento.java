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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class FormAgendamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampoBuscaCliente;
	private JTextField txtCampoBuscaCliente_1;
	private JTextField txtNomeCadastrado;
	private JTextField txtCPFcadastrado;
	private JTextField txtPlacaVeiculoCadastrado;
	private JTable tableHorariosDisponiveis;
	private JTextField txtNumeroAgendamento;

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
	 */
	public FormAgendamento() {
		setBounds(100, 100, 784, 594);
		setBounds(100, 100, 784, 444);
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
		panelAgendamento.setBounds(0, 42, 774, 380);
		panelAgendamento.setBounds(0, 62, 774, 375);
		contentPane.add(panelAgendamento);
		panelAgendamento.setLayout(null);
		
		JComboBox comboBoxBuscaCliente = new JComboBox();
		comboBoxBuscaCliente.setBounds(42, 50, 142, 20);
		comboBoxBuscaCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxBuscaCliente.setModel(new DefaultComboBoxModel(new String[] {"...", "Nome", "CPF", "Placa do Veiculo"}));
		panelAgendamento.add(comboBoxBuscaCliente);
		
		txtCampoBuscaCliente = new JTextField();
		txtCampoBuscaCliente.setBounds(194, 78, 432, 20);
		panelAgendamento.add(comboBoxBuscaCliente);
		
		txtCampoBuscaCliente_1 = new JTextField();
		txtCampoBuscaCliente_1.setBounds(194, 50, 432, 20);
		panelAgendamento.add(txtCampoBuscaCliente_1);
		txtCampoBuscaCliente_1.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setBounds(637, 49, 89, 23);
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
		
		txtNomeCadastrado = new JTextField();
		txtNomeCadastrado.setBounds(85, 87, 260, 20);
		txtNomeCadastrado.setEditable(false);
		panelAgendamento.add(txtNomeCadastrado);
		txtNomeCadastrado.setColumns(10);
		
		txtCPFcadastrado = new JTextField();
		txtCPFcadastrado.setBounds(389, 87, 129, 20);
		txtCPFcadastrado.setEditable(false);
		panelAgendamento.add(txtCPFcadastrado);
		txtCPFcadastrado.setColumns(10);
		
		txtPlacaVeiculoCadastrado = new JTextField();
		txtPlacaVeiculoCadastrado.setBounds(637, 89, 89, 20);
		txtPlacaVeiculoCadastrado.setEditable(false);
		panelAgendamento.add(txtPlacaVeiculoCadastrado);
		txtPlacaVeiculoCadastrado.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(42, 132, 103, 20);
		panelAgendamento.add(dateChooser);
		
		JButton btnPesquisaData = new JButton("Pesquisar");
		btnPesquisaData.setBounds(155, 130, 104, 23);
		btnPesquisaData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(btnPesquisaData);
		
		JLabel lblHorriosDisponiveis = new JLabel("Hor\u00E1rios Disponiveis");
		lblHorriosDisponiveis.setBounds(42, 167, 129, 23);
		lblHorriosDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblHorriosDisponiveis);
		
		JLabel lblNewLabel = new JLabel("Status");
		lblNewLabel.setBounds(333, 238, 46, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblNewLabel);
		
		JComboBox comboBoxStatusAgendamento = new JComboBox();
		comboBoxStatusAgendamento.setBounds(334, 262, 142, 20);
		comboBoxStatusAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxStatusAgendamento.setModel(new DefaultComboBoxModel(new String[] {"...", "Agendado", "Em atendimento", "Atendido"}));
		panelAgendamento.add(comboBoxStatusAgendamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 201, 270, 109);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelAgendamento.add(scrollPane);
		
		tableHorariosDisponiveis = new JTable();
		scrollPane.setViewportView(tableHorariosDisponiveis);
		tableHorariosDisponiveis.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Horario", "Mecanico"
			}
		));
		tableHorariosDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblReviso = new JLabel("Servi\u00E7o");
		lblReviso.setBounds(334, 173, 61, 17);
		lblReviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblReviso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(333, 201, 222, 23);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"...", "Revis\u00E3o - 10.000 km", "Revis\u00E3o - 20.000 km", "Revis\u00E3o - 30.000 km", "Revis\u00E3o - 40.000 km", "Revis\u00E3o - 50.000 km", "Revis\u00E3o - 60.000 km", "Revis\u00E3o - 70.000 km", "Revis\u00E3o - 80.000 km", "Revis\u00E3o - 90.000 km", "Revis\u00E3o - 100.000 km", "Revis\u00E3o - Acima de 100.000 km"}));
		panelAgendamento.add(comboBox);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(637, 299, 89, 23);
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
		btnAgendar.setBounds(537, 299, 89, 23);
		btnAgendar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(btnAgendar);
		
		JLabel lblNroAgendamento = new JLabel("Nro. Agendamento");
		lblNroAgendamento.setBounds(42, 11, 116, 23);
		lblNroAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAgendamento.add(lblNroAgendamento);
		
		txtNumeroAgendamento = new JTextField();
		txtNumeroAgendamento.setBounds(170, 14, 86, 20);
		txtNumeroAgendamento.setEditable(false);
		panelAgendamento.add(txtNumeroAgendamento);
		txtNumeroAgendamento.setColumns(10);
		panelAgendamento.add(btnAgendar);
	}
}
