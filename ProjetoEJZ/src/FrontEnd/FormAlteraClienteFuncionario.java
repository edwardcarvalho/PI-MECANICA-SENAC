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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class FormAlteraClienteFuncionario extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnFuncionrio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAlteraClienteFuncionario frame = new FormAlteraClienteFuncionario();
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
	public FormAlteraClienteFuncionario() {
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlterarDadosDo = new JLabel("Alterar Dados Cadastrados");
		lblAlterarDadosDo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAlterarDadosDo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarDadosDo.setBounds(0, 0, 434, 51);
		contentPane.add(lblAlterarDadosDo);

		JLabel lblAtributoPesquisa = new JLabel("M\u00E9todo de Pesquisa :");
		lblAtributoPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtributoPesquisa.setBounds(42, 114, 147, 14);
		contentPane.add(lblAtributoPesquisa);
		lblAtributoPesquisa.setVisible(false);

		JComboBox comboBoxBusca = new JComboBox();
		comboBoxBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBoxBusca.getSelectedItem().equals("ID Cliente") || comboBoxBusca.getSelectedItem().equals("ID Funcionario")) {
					String buscaID = JOptionPane.showInputDialog("Informe o ID para pesquisa:");
				} else if (comboBoxBusca.getSelectedItem().equals("Nome")) {
					String buscaNome = JOptionPane.showInputDialog("Informe o nome para pesquisa:");
				} else if (comboBoxBusca.getSelectedItem().equals("CPF")) {
					String buscaCPF = JOptionPane.showInputDialog("Informe o CPF para pesquisa:");
				}else if(comboBoxBusca.getSelectedItem().equals("Placa Veículo")){
					String buscaPlaca = JOptionPane.showInputDialog("Informe a placa do veículo para pesquisa:");
				}
			}
		});
		comboBoxBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxBusca.setBounds(183, 111, 119, 20);
		contentPane.add(comboBoxBusca);
		comboBoxBusca.setVisible(false);

		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxBusca.setModel(	new DefaultComboBoxModel(new String[] { "...", "ID Cliente", "Nome", "CPF", "Placa Ve\u00EDculo" }));
				lblAtributoPesquisa.setVisible(true);
				comboBoxBusca.setVisible(true);
			}
		});
		rdbtnCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rdbtnCliente);
		rdbtnCliente.setBounds(38, 60, 109, 23);
		contentPane.add(rdbtnCliente);

		rdbtnFuncionrio = new JRadioButton("Funcion\u00E1rio");
		rdbtnFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxBusca.setModel(	new DefaultComboBoxModel(new String[] { "...", "ID Funcionario", "Nome", "CPF" }));
				lblAtributoPesquisa.setVisible(true);
				comboBoxBusca.setVisible(true);

			}
		});
		rdbtnFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rdbtnFuncionrio);
		rdbtnFuncionrio.setBounds(163, 59, 109, 23);
		contentPane.add(rdbtnFuncionrio);
		
		JButton btnCancelarAlteraDados = new JButton("Cancelar");
		btnCancelarAlteraDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormAlteraClienteFuncionario.this.setVisible(false);
			}
		});
		btnCancelarAlteraDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarAlteraDados.setBounds(325, 109, 89, 23);
		contentPane.add(btnCancelarAlteraDados);
	}
}
