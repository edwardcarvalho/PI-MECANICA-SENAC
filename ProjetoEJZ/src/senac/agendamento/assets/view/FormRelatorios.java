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

import com.toedter.calendar.JDateChooser;

import senac.agendamento.dao.RelatoriosDAO;
import senac.agendamento.model.Cliente;
import senac.agendamento.model.Funcionario;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FormRelatorios extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tableRelatorios;

	RelatoriosDAO relatoriosDao = new RelatoriosDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRelatorios frame = new FormRelatorios();
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
	public FormRelatorios() {
		setBounds(100, 100, 1010, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRelatrios = new JLabel("Relat\u00F3rios");
		lblRelatrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrios.setFont(new Font("Dialog", Font.BOLD, 28));
		lblRelatrios.setBounds(0, 0, 994, 51);
		contentPane.add(lblRelatrios);

		JPanel panel = new JPanel();
		panel.setBounds(0, 62, 994, 342);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataInicial.setBounds(18, 21, 72, 14);
		panel.add(lblDataInicial);

		JDateChooser dateInicial = new JDateChooser();
		dateInicial.setBounds(95, 20, 94, 23);
		panel.add(dateInicial);

		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataFinal.setBounds(199, 21, 72, 14);
		panel.add(lblDataFinal);

		JDateChooser dateFinal = new JDateChooser();
		dateFinal.setBounds(269, 20, 94, 23);
		panel.add(dateFinal);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(782, 21, 94, 23);
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 86, 955, 245);
		panel.add(scrollPane);

		tableRelatorios = new JTable();
		tableRelatorios.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Data", "Cliente", "Placa", "Status",
						"Servi\u00E7o", "Inicio", "T\u00E9rmino", "Unidade",
						"Funcionario", "Por Cliente" }));
		scrollPane.setViewportView(tableRelatorios);

		JComboBox comboBoxFiltros = new JComboBox();
		comboBoxFiltros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxFiltros.setModel(new DefaultComboBoxModel(new String[] {
				"Todos", "Cancelados", "Fila de Espera", "Agendados",
				"Finalizados" }));
		comboBoxFiltros.setBounds(638, 21, 123, 23);
		panel.add(comboBoxFiltros);

		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFiltro.setBounds(598, 22, 34, 14);
		panel.add(lblFiltro);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(382, 21, 36, 16);
		panel.add(lblTipo);

		JLabel lblOpcoes = new JLabel("Op\u00E7\u00F5es");
		lblOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOpcoes.setBounds(382, 54, 46, 21);
		panel.add(lblOpcoes);
		lblOpcoes.setVisible(false);

		JComboBox comboBoxOpcoes = new JComboBox();
		comboBoxOpcoes.setBounds(441, 54, 136, 22);
		panel.add(comboBoxOpcoes);
		comboBoxOpcoes.setVisible(false);

		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcao = comboBoxTipo.getSelectedIndex();

				if (opcao == 1) {
					comboBoxOpcoes.setVisible(true);
					lblOpcoes.setVisible(true);
					comboBoxOpcoes.setBounds(441, 54, 136, 22);
					ArrayList<Funcionario> funcionario = relatoriosDao
							.bucarTodosFuncionario();
					comboBoxOpcoes.removeAllItems();

					for (Funcionario f : funcionario) {
						comboBoxOpcoes.addItem(f.getNomeFuncionario());
					}
				} else if (opcao == 2) {
					comboBoxOpcoes.setVisible(true);
					lblOpcoes.setVisible(true);
					comboBoxOpcoes.removeAllItems();
				} else if (opcao == 3) {
					comboBoxOpcoes.setVisible(true);
					lblOpcoes.setVisible(true);
					comboBoxOpcoes.setBounds(441, 54, 320, 22);
					ArrayList<Cliente> clientes = relatoriosDao.bucarTodosClientes();
					comboBoxOpcoes.removeAllItems();
					
					for (Cliente c : clientes) {
						comboBoxOpcoes.addItem("ID " + c.getIdCliente() + " | " + c.getNomeCliente());
					}
				} else if (opcao == 0) {
					comboBoxOpcoes.setVisible(false);
					lblOpcoes.setVisible(false);
					comboBoxOpcoes.removeAllItems();
				}
			}
		});

		comboBoxTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {
				"Por Agendamentos", "Por Funcion\u00E1rios", "Por Unidade", "Por Cliente" }));
		comboBoxTipo.setBounds(421, 20, 156, 23);
		panel.add(comboBoxTipo);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Object dateIni = dateInicial.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dataIni = sdf.format(dateIni);

				Object dateFim = dateFinal.getDate();
				String dataFim = sdf.format(dateFim);

				int opcao = comboBoxTipo.getSelectedIndex();

				switch (opcao) {

				case 0:
					int filtro = comboBoxFiltros.getSelectedIndex();

					boolean pesquisa = relatoriosDao.relatorioDeAgendamentos(
							tableRelatorios, dataIni, dataFim, filtro);

					break;

				default:
					break;
				}

			}
		});
	}
}
