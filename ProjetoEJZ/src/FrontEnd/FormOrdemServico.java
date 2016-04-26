package FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;

public class FormOrdemServico extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscaCliente;
	private JTable table;
	private JTextField txtResponsavel;
	private JTextField txtBuscaItem;
	private JTable table_1;
	private JTextField txtNumeroOS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormOrdemServico frame = new FormOrdemServico();
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
	public FormOrdemServico() {
		setBounds(100, 100, 828, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAgendamentoOrdem = new JLabel("Ordem de Servi\u00E7o");
		lblAgendamentoOrdem.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAgendamentoOrdem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendamentoOrdem.setBounds(0, 0, 769, 59);
		contentPane.add(lblAgendamentoOrdem);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setBounds(44, 107, 46, 14);
		contentPane.add(lblCliente);

		JComboBox comboBoxCliente = new JComboBox();
		comboBoxCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCliente.setModel(
				new DefaultComboBoxModel(new String[] { "...", "Agendamento", "CPF", "Nome", "Placa Ve\u00EDculo" }));
		comboBoxCliente.setBounds(44, 127, 109, 20);
		contentPane.add(comboBoxCliente);

		txtBuscaCliente = new JTextField();
		txtBuscaCliente.setBounds(158, 127, 241, 20);
		contentPane.add(txtBuscaCliente);
		txtBuscaCliente.setColumns(10);

		JButton btnBuscarCAgendamento = new JButton("Buscar");
		btnBuscarCAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscarCAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCAgendamento.setBounds(409, 126, 89, 23);
		contentPane.add(btnBuscarCAgendamento);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 158, 452, 119);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "N\u00BA Agendamento", "Placa Veiculo", "Nome", "CPF", "Celular", "e-mail" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(2).setPreferredWidth(148);
		table.getColumnModel().getColumn(3).setPreferredWidth(87);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(67);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));

		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setColumnHeaderView(scrollBar);

		JLabel lblResponsavel = new JLabel("Respons\u00E1vel");
		lblResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponsavel.setBounds(44, 284, 81, 33);
		contentPane.add(lblResponsavel);

		txtResponsavel = new JTextField();
		txtResponsavel.setEditable(false);
		txtResponsavel.setBounds(129, 290, 259, 20);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(10);

		JButton btnConfirmarOs = new JButton("Confirmar");
		btnConfirmarOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmarOs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmarOs.setBounds(528, 546, 106, 23);
		contentPane.add(btnConfirmarOs);

		JButton btnCancelarOs = new JButton("Cancelar");
		btnCancelarOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcao = JOptionPane.showConfirmDialog(null, "Cancelar emissão de O.S?", "Cancelamento",
						JOptionPane.YES_NO_OPTION);
				if (opcao == 0) {
					FormOrdemServico.this.setVisible(false);
				}
			}
		});
		btnCancelarOs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarOs.setBounds(664, 545, 104, 23);
		contentPane.add(btnCancelarOs);

		JPanel panelServAdd = new JPanel();
		panelServAdd.setVisible(false);
		panelServAdd.setBounds(515, 127, 252, 328);
		contentPane.add(panelServAdd);
		panelServAdd.setLayout(null);

		JList listServicosIncluidos = new JList();
		listServicosIncluidos.setBounds(10, 43, 233, 235);
		panelServAdd.add(listServicosIncluidos);
		listServicosIncluidos.setBorder(new LineBorder(new Color(0, 0, 0)));
		listServicosIncluidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listServicosIncluidos.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JLabel lblServiosIncluidos = new JLabel("Servi\u00E7os Incluidos");
		lblServiosIncluidos.setBounds(9, 9, 116, 23);
		panelServAdd.add(lblServiosIncluidos);
		lblServiosIncluidos.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnExcluir = new JButton("Excluir Item");
		btnExcluir.setBounds(135, 295, 109, 23);
		panelServAdd.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panelIncluirServProd = new JPanel();
		panelIncluirServProd.setVisible(false);
		panelIncluirServProd.setBounds(25, 347, 421, 237);
		contentPane.add(panelIncluirServProd);
		panelIncluirServProd.setLayout(null);

		JLabel lblNewLabel = new JLabel("Item");
		lblNewLabel.setBounds(27, 19, 28, 17);
		panelIncluirServProd.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtBuscaItem = new JTextField();
		txtBuscaItem.setBounds(65, 19, 206, 20);
		panelIncluirServProd.add(txtBuscaItem);
		txtBuscaItem.setColumns(10);

		JButton btnBuscarItem = new JButton("Buscar");
		btnBuscarItem.setBounds(285, 18, 89, 23);
		panelIncluirServProd.add(btnBuscarItem);
		btnBuscarItem.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(18, 54, 354, 138);
		panelIncluirServProd.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Produto/Servi\u00E7o" }));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(106);
		scrollPane_1.setViewportView(table_1);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(284, 200, 89, 23);
		panelIncluirServProd.add(btnIncluir);
		btnIncluir.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JCheckBox chckbxIncluirServicos = new JCheckBox("Incluir Servi\u00E7os");
		chckbxIncluirServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxIncluirServicos.isSelected()) {
					panelIncluirServProd.setVisible(true);
					panelServAdd.setVisible(true);
				} else {
					panelIncluirServProd.setVisible(false);
					panelServAdd.setVisible(false);
				}
			}
		});
		chckbxIncluirServicos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxIncluirServicos.setBounds(41, 325, 126, 23);
		contentPane.add(chckbxIncluirServicos);
		
		JLabel lblOs = new JLabel("O.S");
		lblOs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOs.setBounds(43, 72, 30, 14);
		contentPane.add(lblOs);
		
		txtNumeroOS = new JTextField();
		txtNumeroOS.setEditable(false);
		txtNumeroOS.setBounds(81, 70, 86, 20);
		contentPane.add(txtNumeroOS);
		txtNumeroOS.setColumns(10);

	}
}
