package senac.agendamento.assets.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class FormSobre extends JFrame {

	private JPanel paneSobre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormSobre frame = new FormSobre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Create frame.
	 */
	public FormSobre() {
		setBounds(100, 100, 259, 173);
		paneSobre = new JPanel();
		paneSobre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(paneSobre);
		paneSobre.setLayout(null);
		
		JLabel lblEjzConsultoriaDe = new JLabel("EJZ Software & Consultoria Ltda.");
		lblEjzConsultoriaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEjzConsultoriaDe.setBounds(0, 11, 243, 22);
		paneSobre.add(lblEjzConsultoriaDe);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FormSobre.class.getResource("/Imagens/logoEJZ_103x68.png")));
		lblLogo.setBounds(69, 51, 103, 68);
		paneSobre.add(lblLogo);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o 1.0");
		lblVerso.setBounds(93, 28, 71, 14);
		paneSobre.add(lblVerso);
	}

}
