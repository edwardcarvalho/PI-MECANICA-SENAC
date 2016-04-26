package FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormBaixarOrdemServico extends JFrame {

	private JPanel contentPane;
	private JTextField txtMostraDadosBaixar;
	private JTextField txtMostraDadosBaixar_2;
	private JTextField txtOrdemServico;
	private JTextField txtPlacaVeiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBaixarOrdemServico frame = new FormBaixarOrdemServico();
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
	public FormBaixarOrdemServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBaixarOrdemServico = new JLabel("Baixar Ordem de Servi\u00E7o");
		lblBaixarOrdemServico.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBaixarOrdemServico.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaixarOrdemServico.setBounds(0, 0, 456, 47);
		contentPane.add(lblBaixarOrdemServico);

		JLabel lblMtodoDePesquisa = new JLabel("M\u00E9todo de Pesquisa ");
		lblMtodoDePesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtodoDePesquisa.setBounds(34, 72, 133, 20);
		contentPane.add(lblMtodoDePesquisa);

		JLabel lblMostraDadosBaixar = new JLabel("Nome");
		lblMostraDadosBaixar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMostraDadosBaixar.setBounds(35, 130, 46, 14);
		contentPane.add(lblMostraDadosBaixar);
		lblMostraDadosBaixar.setVisible(false);

		txtMostraDadosBaixar = new JTextField();
		txtMostraDadosBaixar.setEditable(false);
		txtMostraDadosBaixar.setBounds(81, 129, 319, 20);
		contentPane.add(txtMostraDadosBaixar);
		txtMostraDadosBaixar.setColumns(10);
		txtMostraDadosBaixar.setVisible(false);

		JLabel lblMostraDadosBaixar_2 = new JLabel("CPF");
		lblMostraDadosBaixar_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMostraDadosBaixar_2.setBounds(37, 168, 46, 14);
		contentPane.add(lblMostraDadosBaixar_2);
		lblMostraDadosBaixar_2.setVisible(false);

		txtMostraDadosBaixar_2 = new JTextField();
		txtMostraDadosBaixar_2.setEditable(false);
		txtMostraDadosBaixar_2.setBounds(81, 167, 132, 20);
		contentPane.add(txtMostraDadosBaixar_2);
		txtMostraDadosBaixar_2.setColumns(10);
		txtMostraDadosBaixar_2.setVisible(false);

		JButton btnBaixar = new JButton("Baixar O.S");
		btnBaixar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int option = JOptionPane.showConfirmDialog(null, "Confirma a Baixa da O.S?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (option == 0) {
					FormBaixarOrdemServico.this.setVisible(false);
				} else {

				}
			}
		});
		btnBaixar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBaixar.setBounds(200, 222, 101, 23);
		contentPane.add(btnBaixar);
		btnBaixar.setVisible(false);

		JComboBox comboBoxPesquisa = new JComboBox();
		comboBoxPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxPesquisa.setModel(new DefaultComboBoxModel(new String[] { "...", "Numero O.S" }));
		comboBoxPesquisa.setBounds(35, 94, 114, 20);
		contentPane.add(comboBoxPesquisa);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int opcao = JOptionPane.showConfirmDialog(null, "Cancelar a baixa da O.S?", "Confirmação",
						JOptionPane.YES_NO_OPTION);

				if (opcao == 0) {
					FormBaixarOrdemServico.this.setVisible(false);
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(313, 222, 89, 23);
		contentPane.add(btnCancelar);

		JLabel lblNumeroOs = new JLabel("O.S");
		lblNumeroOs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroOs.setBounds(281, 99, 29, 14);
		contentPane.add(lblNumeroOs);
		lblNumeroOs.setVisible(false);

		txtOrdemServico = new JTextField();
		txtOrdemServico.setEditable(false);
		txtOrdemServico.setBounds(315, 96, 86, 20);
		contentPane.add(txtOrdemServico);
		txtOrdemServico.setColumns(10);
		txtOrdemServico.setVisible(false);

		JLabel lblPlacaVeculo = new JLabel("Placa Ve\u00EDculo");
		lblPlacaVeculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlacaVeculo.setBounds(223, 170, 87, 14);
		contentPane.add(lblPlacaVeculo);
		lblPlacaVeculo.setVisible(false);

		txtPlacaVeiculo = new JTextField();
		txtPlacaVeiculo.setEditable(false);
		txtPlacaVeiculo.setBounds(315, 167, 86, 20);
		contentPane.add(txtPlacaVeiculo);
		txtPlacaVeiculo.setColumns(10);
		txtPlacaVeiculo.setVisible(false);

		comboBoxPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBoxPesquisa.getSelectedItem().equals("Numero O.S")) {

					String exclusaoID = JOptionPane.showInputDialog("Informe o numero da O.S para baixar:");
					if (exclusaoID != null) {
						lblMostraDadosBaixar.setVisible(true);
						lblMostraDadosBaixar_2.setVisible(true);
						txtMostraDadosBaixar.setVisible(true);
						txtMostraDadosBaixar_2.setVisible(true);
						lblPlacaVeculo.setVisible(true);
						txtPlacaVeiculo.setVisible(true);
						txtOrdemServico.setVisible(true);
						lblNumeroOs.setVisible(true);
						btnBaixar.setVisible(true);

					} else {
						lblMostraDadosBaixar.setVisible(false);
						lblMostraDadosBaixar_2.setVisible(false);
						txtMostraDadosBaixar.setVisible(false);
						txtMostraDadosBaixar_2.setVisible(false);
						lblPlacaVeculo.setVisible(false);
						txtPlacaVeiculo.setVisible(false);
						txtOrdemServico.setVisible(false);
						lblNumeroOs.setVisible(false);
						btnBaixar.setVisible(false);

					}

				}
			}
		});
	}
}
