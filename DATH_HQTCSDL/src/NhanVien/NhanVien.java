package NhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUD.CapNhat_HopDong;
import CRUD.CapNhat_SanPham;
import DoiTuong.TaiKhoan_HienTai;
import KetNoi.KetNoi;
import TranhChap.DirtyRead.CapNhat_SanPham_DirtyRead_1;
import TranhChap.DirtyRead.VanTin_SanPham_DirtyRead_1;
import TranhChap.LostUpdate.CapNhat_KhuyenMai_LostUpdate_2;
import TranhChap.LostUpdate.CapNhat_NguoiDaiDien_LostUpdate_2;
import TranhChap.LostUpdate.CapNhat_PhiHoaHong_LostUpdate_1;
import TranhChap.PhantomRead.Them_SanPham_PhantomRead_1;
import TranhChap.PhantomRead.VanTin_ChiNhanh_PhantomRead_3;
import TranhChap.PhantomRead.VanTin_DoiTac_PhantomRead_2;
import TranhChap.PhantomRead.VanTin_SanPham_PhantomRead_1;
import TranhChap.Unrepeatable.CapNhat_HetHan_Unrepeatable_1;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class NhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CapNhat_HopDong capnhatHopDong =null;
	private CapNhat_SanPham_DirtyRead_1 dirty_read_1=null;
	private CapNhat_PhiHoaHong_LostUpdate_1 lostUpdate_1=null;
	private CapNhat_NguoiDaiDien_LostUpdate_2 lostUpdate_2=null;
	private CapNhat_KhuyenMai_LostUpdate_2 lostUpdate_3=null;
	private CapNhat_HetHan_Unrepeatable_1 unrepeatable_1=null;
	private Them_SanPham_PhantomRead_1 phantomRead_11=null;
	private VanTin_SanPham_PhantomRead_1 phantomRead_12=null;
	private VanTin_DoiTac_PhantomRead_2 phantomRead_2=null;
	private VanTin_ChiNhanh_PhantomRead_3 phantomRead_3=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
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
	public NhanVien() {
		
		setTitle("Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 828, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhnVin = new JLabel("Nh\u00E2n Vi\u00EAn");
		lblNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNhnVin.setBounds(288, 10, 204, 61);
		contentPane.add(lblNhnVin);
		
		JButton btnThmHpng = new JButton(" Cập nhật Hợp Đồng");
		btnThmHpng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnThmHpng_actionPerformed(e);
			}
		});
		btnThmHpng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThmHpng.setBounds(10, 81, 171, 49);
		contentPane.add(btnThmHpng);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 794, 247);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTaiLai = new JButton("Tải lại");
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTaiLai.setBackground(Color.GREEN);
		btnTaiLai.setBounds(709, 81, 95, 49);
		contentPane.add(btnTaiLai);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Demo Tranh Ch\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 410, 794, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCpNhtSn = new JButton("Dirty read 1");
		btnCpNhtSn.setBounds(10, 21, 171, 49);
		panel.add(btnCpNhtSn);
		btnCpNhtSn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNhtSn_actionPerformed(e);
			}
		});
		btnCpNhtSn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnLostUpdate = new JButton("Lost update 1");
		btnLostUpdate.setBounds(212, 21, 171, 49);
		panel.add(btnLostUpdate);
		btnLostUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLostUpdate_actionPerformed(e);
			}
		});
		btnLostUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnLostUpdate_2 = new JButton("Lost update 2");
		btnLostUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLostUpdate_2_actionPerformed(e);
			}
		});
		btnLostUpdate_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLostUpdate_2.setBounds(409, 21, 171, 49);
		panel.add(btnLostUpdate_2);
		
		JButton btnLostUpdate_2_1 = new JButton("Lost update 3");
		btnLostUpdate_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLostUpdate_2_1_actionPerformed(e);
			}
		});
		btnLostUpdate_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLostUpdate_2_1.setBounds(613, 21, 171, 49);
		panel.add(btnLostUpdate_2_1);
		
		JButton btnU = new JButton("Unrepeatable 1");
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnU_actionPerformed(e);
			}
		});
		btnU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnU.setBounds(10, 80, 171, 49);
		panel.add(btnU);
		
		JButton btnPhantom = new JButton("Phantom Read 1.1");
		btnPhantom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPhantom_actionPerformed(e);
			}
		});
		btnPhantom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPhantom.setBounds(212, 80, 171, 49);
		panel.add(btnPhantom);
		
		JButton btnU_1_1 = new JButton("Phantom Read 1.2");
		btnU_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnU_1_1_actionPerformed(e);
			}
		});
		btnU_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnU_1_1.setBounds(409, 80, 171, 49);
		panel.add(btnU_1_1);
		
		JButton btnU_1_1_1 = new JButton("Phantom Read 2");
		btnU_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnU_1_1_1_actionPerformed(e);
			}
		});
		btnU_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnU_1_1_1.setBounds(613, 80, 171, 49);
		panel.add(btnU_1_1_1);
		
		JButton btnPhantomRead = new JButton("Phantom Read 3");
		btnPhantomRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPhantomRead_actionPerformed(e);
			}
		});
		btnPhantomRead.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPhantomRead.setBounds(10, 145, 171, 49);
		panel.add(btnPhantomRead);
		loadData();
	}
	
	private void initialRow(DefaultTableModel defaultTableModel) {
		defaultTableModel.addColumn("MST");
		defaultTableModel.addColumn("NGUOIDAIDIEN");
		defaultTableModel.addColumn("MAHD");
		defaultTableModel.addColumn("THGIANBATDAU");
		defaultTableModel.addColumn("THGIANHIEULUC");
		defaultTableModel.addColumn("PHIHOAHONG");
		defaultTableModel.addColumn("SOCHINHANHDK");
		defaultTableModel.addColumn("KICHHOAT");
	}
	
	private void loadData() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel);
		
		KetNoi kn = new KetNoi(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
		ResultSet rs = kn.getResultSet("select * from HOPDONG");
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
	protected void do_btnThmHpng_actionPerformed(ActionEvent e) {
		if(capnhatHopDong ==null) {
			capnhatHopDong = new CapNhat_HopDong(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			capnhatHopDong.setVisible(true);
			capnhatHopDong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capnhatHopDong.setVisible(true);
		}
	}
	protected void do_btnCpNhtSn_actionPerformed(ActionEvent e) {
		if(dirty_read_1 == null) {
			dirty_read_1 = new CapNhat_SanPham_DirtyRead_1();
			dirty_read_1.setVisible(true);
			dirty_read_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			dirty_read_1.setVisible(true);
		}
	}
	protected void do_btnLostUpdate_actionPerformed(ActionEvent e) {
		if(lostUpdate_1 == null) {
			lostUpdate_1 = new CapNhat_PhiHoaHong_LostUpdate_1();
			lostUpdate_1.setVisible(true);
			lostUpdate_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			lostUpdate_1.setVisible(true);
		}
	}
	protected void do_btnLostUpdate_2_actionPerformed(ActionEvent e) {
		if(lostUpdate_2 == null) {
			lostUpdate_2 = new CapNhat_NguoiDaiDien_LostUpdate_2();
			lostUpdate_2.setVisible(true);
			lostUpdate_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			lostUpdate_2.setVisible(true);
		}
	}
	protected void do_btnLostUpdate_2_1_actionPerformed(ActionEvent e) {
		if(lostUpdate_3 == null) {
			lostUpdate_3 = new CapNhat_KhuyenMai_LostUpdate_2();
			lostUpdate_3.setVisible(true);
			lostUpdate_3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			lostUpdate_3.setVisible(true);
		}
	}
	protected void do_btnU_actionPerformed(ActionEvent e) {
		if(unrepeatable_1 == null) {
			unrepeatable_1 = new CapNhat_HetHan_Unrepeatable_1();
			unrepeatable_1.setVisible(true);
			unrepeatable_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			unrepeatable_1.setVisible(true);
		}
	}
	protected void do_btnPhantom_actionPerformed(ActionEvent e) {
		if(phantomRead_11 == null) {
			phantomRead_11 = new Them_SanPham_PhantomRead_1();
			phantomRead_11.setVisible(true);
			phantomRead_11.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			phantomRead_11.setVisible(true);
		}
	}
	protected void do_btnU_1_1_actionPerformed(ActionEvent e) {
		if(phantomRead_12 == null) {
			phantomRead_12 = new VanTin_SanPham_PhantomRead_1();
			phantomRead_12.setVisible(true);
			phantomRead_12.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			phantomRead_12.setVisible(true);
		}
	}
	protected void do_btnU_1_1_1_actionPerformed(ActionEvent e) {
		if(phantomRead_2 == null) {
			phantomRead_2 = new VanTin_DoiTac_PhantomRead_2();
			phantomRead_2.setVisible(true);
			phantomRead_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			phantomRead_2.setVisible(true);
		}
	}
	protected void do_btnPhantomRead_actionPerformed(ActionEvent e) {
		if(phantomRead_3 == null) {
			phantomRead_3 = new VanTin_ChiNhanh_PhantomRead_3();
			phantomRead_3.setVisible(true);
			phantomRead_3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			phantomRead_3.setVisible(true);
		}
	}
}
