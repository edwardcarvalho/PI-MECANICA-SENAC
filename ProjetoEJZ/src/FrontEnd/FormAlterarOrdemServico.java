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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAlterarOrdemServico extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAlterarOrdemServico frame = new FormAlterarOrdemServico();
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
	public FormAlterarOrdemServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlterarOrdemServio = new JLabel("Alterar Ordem de Servi\u00E7o");
		lblAlterarOrdemServio.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarOrdemServio.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAlterarOrdemServio.setBounds(0, 0, 434, 51);
		contentPane.add(lblAlterarOrdemServio);
		
		JComboBox comboBoxBuscaOrdem = new JComboBox();
		comboBoxBuscaOrdem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBoxBuscaOrdem.getSelectedItem().equals("Numero O.S")){
					String opcao = JOptionPane.showInputDialog("Informe o numero da O.S para pesquisa:");
				}else if(comboBoxBuscaOrdem.getSelectedItem().equals("Nome")){
					String opcao = JOptionPane.showInputDialog("Informe o nome para pesquisa:");
				}else if(comboBoxBuscaOrdem.getSelectedItem().equals("CPF")){
					String opcao = JOptionPane.showInputDialog("Informe o numero do CPF para pesquisa:");
				}else if(comboBoxBuscaOrdem.getSelectedItem().equals("Placa Veículo")){
					String opcao = JOptionPane.showInputDialog("Informe a Placa do Veiculo para pesquisa:");
				}
			}
		});
		comboBoxBuscaOrdem.setModel(new DefaultComboBoxModel(new String[] {"...", "Numero O.S", "Nome", "CPF", "Placa Ve\u00EDculo"}));
		comboBoxBuscaOrdem.setBounds(45, 92, 138, 20);
		contentPane.add(comboBoxBuscaOrdem);
		
		JLabel lblMtodoDePesquisa = new JLabel("M\u00E9todo de Pesquisa:");
		lblMtodoDePesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtodoDePesquisa.setBounds(45, 76, 138, 14);
		contentPane.add(lblMtodoDePesquisa);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FormAlterarOrdemServico.this.setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(303, 91, 89, 23);
		contentPane.add(btnCancelar);
	}
}
