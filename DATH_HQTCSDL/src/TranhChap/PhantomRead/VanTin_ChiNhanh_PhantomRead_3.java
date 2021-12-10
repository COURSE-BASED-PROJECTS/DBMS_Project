package TranhChap.PhantomRead;

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

public class VanTin_ChiNhanh_PhantomRead_3 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String nameColumn_ChiNhanh[]= {"MST","NGUOIDAIDIEN","MACHINHANH","DIACHI"};
	private JTextPane soluongText;
	private JTextPane mstText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VanTin_ChiNhanh_PhantomRead_3 frame = new VanTin_ChiNhanh_PhantomRead_3();
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
	public VanTin_ChiNhanh_PhantomRead_3() {
		setTitle("Xem chi nhánh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 391, 251);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Vấn tin (không fix)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(40, 174, 141, 47);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Vấn tin (có fix)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(206, 174, 140, 47);
		panel_1.add(btnNewButton_1);
		
		JLabel lblMaDdh = new JLabel("Số lượng chi nhánh");
		lblMaDdh.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaDdh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaDdh.setBounds(40, 38, 116, 34);
		panel_1.add(lblMaDdh);
		
		soluongText = new JTextPane();
		soluongText.setFont(new Font("Tahoma", Font.BOLD, 15));
		soluongText.setBounds(164, 38, 92, 34);
		soluongText.setEditable(false);
		panel_1.add(soluongText);
		
		JLabel lblMst = new JLabel("MST");
		lblMst.setHorizontalAlignment(SwingConstants.CENTER);
		lblMst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMst.setBounds(83, 110, 116, 34);
		panel_1.add(lblMst);
		
		mstText = new JTextPane();
		mstText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mstText.setBounds(164, 110, 92, 34);
		panel_1.add(mstText);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi nh\u00E1nh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(411, 10, 711, 339);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 691, 309);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel,nameColumn_ChiNhanh);
		table.setModel(defaultTableModel);
	}
	
	private void initialRow(DefaultTableModel defaultTableModel, String nameColumn[]) {
		for (String name : nameColumn) {
			defaultTableModel.addColumn(name);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel, nameColumn_ChiNhanh);
		soluongText.setText(PhantomRead_3.soluong_cn(mstText.getText()));
		table.setModel(PhantomRead_3.vantin_chinhanh(defaultTableModel,mstText.getText(), false));
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel, nameColumn_ChiNhanh);
		soluongText.setText(PhantomRead_3.soluong_cn(mstText.getText()));
		table.setModel(PhantomRead_3.vantin_chinhanh(defaultTableModel,mstText.getText(), true));
	}
}
