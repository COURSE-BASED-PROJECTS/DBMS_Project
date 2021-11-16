package TaiXe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUD.CapNhat_DDH;
import KetNoi.KetNoi;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TaiXe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CapNhat_DDH capnhatDDH =null;
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaiXe frame = new TaiXe(taikhoan,matkhau);
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
	public TaiXe(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Tai Xe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 773, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTaiX = new JLabel("Ta\u0300i X\u00EA\u0301");
		lblTaiX.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiX.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTaiX.setBounds(265, 10, 204, 61);
		contentPane.add(lblTaiX);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 739, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCpNhtTinh = new JButton("Cập nhật Tình Trạng Đơn Hàng");
		btnCpNhtTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNhtTinh_actionPerformed(e);
			}
		});
		btnCpNhtTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNhtTinh.setBounds(10, 74, 231, 49);
		contentPane.add(btnCpNhtTinh);
		
		JButton btnTaiLai = new JButton("Tải lại");
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTaiLai_actionPerformed(e);
			}
		});
		btnTaiLai.setBackground(Color.GREEN);
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTaiLai.setBounds(654, 74, 95, 49);
		contentPane.add(btnTaiLai);
		
		loadData();
	}
	
	private void initialRow(DefaultTableModel defaultTableModel) {
		defaultTableModel.addColumn("MADDH");
		defaultTableModel.addColumn("MAKH");
		defaultTableModel.addColumn("MATAIXE");
		defaultTableModel.addColumn("DIACHIGIAOHANG");
		defaultTableModel.addColumn("HINHTHUCTT");
		defaultTableModel.addColumn("PHIVANCHUYEN");
		defaultTableModel.addColumn("PHISP");
		defaultTableModel.addColumn("TINHTRANG");
		defaultTableModel.addColumn("TONGTIEN");
	}
	
	private void loadData() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel);
		
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		ResultSet rs = kn.getResultSet("select * from DONDH");
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

	protected void do_btnCpNhtTinh_actionPerformed(ActionEvent e) {
		if(capnhatDDH ==null) {
			capnhatDDH = new CapNhat_DDH(taikhoan,matkhau);
			capnhatDDH.setVisible(true);
			capnhatDDH.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capnhatDDH.setVisible(true);
		}
	}
	protected void do_btnTaiLai_actionPerformed(ActionEvent e) {
		loadData();
	}
}
