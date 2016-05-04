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

public class FormAlterarAgendamento extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlterarDadosDo = new JLabel("Alterar Agendamento");
		lblAlterarDadosDo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAlterarDadosDo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarDadosDo.setBounds(0, 0, 434, 51);
		contentPane.add(lblAlterarDadosDo);

		JLabel lblAtributoPesquisa = new JLabel("M\u00E9todo de Pesquisa :");
		lblAtributoPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtributoPesquisa.setBounds(42, 74, 147, 17);
		contentPane.add(lblAtributoPesquisa);
		lblAtributoPesquisa.setVisible(true);

		JComboBox comboBoxBusca = new JComboBox();
		comboBoxBusca.setModel(new DefaultComboBoxModel(new String[] {"...", "Nro. Agendamento", "Nome", "CPF", "Placa Veiculo"}));
		comboBoxBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBoxBusca.getSelectedItem().equals("Nro. Agendamento")) {
					String buscaID = JOptionPane.showInputDialog("Informe o numero do agendamento para pesquisa:");
				} else if (comboBoxBusca.getSelectedItem().equals("Nome")) {
					String buscaNome = JOptionPane.showInputDialog("Informe o nome para pesquisa:");
				} else if (comboBoxBusca.getSelectedItem().equals("CPF")) {
					String buscaCPF = JOptionPane.showInputDialog("Informe o CPF para pesquisa:");
				}else if(comboBoxBusca.getSelectedItem().equals("Placa Veiculo")){
					String buscaPlaca = JOptionPane.showInputDialog("Informe a placa do veiculo para pesquisa:");
				}
			}
		});
		comboBoxBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxBusca.setBounds(183, 73, 135, 20);
		contentPane.add(comboBoxBusca);
		comboBoxBusca.setVisible(true);
		
		JButton btnCancelarAlteraDados = new JButton("Cancelar");
		btnCancelarAlteraDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormAlterarAgendamento.this.setVisible(false);
			}
		});
		btnCancelarAlteraDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarAlteraDados.setBounds(325, 109, 89, 23);
		contentPane.add(btnCancelarAlteraDados);
	}
}
