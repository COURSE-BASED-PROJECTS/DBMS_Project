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
import DoiTuong.TaiKhoan_HienTai;
import KetNoi.KetNoi;
import TranhChap.LostUpdate.CapNhat_TangGia_LostUpdate_3;
import TranhChap.PhantomRead.Them_ChiNhanh_PhantomRead_3;
import TranhChap.PhantomRead.Them_DoiTac_PhantomRead_2;
import TranhChap.PhantomRead.VanTin_DoiTac_PhantomRead_2;
import TranhChap.Unrepeatable.CapNhat_TenSanPham_Unrepeatable_2;
import TranhChap.Unrepeatable.VanTin_HetHan_Unrepeatable_1;

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
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class DoiTac extends JFrame {
	
	private JPanel contentPane;
	private JTable table_chinhanh;
	private JTable table_cungcap;
	private JTable table_sanpham;
	private JTable table_ddh;
	private JTable table_ctddh;
	private JTable table_hd;
	
	private String nameColumn_ChiNhanh[]= {"MST","NGUOIDAIDIEN","MACHINHANH","DIACHI"};
	private String nameColumn_CungCap[]= {"MST","MACHINHANH","MASP","GIASP"};
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
	private VanTin_HetHan_Unrepeatable_1 unrepeatable_1=null;
	private CapNhat_TenSanPham_Unrepeatable_2 unrepeatable_2=null;
	private Them_DoiTac_PhantomRead_2 phantomRead_2=null;
	private Them_ChiNhanh_PhantomRead_3 phantomRead_3=null;
	private CapNhat_TangGia_LostUpdate_3 lostUpdate_3=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiTac frame = new DoiTac();
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
	public DoiTac() {
		
		setTitle("Đối Tác");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 828, 457);
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
		scrollPane.setBounds(10, 90, 769, 172);
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
		scrollPane_2.setBounds(10, 90, 769, 171);
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
		scrollPane_5.setBounds(10, 10, 769, 244);
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
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Demo Tranh Ch\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1_1.setBounds(10, 264, 415, 102);
		panel.add(panel_1_1_1_1);
		
		JButton btnUnrepeatable_2_1 = new JButton("Phantom Read 3");
		btnUnrepeatable_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUnrepeatable_2_1_actionPerformed(e);
			}
		});
		btnUnrepeatable_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUnrepeatable_2_1.setBounds(21, 28, 141, 47);
		panel_1_1_1_1.add(btnUnrepeatable_2_1);
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
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBounds(10, 264, 415, 102);
		panel_2.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Demo Tranh Ch\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnUnrepeatable_2 = new JButton("Unrepeatable 2");
		btnUnrepeatable_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUnrepeatable_2_actionPerformed(e);
			}
		});
		btnUnrepeatable_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUnrepeatable_2.setBounds(21, 28, 141, 47);
		panel_1_1_1.add(btnUnrepeatable_2);
		
		JButton btnUnrepeatable_2_2 = new JButton("Lost Update 3");
		btnUnrepeatable_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUnrepeatable_2_2_actionPerformed(e);
			}
		});
		btnUnrepeatable_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUnrepeatable_2_2.setBounds(193, 28, 141, 47);
		panel_1_1_1.add(btnUnrepeatable_2_2);
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
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(10, 264, 415, 102);
		panel_5.add(panel_1_1);
		
		JButton btnUnrepeatable = new JButton("Unrepeatable 1");
		btnUnrepeatable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUnrepeatable_actionPerformed(e);
			}
		});
		btnUnrepeatable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUnrepeatable.setBounds(21, 28, 141, 47);
		panel_1_1.add(btnUnrepeatable);
		
		JButton btnPhantomRead = new JButton("Phantom Read 2");
		btnPhantomRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPhantomRead_actionPerformed(e);
			}
		});
		btnPhantomRead.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPhantomRead.setBounds(193, 28, 141, 47);
		panel_1_1.add(btnPhantomRead);
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

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if(themChiNhanh == null) {
			themChiNhanh = new Them_ChiNhanh(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			themChiNhanh.setVisible(true);
			themChiNhanh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			themChiNhanh.setVisible(true);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		if(themCungCap ==null) {
			themCungCap = new Them_CungCap(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			themCungCap.setVisible(true);
			themCungCap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			themCungCap.setVisible(true);
		}
	}
	protected void do_btnNewButton_1_1_actionPerformed(ActionEvent e) {
		if(themSanPham ==null) {
			themSanPham = new Them_SanPham(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			themSanPham.setVisible(true);
			themSanPham.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			themSanPham.setVisible(true);
		}
	}
	protected void do_btnCpNhth_actionPerformed(ActionEvent e) {
		if(capNhatDDH ==null) {
			capNhatDDH = new CapNhat_DDH(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
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
			xoaChiNhanh = new Xoa_ChiNhanh(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			xoaChiNhanh.setVisible(true);
			xoaChiNhanh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			xoaChiNhanh.setVisible(true);
		}
	}
	protected void do_btnSa_actionPerformed(ActionEvent e) {
		if(capnhatChiNhanh ==null) {
			capnhatChiNhanh = new CapNhat_ChiNhanh(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			capnhatChiNhanh.setVisible(true);
			capnhatChiNhanh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capnhatChiNhanh.setVisible(true);
		}
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		if(xoaCungCap ==null) {
			xoaCungCap = new Xoa_CungCap(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			xoaCungCap.setVisible(true);
			xoaCungCap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			xoaCungCap.setVisible(true);
		}
	}
	
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		if(capnhatCungCap ==null) {
			capnhatCungCap = new CapNhat_CungCap(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			capnhatCungCap.setVisible(true);
			capnhatCungCap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capnhatCungCap.setVisible(true);
		}
	}
	protected void do_btnNewButton_2_1_actionPerformed(ActionEvent e) {
		if(xoaSanPham ==null) {
			xoaSanPham = new Xoa_SanPham(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			xoaSanPham.setVisible(true);
			xoaSanPham.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			xoaSanPham.setVisible(true);
		}
	}
	
	protected void do_btnNewButton_3_1_actionPerformed(ActionEvent e) {
		if(capnhatSanPham ==null) {
			capnhatSanPham = new CapNhat_SanPham(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
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
	protected void do_btnUnrepeatable_actionPerformed(ActionEvent e) {
		if(unrepeatable_1 ==null) {
			unrepeatable_1 = new VanTin_HetHan_Unrepeatable_1();
			unrepeatable_1.setVisible(true);
			unrepeatable_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			unrepeatable_1.setVisible(true);
		}
	}
	protected void do_btnUnrepeatable_2_actionPerformed(ActionEvent e) {
		if(unrepeatable_2 ==null) {
			unrepeatable_2 = new CapNhat_TenSanPham_Unrepeatable_2();
			unrepeatable_2.setVisible(true);
			unrepeatable_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			unrepeatable_2.setVisible(true);
		}
	}
	protected void do_btnPhantomRead_actionPerformed(ActionEvent e) {
		if(phantomRead_2 ==null) {
			phantomRead_2 = new Them_DoiTac_PhantomRead_2();
			phantomRead_2.setVisible(true);
			phantomRead_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			phantomRead_2.setVisible(true);
		}
	}
	protected void do_btnUnrepeatable_2_1_actionPerformed(ActionEvent e) {
		if(phantomRead_3 ==null) {
			phantomRead_3 = new Them_ChiNhanh_PhantomRead_3();
			phantomRead_3.setVisible(true);
			phantomRead_3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			phantomRead_3.setVisible(true);
		}
	}
	protected void do_btnUnrepeatable_2_2_actionPerformed(ActionEvent e) {
		if(lostUpdate_3 ==null) {
			lostUpdate_3 = new CapNhat_TangGia_LostUpdate_3();
			lostUpdate_3.setVisible(true);
			lostUpdate_3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			lostUpdate_3.setVisible(true);
		}
	}
}
