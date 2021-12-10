package QuanTri;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DoiTuong.DoiTuong_CungCap;
import DoiTuong.DoiTuong_QuanTri;
import DoiTuong.TaiKhoan_HienTai;
import KetNoi.KetNoi;
import TranhChap.Unrepeatable.CapNhat_TaiKhoan_Unrepeatable_3;
import TranhChap.Unrepeatable.VanTin_SanPham_Unrepeatable_2;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class QuanTri extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox phanhe;
	private JTextField taikhoan_nhap;
	
	private final ButtonGroup kichhoat = new ButtonGroup();
	private JRadioButton dakichhoat;
	private JRadioButton chuakichhoat;
	private JPasswordField matkhau_nhap;
	private CapNhat_TaiKhoan_Unrepeatable_3 unrepeatable_3 =null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanTri frame = new QuanTri();
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
	public QuanTri() {
		
		setTitle("Quản Trị");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 815, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 271, 781, 158);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblQuanTriTai = new JLabel("Quản Trị Tài Khoản");
		lblQuanTriTai.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanTriTai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuanTriTai.setBounds(10, 10, 791, 44);
		contentPane.add(lblQuanTriTai);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 64, 493, 187);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 39, 84, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 112, 84, 32);
		panel.add(lblNewLabel_1_1);
		
		taikhoan_nhap = new JTextField();
		taikhoan_nhap.setColumns(10);
		taikhoan_nhap.setBounds(71, 27, 161, 51);
		panel.add(taikhoan_nhap);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phân hệ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(263, 39, 84, 32);
		panel.add(lblNewLabel_1_2);
		
		phanhe = new JComboBox();
		phanhe.setModel(new DefaultComboBoxModel(new String[] {"Quản Trị", "Nhân Viên", "Khách Hàng", "Tài Xế", "Đối Tác"}));
		phanhe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phanhe.setBounds(317, 27, 146, 51);
		panel.add(phanhe);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tình Trạng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(263, 112, 84, 32);
		panel.add(lblNewLabel_1_2_1);
		
		dakichhoat = new JRadioButton("Đã Kích Hoạt");
		kichhoat.add(dakichhoat);
		dakichhoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dakichhoat.setBounds(328, 106, 103, 21);
		panel.add(dakichhoat);
		
		chuakichhoat = new JRadioButton("Chưa Kích Hoạt");
		kichhoat.add(chuakichhoat);
		chuakichhoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chuakichhoat.setBounds(328, 136, 113, 21);
		panel.add(chuakichhoat);
		
		matkhau_nhap = new JPasswordField();
		matkhau_nhap.setBounds(71, 105, 161, 50);
		panel.add(matkhau_nhap);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ti\u0301nh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(513, 64, 278, 187);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnTaiLai = new JButton("Tải lại");
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTaiLai_actionPerformed(e);
			}
		});
		btnTaiLai.setBackground(Color.GREEN);
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTaiLai.setBounds(143, 110, 100, 36);
		panel_1.add(btnTaiLai);
		
		JButton btnCpNht_1 = new JButton("Cập Nhật");
		btnCpNht_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNht_1_actionPerformed(e);
			}
		});
		btnCpNht_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht_1.setBounds(25, 110, 100, 36);
		panel_1.add(btnCpNht_1);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnThm_actionPerformed(e);
			}
		});
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThm.setBounds(25, 41, 100, 36);
		panel_1.add(btnThm);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXoa_actionPerformed(e);
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(143, 41, 100, 36);
		panel_1.add(btnXoa);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Demo Tranh Ch\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(10, 433, 415, 102);
		contentPane.add(panel_1_1);
		
		JButton btnUnrepeatable = new JButton("Unrepeatable 3");
		btnUnrepeatable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUnrepeatable_actionPerformed(e);
			}
		});
		btnUnrepeatable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUnrepeatable.setBounds(21, 28, 141, 47);
		panel_1_1.add(btnUnrepeatable);
		
		loadData();
	}
	
	private void initialRow(DefaultTableModel defaultTableModel) {
		defaultTableModel.addColumn("TAIKHOAN");
		defaultTableModel.addColumn("MATKHAU");
		defaultTableModel.addColumn("PHANHE");
		defaultTableModel.addColumn("DAKICHHOAT");
	}
	
	private void loadData() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel);
		
		KetNoi kn = new KetNoi(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
		ResultSet rs = kn.getResultSet("select * from NGUOIDUNG");
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
	protected void do_btnTaiLai_actionPerformed(ActionEvent e) {
		loadData();
	}
	
	protected String phanloai(String loai) {
		String ketqua="";
		
		switch (loai) {
		case "Đối Tác": {
			ketqua = "DoiTac";
			break;
		}
		case "Khách Hàng": {
			ketqua = "KhachHang";
			break;
		}
		
		case "Nhân Viên": {
			ketqua = "NhanVien";
			break;
		}
		case "Tài Xế": {
			ketqua = "TaiXe";
			break;
		}
		case "Quản Trị": {
			ketqua = "QuanTri";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + loai);
		}
		
		return ketqua;
	}
	
	protected void do_btnThm_actionPerformed(ActionEvent e) {
		DoiTuong_QuanTri qt = new DoiTuong_QuanTri();
		
		qt.setTaikhoan(taikhoan_nhap.getText());
		qt.setMatkhau(new String(matkhau_nhap.getPassword()));
		qt.setPhanhe(phanloai(phanhe.getSelectedItem().toString()));
		qt.setTinhtrang(dakichhoat.isSelected() ? "1":"0");
		
		if(qt.themTaiKhoan(qt, TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau())) {
			JOptionPane.showConfirmDialog(this, "Thêm thành công","Thêm Tài Khoản",JOptionPane.OK_OPTION);
			
		}
		else {
			JOptionPane.showConfirmDialog(this, "Thêm không thành công","Thêm Tài Khoản",JOptionPane.CANCEL_OPTION);
		}
	}
	
	
	protected void do_btnXoa_actionPerformed(ActionEvent e) {
		DoiTuong_QuanTri qt = new DoiTuong_QuanTri();
		
		qt.setTaikhoan(taikhoan_nhap.getText());
		
		if(qt.xoaTaiKhoan(qt, TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau())) {
			JOptionPane.showConfirmDialog(this, "Xóa thành công","Xóa Tài Khoản",JOptionPane.OK_OPTION);
			
		}
		else {
			JOptionPane.showConfirmDialog(this, "Xóa không thành công","Xóa Tài Khoản",JOptionPane.CANCEL_OPTION);
		}
	}
	protected void do_btnCpNht_1_actionPerformed(ActionEvent e) {
		DoiTuong_QuanTri qt = new DoiTuong_QuanTri();
		
		qt.setTaikhoan(taikhoan_nhap.getText());
		qt.setMatkhau(new String(matkhau_nhap.getPassword()));
		qt.setPhanhe(phanloai(phanhe.getSelectedItem().toString()));
		qt.setTinhtrang(dakichhoat.isSelected() ? "1":"0");
		
		if(qt.suaTaiKhoan(qt, TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau())) {
			JOptionPane.showConfirmDialog(this, "Cập nhật thành công","Cập nhật Tài Khoản",JOptionPane.OK_OPTION);
			
		}
		else {
			JOptionPane.showConfirmDialog(this, "Cập nhật không thành công","Cập nhật Tài Khoản",JOptionPane.CANCEL_OPTION);
		}
	}
	protected void do_btnUnrepeatable_actionPerformed(ActionEvent e) {
		if(unrepeatable_3 == null) {
			unrepeatable_3 = new CapNhat_TaiKhoan_Unrepeatable_3();
			unrepeatable_3.setVisible(true);
			unrepeatable_3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			unrepeatable_3.setVisible(true);
		}
	}
}
