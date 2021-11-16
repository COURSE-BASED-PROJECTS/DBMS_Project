package DangKy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class DangKy extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy frame = new DangKy();
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
	public DangKy() {
		setTitle("Dang Ky");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setBounds(100, 100, 478, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng Ky\u0301");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(120, 6, 184, 60);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPane.setBounds(189, 97, 166, 41);
		contentPane.add(textPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Qua\u0309n Tri\u0323", "Nh\u00E2n Vi\u00EAn", "Kha\u0301ch Ha\u0300ng", "Ta\u0300i X\u00EA\u0301", "\u0110\u00F4\u0301i Ta\u0301c"}));
		comboBox.setBounds(189, 265, 166, 41);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn Ta\u0300i Khoa\u0309n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 97, 106, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u00E2\u0323t Kh\u00E2\u0309u");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(29, 177, 84, 41);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ph\u00E2n H\u00EA\u0323 Ng\u01B0\u01A1\u0300i Du\u0300ng");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(29, 265, 148, 41);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng ky\u0301");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(146, 355, 158, 49);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(43, 341, 376, 2);
		contentPane.add(separator);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(189, 177, 166, 41);
		contentPane.add(passwordField);
	}
}
