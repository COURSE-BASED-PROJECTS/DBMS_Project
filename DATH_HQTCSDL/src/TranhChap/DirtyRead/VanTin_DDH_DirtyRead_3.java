package TranhChap.DirtyRead;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VanTin_DDH_DirtyRead_3 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String nameColumn_DonDH[]= {"MADDH","MAKH","MATAIXE","DIACHIGIAOHANG","HINHTHUCTT","PHIVANCHUYEN","PHISP"
			,"TINHTRANG","TONGTIEN"};
	private JTextPane maddhText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VanTin_DDH_DirtyRead_3 frame = new VanTin_DDH_DirtyRead_3();
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
	public VanTin_DDH_DirtyRead_3() {
		setTitle("Xem đơn đặt hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 391, 198);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Vấn tin (không fix)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(39, 109, 141, 47);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Vấn tin (có fix)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(203, 109, 140, 47);
		panel_1.add(btnNewButton_1);
		
		JLabel lblMaDdh = new JLabel("Ma DDH");
		lblMaDdh.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaDdh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaDdh.setBounds(28, 38, 71, 34);
		panel_1.add(lblMaDdh);
		
		maddhText = new JTextPane();
		maddhText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		maddhText.setBounds(98, 38, 92, 34);
		panel_1.add(maddhText);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0110\u01A1n \u0111\u1EB7t h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(411, 10, 711, 339);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 691, 309);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel,nameColumn_DonDH);
		table.setModel(defaultTableModel);
	}
	
	private void initialRow(DefaultTableModel defaultTableModel, String nameColumn[]) {
		for (String name : nameColumn) {
			defaultTableModel.addColumn(name);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel, nameColumn_DonDH);
		table.setModel(DirtyRead_3.vantin_diachi(defaultTableModel, maddhText.getText(), false));
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel, nameColumn_DonDH);
		table.setModel(DirtyRead_3.vantin_diachi(defaultTableModel, maddhText.getText(), true));
	}
}
