package TranhChap.DirtyRead;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DoiTuong.DoiTuong_CungCap;
import KetNoi.KetNoi;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class CapNhat_TinhTrang_DirtyRead_2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextPane maddhText;
	private JTextPane tinhtrangText;
	private String nameColumn_DonDH[]= {"MADDH","MAKH","MATAIXE","DIACHIGIAOHANG","HINHTHUCTT","PHIVANCHUYEN","PHISP"
			,"TINHTRANG","TONGTIEN"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhat_TinhTrang_DirtyRead_2 frame = new CapNhat_TinhTrang_DirtyRead_2();
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
	public CapNhat_TinhTrang_DirtyRead_2() {
		setTitle("Cập nhật đơn đặt hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin c\u1EADp nh\u1EADt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 391, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ma DDH");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 25, 71, 34);
		panel.add(lblNewLabel);
		
		JLabel lblMcn = new JLabel("Tình trạng");
		lblMcn.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMcn.setBounds(180, 25, 71, 34);
		panel.add(lblMcn);
		
		maddhText = new JTextPane();
		maddhText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		maddhText.setBounds(63, 25, 92, 34);
		panel.add(maddhText);
		
		tinhtrangText = new JTextPane();
		tinhtrangText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tinhtrangText.setBounds(252, 25, 112, 34);
		panel.add(tinhtrangText);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 119, 391, 128);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Cập nhật (không fix)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 27, 141, 47);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cập nhật (có fix)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(241, 27, 140, 47);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tải lại");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(148, 84, 93, 34);
		panel_1.add(btnNewButton_2);
		
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
		loadData("DONDH", nameColumn_DonDH, table);
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
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		loadData("DONDH", nameColumn_DonDH, table);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if(DirtyRead_2.capnhat_tinhtrang(maddhText.getText(),tinhtrangText.getText()))
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 0);
		else {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật không thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 3);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		if(DirtyRead_2.capnhat_tinhtrang(maddhText.getText(),tinhtrangText.getText()))
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 0);
		else {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật không thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 3);
		}
	}
}


