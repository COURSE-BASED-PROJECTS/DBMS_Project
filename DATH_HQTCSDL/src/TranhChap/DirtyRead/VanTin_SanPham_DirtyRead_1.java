package TranhChap.DirtyRead;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DoiTuong.TaiKhoan_HienTai;
import KetNoi.KetNoi;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VanTin_SanPham_DirtyRead_1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String nameColumn_CungCap[]= {"MAST","MACHINHANH","MASP","GIASP"};
	private JTextPane mspText;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VanTin_SanPham_DirtyRead_1 frame = new VanTin_SanPham_DirtyRead_1();
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
	public VanTin_SanPham_DirtyRead_1() {
		setTitle("Xem sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 391, 187);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Vấn tin (không fix)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(35, 105, 141, 47);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Vấn tin (có fix)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(208, 105, 140, 47);
		panel_1.add(btnNewButton_1);
		
		JLabel lblMsp = new JLabel("MSP");
		lblMsp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMsp.setBounds(20, 30, 71, 34);
		panel_1.add(lblMsp);
		
		mspText = new JTextPane();
		mspText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mspText.setBounds(84, 30, 92, 34);
		panel_1.add(mspText);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(411, 10, 711, 339);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 691, 309);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
//		loadData("CUNGCAP", nameColumn_CungCap, table);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel,nameColumn_CungCap);
		table.setModel(defaultTableModel);
	}
	
	private void initialRow(DefaultTableModel defaultTableModel, String nameColumn[]) {
		for (String name : nameColumn) {
			defaultTableModel.addColumn(name);
		}
	}
	
	private void loadData(String nameTable,String nameColumn[], JTable table) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel,nameColumn);
		
		String query = "select * from " + nameTable;
		KetNoi kn = new KetNoi();
		ResultSet rs = kn.getResultSet(query);
		int numberColumn = kn.getNumberColumn();
		defaultTableModel.setRowCount(0);
		
		try {
			Vector<String> row = null;
			while(rs.next()) {
				row = new Vector<String>();
				
				for(int i=1;i<=numberColumn;i++)
					row.addElement(rs.getString(i));
				defaultTableModel.addRow(row);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table.setModel(defaultTableModel);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel, nameColumn_CungCap);
		table.setModel(DirtyRead_1.vantin_cungcap_khongfix(defaultTableModel, mspText.getText(), false));
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel, nameColumn_CungCap);
		table.setModel(DirtyRead_1.vantin_cungcap_khongfix(defaultTableModel, mspText.getText(), true));
	}
}
