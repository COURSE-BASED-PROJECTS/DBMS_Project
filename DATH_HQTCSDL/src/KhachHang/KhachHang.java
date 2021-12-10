package KhachHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUD.Them_ChiNhanh;
import DoiTuong.TaiKhoan_HienTai;
import KetNoi.KetNoi;
import TranhChap.DirtyRead.CapNhat_DiaChi_DirtyRead_3;
import TranhChap.DirtyRead.CapNhat_TinhTrang_DirtyRead_2;
import TranhChap.DirtyRead.VanTin_DDH_DirtyRead_2;
import TranhChap.DirtyRead.VanTin_SanPham_DirtyRead_1;
import TranhChap.Unrepeatable.VanTin_SanPham_Unrepeatable_2;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KhachHang extends JFrame {
	
	private JPanel contentPane;
	private JTable table_doitac;
	private JTable table_cungcap;
	private JTable table_sanpham;
	private JTable table_ddh;
	private JTable table_ctddh;
	private VanTin_SanPham_DirtyRead_1 dirty_read_1=null;
	private VanTin_DDH_DirtyRead_2 dirtyRead_2=null;
	private CapNhat_DiaChi_DirtyRead_3 dirtyRead_3=null;
	private VanTin_SanPham_Unrepeatable_2 unrepeatable_2=null;
	
	private String nameColumn_CungCap[]= {"MAST","MACHINHANH","MASP","GIASP"};
	private String nameColumn_SanPham[]= {"MASP","TENSP"};
	private String nameColumn_DonDH[]= {"MADDH","MAKH","MATAIXE","DIACHIGIAOHANG","HINHTHUCTT","PHIVANCHUYEN","PHISP"
		,"TINHTRANG","TONGTIEN"};
	private String nameColumn_ChiTietDDH[]= {"MADDH","MASP","SLSP","DONGIA"};
	private String nameColumn_DoiTac[]= {"MAST","NGUOIDAIDIEN","TENDT","SLCHINHANH","LOAIHANG","DIACHI","SDT",
			"EMAIL"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang();
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
	public KhachHang() {
		
		setTitle("Khách Hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 828, 458);
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
		scrollPane_1.setBounds(10, 10, 769, 244);
		panel_1.add(scrollPane_1);
		
		table_cungcap = new JTable();
		scrollPane_1.setViewportView(table_cungcap);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Sán Phẩm", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 769, 251);
		panel_2.add(scrollPane_2);
		
		table_sanpham = new JTable();
		scrollPane_2.setViewportView(table_sanpham);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Đơn Đặt Hàng", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 10, 769, 244);
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
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(10, 264, 415, 102);
		panel_1.add(panel_1_1);
		
		JButton btnVnTinkhng = new JButton("Dirty read 1");
		btnVnTinkhng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnVnTinkhng_actionPerformed(e);
			}
		});
		btnVnTinkhng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVnTinkhng.setBounds(21, 28, 141, 47);
		panel_1_1.add(btnVnTinkhng);
		loadData("SANPHAM", nameColumn_SanPham, table_sanpham);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1_1.setBounds(10, 264, 415, 102);
		panel_2.add(panel_1_1_1_1);
		
		JButton btnUnrepeat = new JButton("Unrepeatable 2");
		btnUnrepeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUnrepeat_actionPerformed(e);
			}
		});
		btnUnrepeat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUnrepeat.setBounds(21, 28, 141, 47);
		panel_1_1_1_1.add(btnUnrepeat);
		loadData("DONDH", nameColumn_DonDH, table_ddh);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBounds(10, 264, 415, 102);
		panel_3.add(panel_1_1_1);
		
		JButton btnDirtyRead = new JButton("Dirty read 2");
		btnDirtyRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDirtyRead_actionPerformed(e);
			}
		});
		btnDirtyRead.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDirtyRead.setBounds(21, 28, 141, 47);
		panel_1_1_1.add(btnDirtyRead);
		
		JButton btnDirtyRead_2 = new JButton("Dirty read 3");
		btnDirtyRead_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDirtyRead_2_actionPerformed(e);
			}
		});
		btnDirtyRead_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDirtyRead_2.setBounds(205, 28, 141, 47);
		panel_1_1_1.add(btnDirtyRead_2);
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
		KetNoi kn = new KetNoi(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
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

	protected void do_btnVnTinkhng_actionPerformed(ActionEvent e) {
		if(dirty_read_1 == null) {
			dirty_read_1 = new VanTin_SanPham_DirtyRead_1();
			dirty_read_1.setVisible(true);
			dirty_read_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			dirty_read_1.setVisible(true);
		}
	}
	protected void do_btnDirtyRead_actionPerformed(ActionEvent e) {
		if(dirtyRead_2 == null) {
			dirtyRead_2 = new VanTin_DDH_DirtyRead_2();
			dirtyRead_2.setVisible(true);
			dirtyRead_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			dirtyRead_2.setVisible(true);
		}
	}
	protected void do_btnDirtyRead_2_actionPerformed(ActionEvent e) {
		if(dirtyRead_3 == null) {
			dirtyRead_3 = new CapNhat_DiaChi_DirtyRead_3();
			dirtyRead_3.setVisible(true);
			dirtyRead_3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			dirtyRead_3.setVisible(true);
		}
		
	}
	protected void do_btnUnrepeat_actionPerformed(ActionEvent e) {
		
		if(unrepeatable_2 == null) {
			unrepeatable_2 = new VanTin_SanPham_Unrepeatable_2();
			unrepeatable_2.setVisible(true);
			unrepeatable_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			unrepeatable_2.setVisible(true);
		}
	}
}
