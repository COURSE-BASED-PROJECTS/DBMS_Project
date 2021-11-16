package DoiTac;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUD.CapNhat_ChiNhanh;
import CRUD.CapNhat_CungCap;
import CRUD.CapNhat_DDH;
import CRUD.CapNhat_SanPham;
import CRUD.Them_ChiNhanh;
import CRUD.Them_CungCap;
import CRUD.Them_SanPham;
import CRUD.Xoa_ChiNhanh;
import CRUD.Xoa_CungCap;
import CRUD.Xoa_SanPham;
import KetNoi.KetNoi;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DoiTac extends JFrame {
	
	private JPanel contentPane;
	private JTable table_chinhanh;
	private JTable table_cungcap;
	private JTable table_sanpham;
	private JTable table_ddh;
	private JTable table_ctddh;
	private JTable table_hd;
	
	private String nameColumn_ChiNhanh[]= {"MST","NGUOIDAIDIEN","MACHINHANH","DIACHI"};
	private String nameColumn_CungCap[]= {"MST","NGUOIDAIDIEN","MACHINHANH","MASP","GIASP"};
	private String nameColumn_SanPham[]= {"MASP","TENSP"};
	private String nameColumn_DonDH[]= {"MADDH","MAKH","MATAIXE","DIACHIGIAOHANG","HINHTHUCTT","PHIVANCHUYEN","PHISP"
		,"TINHTRANG","TONGTIEN"};
	private String nameColumn_ChiTietDDH[]= {"MADDH","MASP","SLSP","DONGIA"};
	private String nameColumn_HopDong[]= {"MST","NGUOIDAIDIEN","MAHD","THGIANBATDAU","THGIANHIEULUC","PHIHOAHONG",
			"SOCHINHANHDK","KICHHOAT"};
	
	private Them_ChiNhanh themChiNhanh=null;
	private Them_CungCap themCungCap=null;
	private Them_SanPham themSanPham=null;
	
	private Xoa_ChiNhanh xoaChiNhanh=null;
	private Xoa_CungCap xoaCungCap=null;
	private Xoa_SanPham xoaSanPham=null;
	
	private CapNhat_DDH capNhatDDH =null;
	private CapNhat_ChiNhanh capnhatChiNhanh=null;
	private CapNhat_CungCap capnhatCungCap=null;
	private CapNhat_SanPham capnhatSanPham=null;
	
	private static String taikhoan="";
	private static String matkhau="";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiTac frame = new DoiTac(taikhoan,matkhau);
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
	public DoiTac(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Đối Tác");
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
		tabbedPane.addTab("Chi Nhánh", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 769, 276);
		panel.add(scrollPane);
		
		table_chinhanh = new JTable();
		scrollPane.setViewportView(table_chinhanh);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(10, 33, 115, 35);
		panel.add(btnNewButton);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXoa_actionPerformed(e);
			}
		});
		btnXoa.setBounds(153, 33, 115, 35);
		panel.add(btnXoa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSa_actionPerformed(e);
			}
		});
		btnSa.setBounds(297, 33, 115, 35);
		panel.add(btnSa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setName("");
		tabbedPane.addTab("Cung Cấp", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 90, 769, 276);
		panel_1.add(scrollPane_1);
		
		table_cungcap = new JTable();
		scrollPane_1.setViewportView(table_cungcap);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(10, 33, 115, 35);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setBounds(153, 33, 115, 35);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_3_actionPerformed(e);
			}
		});
		btnNewButton_3.setBounds(297, 33, 115, 35);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Sán Phẩm", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 90, 769, 276);
		panel_2.add(scrollPane_2);
		
		table_sanpham = new JTable();
		scrollPane_2.setViewportView(table_sanpham);
		
		JButton btnNewButton_1_1 = new JButton("Thêm");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_1_actionPerformed(e);
			}
		});
		btnNewButton_1_1.setBounds(10, 33, 115, 35);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Xóa");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_1_actionPerformed(e);
			}
		});
		btnNewButton_2_1.setBounds(153, 33, 115, 35);
		panel_2.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Sửa");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_3_1_actionPerformed(e);
			}
		});
		btnNewButton_3_1.setBounds(297, 33, 115, 35);
		panel_2.add(btnNewButton_3_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Đơn Đặt Hàng", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 99, 769, 267);
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
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Hợp Đồng", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 10, 769, 356);
		panel_5.add(scrollPane_5);
		
		table_hd = new JTable();
		scrollPane_5.setViewportView(table_hd);
		
		loadData("CHINHANH", nameColumn_ChiNhanh, table_chinhanh);
		
		JButton btnTaiLai = new JButton("Tải lại");
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTaiLai_actionPerformed(e);
			}
		});
		btnTaiLai.setBackground(Color.GREEN);
		btnTaiLai.setBounds(664, 33, 115, 35);
		panel.add(btnTaiLai);
		loadData("CUNGCAP", nameColumn_CungCap, table_cungcap);
		
		JButton btnTaiLai_1 = new JButton("Tải lại");
		btnTaiLai_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTaiLai_1_actionPerformed(e);
			}
		});
		btnTaiLai_1.setBackground(Color.GREEN);
		btnTaiLai_1.setBounds(664, 33, 115, 35);
		panel_1.add(btnTaiLai_1);
		loadData("SANPHAM", nameColumn_SanPham, table_sanpham);
		
		JButton btnTaiLai_2 = new JButton("Tải lại");
		btnTaiLai_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTaiLai_2_actionPerformed(e);
			}
		});
		btnTaiLai_2.setBackground(Color.GREEN);
		btnTaiLai_2.setBounds(664, 33, 115, 35);
		panel_2.add(btnTaiLai_2);
		loadData("DONDH", nameColumn_DonDH, table_ddh);
		
		JButton btnCpNhth = new JButton("Cập nhật ĐĐH");
		btnCpNhth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNhth_actionPerformed(e);
			}
		});
		btnCpNhth.setBounds(10, 40, 115, 35);
		panel_3.add(btnCpNhth);
		
		JButton btnTaiLai_3 = new JButton("Tải lại");
		btnTaiLai_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTaiLai_3_actionPerformed(e);
			}
		});
		btnTaiLai_3.setBackground(Color.GREEN);
		btnTaiLai_3.setBounds(664, 40, 115, 35);
		panel_3.add(btnTaiLai_3);
		loadData("CHITIETDDH", nameColumn_ChiTietDDH, table_ctddh);
		loadData("HOPDONG", nameColumn_HopDong, table_hd);
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

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if(themChiNhanh == null) {
			themChiNhanh = new Them_ChiNhanh(this.taikhoan,this.matkhau);
			themChiNhanh.setVisible(true);
			themChiNhanh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			themChiNhanh.setVisible(true);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		if(themCungCap ==null) {
			themCungCap = new Them_CungCap(taikhoan,matkhau);
			themCungCap.setVisible(true);
			themCungCap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			themCungCap.setVisible(true);
		}
	}
	protected void do_btnNewButton_1_1_actionPerformed(ActionEvent e) {
		if(themSanPham ==null) {
			themSanPham = new Them_SanPham(taikhoan,matkhau);
			themSanPham.setVisible(true);
			themSanPham.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			themSanPham.setVisible(true);
		}
	}
	protected void do_btnCpNhth_actionPerformed(ActionEvent e) {
		if(capNhatDDH ==null) {
			capNhatDDH = new CapNhat_DDH(taikhoan,matkhau);
			capNhatDDH.setVisible(true);
			capNhatDDH.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capNhatDDH.setVisible(true);
		}
	}
	protected void do_btnTaiLai_actionPerformed(ActionEvent e) {
		loadData("CHINHANH", nameColumn_ChiNhanh, table_chinhanh);
	}
	protected void do_btnXoa_actionPerformed(ActionEvent e) {
		if(xoaChiNhanh ==null) {
			xoaChiNhanh = new Xoa_ChiNhanh(taikhoan,matkhau);
			xoaChiNhanh.setVisible(true);
			xoaChiNhanh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			xoaChiNhanh.setVisible(true);
		}
	}
	protected void do_btnSa_actionPerformed(ActionEvent e) {
		if(capnhatChiNhanh ==null) {
			capnhatChiNhanh = new CapNhat_ChiNhanh(taikhoan,matkhau);
			capnhatChiNhanh.setVisible(true);
			capnhatChiNhanh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capnhatChiNhanh.setVisible(true);
		}
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		if(xoaCungCap ==null) {
			xoaCungCap = new Xoa_CungCap(taikhoan,matkhau);
			xoaCungCap.setVisible(true);
			xoaCungCap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			xoaCungCap.setVisible(true);
		}
	}
	
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		if(capnhatCungCap ==null) {
			capnhatCungCap = new CapNhat_CungCap(taikhoan,matkhau);
			capnhatCungCap.setVisible(true);
			capnhatCungCap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capnhatCungCap.setVisible(true);
		}
	}
	protected void do_btnNewButton_2_1_actionPerformed(ActionEvent e) {
		if(xoaSanPham ==null) {
			xoaSanPham = new Xoa_SanPham(taikhoan,matkhau);
			xoaSanPham.setVisible(true);
			xoaSanPham.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			xoaSanPham.setVisible(true);
		}
	}
	
	protected void do_btnNewButton_3_1_actionPerformed(ActionEvent e) {
		if(capnhatSanPham ==null) {
			capnhatSanPham = new CapNhat_SanPham(taikhoan,matkhau);
			capnhatSanPham.setVisible(true);
			capnhatSanPham.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capnhatSanPham.setVisible(true);
		}
	}
	protected void do_btnTaiLai_1_actionPerformed(ActionEvent e) {
		loadData("CUNGCAP", nameColumn_CungCap, table_cungcap);
	}
	protected void do_btnTaiLai_2_actionPerformed(ActionEvent e) {
		loadData("SANPHAM", nameColumn_SanPham, table_sanpham);
	}
	protected void do_btnTaiLai_3_actionPerformed(ActionEvent e) {
		loadData("DONDH", nameColumn_DonDH, table_ddh);
	}
}
