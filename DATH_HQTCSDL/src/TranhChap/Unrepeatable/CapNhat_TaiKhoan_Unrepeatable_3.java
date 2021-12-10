package TranhChap.Unrepeatable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DoiTuong.DoiTuong_CungCap;
import KetNoi.KetNoi;
import TranhChap.LostUpdate.LostUpdate_2;

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

public class CapNhat_TaiKhoan_Unrepeatable_3 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextPane taikhoanText;
	private JTextPane matkhauText;
	private String nameColumn_TaiKhoan[]= {"TAIKHOAN","MATKHAU","PHANHE","DAKICHHOAT"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhat_TaiKhoan_Unrepeatable_3 frame = new CapNhat_TaiKhoan_Unrepeatable_3();
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
	public CapNhat_TaiKhoan_Unrepeatable_3() {
		setTitle("Cập nhật tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin c\u1EADp nh\u1EADt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 391, 96);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tai Khoan");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 25, 71, 34);
		panel.add(lblNewLabel);
		
		JLabel lblMcn = new JLabel("MK mới");
		lblMcn.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMcn.setBounds(183, 25, 71, 34);
		panel.add(lblMcn);
		
		taikhoanText = new JTextPane();
		taikhoanText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		taikhoanText.setBounds(73, 25, 92, 34);
		panel.add(taikhoanText);
		
		matkhauText = new JTextPane();
		matkhauText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		matkhauText.setBounds(252, 25, 92, 34);
		panel.add(matkhauText);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 114, 391, 128);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Cập nhật (không fix)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 27, 154, 47);
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
		btnNewButton_2.setBounds(163, 84, 78, 34);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ng\u01B0\u1EDDi d\u00F9ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(411, 10, 711, 339);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 691, 309);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadData("NGUOIDUNG", nameColumn_TaiKhoan, table);
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
		loadData("NGUOIDUNG", nameColumn_TaiKhoan, table);
	}
	
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if(Unrepeatable_3.capnhat_taikhoan(taikhoanText.getText(),matkhauText.getText(),false)) {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 0);
			loadData("NGUOIDUNG", nameColumn_TaiKhoan, table);
		}
		else {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật không thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 3);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		if(Unrepeatable_3.capnhat_taikhoan(taikhoanText.getText(),matkhauText.getText(),true)) {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 0);
			loadData("NGUOIDUNG", nameColumn_TaiKhoan, table);
		}
		else {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật không thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 3);
		}
	}
}
