package CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import DoiTuong.DoiTuong_CungCap;
import DoiTuong.DoiTuong_HopDong;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapNhat_HopDong extends JFrame {

	private JPanel contentPane;
	private JTextField mst_nhap;
	private JTextField mahd_nhap;
	private JTextField nguoidaidien_nhap;
	private JTextField tghieuluc;
	private JTextField phihoahong;
	private final ButtonGroup thoigian = new ButtonGroup();
	private JRadioButton dakichhoat;
	private JRadioButton chuakichhoat;
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhat_HopDong frame = new CapNhat_HopDong(taikhoan,matkhau);
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
	public CapNhat_HopDong(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Cập Nhật Hợp Đồng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 745, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpNhtHp = new JLabel("Cập Nhật Hợp Đồng");
		lblCpNhtHp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpNhtHp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpNhtHp.setBounds(10, 10, 711, 44);
		contentPane.add(lblCpNhtHp);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 71, 711, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Số Thuế");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 36, 84, 32);
		panel.add(lblNewLabel_1);
		
		mst_nhap = new JTextField();
		mst_nhap.setColumns(10);
		mst_nhap.setBounds(124, 28, 161, 51);
		panel.add(mst_nhap);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Hợp Đồng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(372, 36, 84, 32);
		panel.add(lblNewLabel_1_1);
		
		mahd_nhap = new JTextField();
		mahd_nhap.setColumns(10);
		mahd_nhap.setBounds(466, 28, 161, 51);
		panel.add(mahd_nhap);
		
		JLabel lblNewLabel_1_2 = new JLabel("Người Đại Diện");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(30, 127, 84, 32);
		panel.add(lblNewLabel_1_2);
		
		nguoidaidien_nhap = new JTextField();
		nguoidaidien_nhap.setColumns(10);
		nguoidaidien_nhap.setBounds(124, 121, 494, 51);
		panel.add(nguoidaidien_nhap);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "S\u01B0\u0309a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 285, 711, 190);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("TG Hiệu Lực");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(33, 40, 84, 32);
		panel_1.add(lblNewLabel_1_3);
		
		tghieuluc = new JTextField();
		tghieuluc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtYyyymmdd_focusLost(e);
			}
		});
		tghieuluc.setHorizontalAlignment(SwingConstants.CENTER);
		tghieuluc.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		tghieuluc.setText("yyyy/mm/dd");
		tghieuluc.setColumns(10);
		tghieuluc.setBounds(122, 32, 161, 51);
		panel_1.add(tghieuluc);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Phí Hoa Hồng");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1.setBounds(372, 40, 84, 32);
		panel_1.add(lblNewLabel_1_3_1);
		
		phihoahong = new JTextField();
		phihoahong.setColumns(10);
		phihoahong.setBounds(465, 32, 161, 51);
		panel_1.add(phihoahong);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Kích Hoạt");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_2.setBounds(33, 123, 84, 32);
		panel_1.add(lblNewLabel_1_3_2);
		
		dakichhoat = new JRadioButton("Đã Kích Hoạt");
		thoigian.add(dakichhoat);
		dakichhoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dakichhoat.setBounds(122, 123, 103, 21);
		panel_1.add(dakichhoat);
		
		chuakichhoat = new JRadioButton("Chưa Kích Hoạt");
		thoigian.add(chuakichhoat);
		chuakichhoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chuakichhoat.setBounds(122, 146, 113, 21);
		panel_1.add(chuakichhoat);
		
		JButton btnCpNht = new JButton("Cập Nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNht_actionPerformed(e);
			}
		});
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht.setBounds(317, 500, 100, 54);
		contentPane.add(btnCpNht);
	}
	protected void do_txtYyyymmdd_focusLost(FocusEvent e) {
		if(tghieuluc.getText().isEmpty()){
			tghieuluc.setText("yyyy/mm/dd");
		}
	}
	protected void do_btnCpNht_actionPerformed(ActionEvent e) {
		DoiTuong_HopDong hp_nhap = new DoiTuong_HopDong();
		DoiTuong_HopDong hd_sua = new DoiTuong_HopDong();
		
		hp_nhap.setMst(mst_nhap.getText());
		hp_nhap.setNguoidaidien(nguoidaidien_nhap.getText());
		hp_nhap.setMahd(mahd_nhap.getText());
		
		hd_sua.setTghieuluc(tghieuluc.getText());
		hd_sua.setPhihoahong(phihoahong.getText());
		hd_sua.setKichhoat(dakichhoat.isSelected() ? "1":"0");
		
		if(hd_sua.suaHopDong(hp_nhap,hd_sua, "DoiTac", "DoiTac")) {
			JOptionPane.showConfirmDialog(this, "Sửa thành công","Sửa Hợp Đồng",JOptionPane.OK_OPTION);
		}
		else {
			JOptionPane.showConfirmDialog(this, "Sửa không thành công","Sửa Hợp Đồng",JOptionPane.CANCEL_OPTION);
		}
	}
}
