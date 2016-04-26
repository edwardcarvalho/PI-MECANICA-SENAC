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

public class FormExcluirOrdemServico extends JFrame {

	private JPanel contentPane;
	private JTextField txtMostraDadosExcluir;
	private JTextField txtMostraDadosExcluir_2;
	private JTextField txtMostraOS;
	private JTextField txtMostraPlacaVeiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormExcluirOrdemServico frame = new FormExcluirOrdemServico();
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
	public FormExcluirOrdemServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblExcluirOrdemServico = new JLabel("Excluir Ordem de Servi\u00E7o");
		lblExcluirOrdemServico.setFont(new Font("Dialog", Font.BOLD, 28));
		lblExcluirOrdemServico.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirOrdemServico.setBounds(0, 0, 456, 47);
		contentPane.add(lblExcluirOrdemServico);

		JLabel lblMtodoDePesquisa = new JLabel("M\u00E9todo de Pesquisa ");
		lblMtodoDePesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtodoDePesquisa.setBounds(34, 72, 133, 20);
		contentPane.add(lblMtodoDePesquisa);

		JLabel lblMostraDadosExcluir = new JLabel("Nome");
		lblMostraDadosExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMostraDadosExcluir.setBounds(35, 130, 46, 14);
		contentPane.add(lblMostraDadosExcluir);
		lblMostraDadosExcluir.setVisible(false);

		txtMostraDadosExcluir = new JTextField();
		txtMostraDadosExcluir.setEditable(false);
		txtMostraDadosExcluir.setBounds(81, 129, 319, 20);
		contentPane.add(txtMostraDadosExcluir);
		txtMostraDadosExcluir.setColumns(10);
		txtMostraDadosExcluir.setVisible(false);

		JLabel lblMostraDadosExcluir_2 = new JLabel("CPF");
		lblMostraDadosExcluir_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMostraDadosExcluir_2.setBounds(37, 168, 46, 14);
		contentPane.add(lblMostraDadosExcluir_2);
		lblMostraDadosExcluir_2.setVisible(false);

		txtMostraDadosExcluir_2 = new JTextField();
		txtMostraDadosExcluir_2.setEditable(false);
		txtMostraDadosExcluir_2.setBounds(81, 167, 132, 20);
		contentPane.add(txtMostraDadosExcluir_2);
		txtMostraDadosExcluir_2.setColumns(10);
		txtMostraDadosExcluir_2.setVisible(false);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int option = JOptionPane.showConfirmDialog(null, "Confirma a Exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION);
				if(option == 0){
					FormExcluirOrdemServico.this.setVisible(false);
				}else{
					
				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(212, 222, 89, 23);
		contentPane.add(btnExcluir);

		JComboBox comboBoxPesquisa = new JComboBox();
		comboBoxPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxPesquisa.setModel(new DefaultComboBoxModel(new String[] {"...", "Numero O.S"}));
		comboBoxPesquisa.setBounds(35, 94, 114, 20);
		contentPane.add(comboBoxPesquisa);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FormExcluirOrdemServico.this.setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(313, 222, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblMostraOs = new JLabel("O.S");
		lblMostraOs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMostraOs.setBounds(276, 99, 37, 14);
		contentPane.add(lblMostraOs);
		lblMostraOs.setVisible(false);
		
		txtMostraOS = new JTextField();
		txtMostraOS.setEditable(false);
		txtMostraOS.setBounds(314, 96, 86, 20);
		contentPane.add(txtMostraOS);
		txtMostraOS.setColumns(10);
		txtMostraOS.setVisible(false);
		
		JLabel lblPlacaVeiculo = new JLabel("Placa Ve\u00EDculo");
		lblPlacaVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlacaVeiculo.setBounds(225, 170, 89, 14);
		contentPane.add(lblPlacaVeiculo);
		lblPlacaVeiculo.setVisible(false);
		
		txtMostraPlacaVeiculo = new JTextField();
		txtMostraPlacaVeiculo.setEditable(false);
		txtMostraPlacaVeiculo.setBounds(315, 167, 86, 20);
		contentPane.add(txtMostraPlacaVeiculo);
		txtMostraPlacaVeiculo.setColumns(10);
		txtMostraPlacaVeiculo.setVisible(false);
		

		comboBoxPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBoxPesquisa.getSelectedItem().equals("Numero O.S")) {

					String exclusaoID = JOptionPane.showInputDialog("Informe o numero da O.S para exclusão:");
					if (exclusaoID != null) {
						lblMostraDadosExcluir.setVisible(true);
						lblMostraDadosExcluir_2.setVisible(true);
						txtMostraDadosExcluir.setVisible(true);
						txtMostraDadosExcluir_2.setVisible(true);
						lblMostraOs.setVisible(true);
						txtMostraOS.setVisible(true);
						lblPlacaVeiculo.setVisible(true);
						txtMostraPlacaVeiculo.setVisible(true);
						
					}else{
						lblMostraDadosExcluir.setVisible(false);
						lblMostraDadosExcluir_2.setVisible(false);
						txtMostraDadosExcluir.setVisible(false);
						txtMostraDadosExcluir_2.setVisible(false);
						lblMostraOs.setVisible(false);
						txtMostraOS.setVisible(false);
						lblPlacaVeiculo.setVisible(false);
						txtMostraPlacaVeiculo.setVisible(false);
					}

				} 
			}
		});
	}
}
