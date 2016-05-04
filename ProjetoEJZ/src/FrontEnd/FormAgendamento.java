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
		setBounds(100, 100, 784, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgendamentoDeHrs = new JLabel("Agendamento de Hor\u00E1rios");
		lblAgendamentoDeHrs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendamentoDeHrs.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAgendamentoDeHrs.setBounds(0, 0, 708, 51);
		contentPane.add(lblAgendamentoDeHrs);
		
		JPanel panelAgendamento = new JPanel();
		panelAgendamento.setBounds(0, 62, 768, 390);
		contentPane.add(panelAgendamento);
		panelAgendamento.setLayout(null);
		
		JLabel lblPesquisarCliente = new JLabel("M\u00E9todo de Pesquisa");
		lblPesquisarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPesquisarCliente.setBounds(42, 51, 129, 23);
		panelAgendamento.add(lblPesquisarCliente);
		
		JComboBox comboBoxBuscaCliente = new JComboBox();
		comboBoxBuscaCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxBuscaCliente.setModel(new DefaultComboBoxModel(new String[] {"...", "Nome", "CPF", "Placa do Veiculo"}));
		comboBoxBuscaCliente.setBounds(42, 78, 142, 20);
		panelAgendamento.add(comboBoxBuscaCliente);
		
		txtCampoBuscaCliente = new JTextField();
		txtCampoBuscaCliente.setBounds(194, 78, 432, 20);
		panelAgendamento.add(txtCampoBuscaCliente);
		txtCampoBuscaCliente.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCliente.setBounds(637, 77, 89, 23);
		panelAgendamento.add(btnBuscarCliente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(42, 127, 46, 14);
		panelAgendamento.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(355, 127, 24, 14);
		panelAgendamento.add(lblCpf);
		
		JLabel lblPlacaDoVeiculo = new JLabel("Placa do Veiculo");
		lblPlacaDoVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlacaDoVeiculo.setBounds(528, 130, 104, 14);
		panelAgendamento.add(lblPlacaDoVeiculo);
		
		txtNomeCadastrado = new JTextField();
		txtNomeCadastrado.setEditable(false);
		txtNomeCadastrado.setBounds(85, 127, 260, 20);
		panelAgendamento.add(txtNomeCadastrado);
		txtNomeCadastrado.setColumns(10);
		
		txtCPFcadastrado = new JTextField();
		txtCPFcadastrado.setEditable(false);
		txtCPFcadastrado.setBounds(389, 127, 129, 20);
		panelAgendamento.add(txtCPFcadastrado);
		txtCPFcadastrado.setColumns(10);
		
		txtPlacaVeiculoCadastrado = new JTextField();
		txtPlacaVeiculoCadastrado.setEditable(false);
		txtPlacaVeiculoCadastrado.setBounds(637, 129, 89, 20);
		panelAgendamento.add(txtPlacaVeiculoCadastrado);
		txtPlacaVeiculoCadastrado.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(42, 172, 103, 20);
		panelAgendamento.add(dateChooser);
		
		JButton btnPesquisaData = new JButton("Pesquisar");
		btnPesquisaData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisaData.setBounds(155, 170, 104, 23);
		panelAgendamento.add(btnPesquisaData);
		
		JLabel lblHorriosDisponiveis = new JLabel("Hor\u00E1rios Disponiveis");
		lblHorriosDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorriosDisponiveis.setBounds(42, 207, 129, 23);
		panelAgendamento.add(lblHorriosDisponiveis);
		
		JLabel lblNewLabel = new JLabel("Status");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(333, 278, 46, 14);
		panelAgendamento.add(lblNewLabel);
		
		JComboBox comboBoxStatusAgendamento = new JComboBox();
		comboBoxStatusAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxStatusAgendamento.setModel(new DefaultComboBoxModel(new String[] {"...", "Agendado", "Em atendimento", "Atendido"}));
		comboBoxStatusAgendamento.setBounds(334, 302, 142, 23);
		panelAgendamento.add(comboBoxStatusAgendamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(42, 241, 270, 109);
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
		lblReviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviso.setBounds(334, 213, 61, 17);
		panelAgendamento.add(lblReviso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"...", "Revis\u00E3o - 10.000 km", "Revis\u00E3o - 20.000 km", "Revis\u00E3o - 30.000 km", "Revis\u00E3o - 40.000 km", "Revis\u00E3o - 50.000 km", "Revis\u00E3o - 60.000 km", "Revis\u00E3o - 70.000 km", "Revis\u00E3o - 80.000 km", "Revis\u00E3o - 90.000 km", "Revis\u00E3o - 100.000 km", "Revis\u00E3o - Acima de 100.000 km"}));
		comboBox.setBounds(333, 241, 222, 23);
		panelAgendamento.add(comboBox);
		
		JButton btnCancelar = new JButton("Cancelar");
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
		btnCancelar.setBounds(637, 339, 89, 23);
		panelAgendamento.add(btnCancelar);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgendar.setBounds(537, 339, 89, 23);
		panelAgendamento.add(btnAgendar);
		
		JLabel lblNroAgendamento = new JLabel("Nro. Agendamento");
		lblNroAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNroAgendamento.setBounds(42, 11, 116, 23);
		panelAgendamento.add(lblNroAgendamento);
		
		txtNumeroAgendamento = new JTextField();
		txtNumeroAgendamento.setEditable(false);
		txtNumeroAgendamento.setBounds(170, 14, 86, 20);
		panelAgendamento.add(txtNumeroAgendamento);
		txtNumeroAgendamento.setColumns(10);
	}
}
