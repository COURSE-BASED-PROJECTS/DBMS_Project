package KhachHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import KetNoi.KetNoi;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class KhachHang extends JFrame {
	
	private JPanel contentPane;
	private JTable table_doitac;
	private JTable table_cungcap;
	private JTable table_sanpham;
	private JTable table_ddh;
	private JTable table_ctddh;
	
	private String nameColumn_CungCap[]= {"MAST","NGUOIDAIDIEN","MACHINHANH","MASP","DIACHI","GIASP"};
	private String nameColumn_SanPham[]= {"MASP","TENSP"};
	private String nameColumn_DonDH[]= {"MADDH","MAKH","MATAIXE","DIACHIGIAOHANG","HINHTHUCTT","PHIVANCHUYEN","PHISP"
		,"TINHTRANG","TONGTIEN"};
	private String nameColumn_ChiTietDDH[]= {"MADDH","MASP","SLSP","DONGIA"};
	private String nameColumn_DoiTac[]= {"MAST","NGUOIDAIDIEN","TENDT","LOAIHANG","DIACHI","SDT",
			"EMAIL"};
	
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang(taikhoan,matkhau);
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
	public KhachHang(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Khách Hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 828, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 794, 403);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setName("");
		tabbedPane.addTab("Đối Tác", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 769, 356);
		panel.add(scrollPane);
		
		table_doitac = new JTable();
		scrollPane.setViewportView(table_doitac);
		
		JPanel panel_1 = new JPanel();
		panel_1.setName("");
		tabbedPane.addTab("Cung Cấp", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 769, 356);
		panel_1.add(scrollPane_1);
		
		table_cungcap = new JTable();
		scrollPane_1.setViewportView(table_cungcap);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Sán Phẩm", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 769, 356);
		panel_2.add(scrollPane_2);
		
		table_sanpham = new JTable();
		scrollPane_2.setViewportView(table_sanpham);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Đơn Đặt Hàng", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 10, 769, 356);
		panel_3.add(scrollPane_3);
		
		table_ddh = new JTable();
		scrollPane_3.setViewportView(table_ddh);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Chi tiết đơn đặt hàng", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 10, 769, 356);
		panel_4.add(scrollPane_4);
		
		table_ctddh = new JTable();
		scrollPane_4.setViewportView(table_ctddh);
		
		loadData("DOITAC", nameColumn_DoiTac, table_doitac);
		loadData("CUNGCAP", nameColumn_CungCap, table_cungcap);
		loadData("SANPHAM", nameColumn_SanPham, table_sanpham);
		loadData("DONDH", nameColumn_DonDH, table_ddh);
		loadData("CHITIETDDH", nameColumn_ChiTietDDH, table_ctddh);
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
		KetNoi kn = new KetNoi(taikhoan, matkhau);
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

}
