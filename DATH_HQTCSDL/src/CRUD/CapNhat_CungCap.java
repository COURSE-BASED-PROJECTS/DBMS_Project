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

import DoiTuong.DoiTuong_ChiNhanh;
import DoiTuong.DoiTuong_CungCap;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapNhat_CungCap extends JFrame {

	private JPanel contentPane;
	private JTextField mst_nhap;
	private JTextField machinhanh_nhap;
	private JTextField masp_nhap;
	private JTextField mst_sua;
	private JTextField machinhanh_sua;
	private JTextField nguoidaidien_sua;
	private JTextField masp_sua;
	private JTextField giasp_sua;
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhat_CungCap frame = new CapNhat_CungCap(taikhoan,matkhau);
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
	public CapNhat_CungCap(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Cập Nhật Cung Cấp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 814, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpNhtCung = new JLabel("Cập Nhật Cung Cấp");
		lblCpNhtCung.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpNhtCung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpNhtCung.setBounds(10, 10, 780, 44);
		contentPane.add(lblCpNhtCung);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 64, 780, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Số Thuế");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(28, 34, 84, 32);
		panel.add(lblNewLabel_1);
		
		mst_nhap = new JTextField();
		mst_nhap.setColumns(10);
		mst_nhap.setBounds(119, 26, 161, 51);
		panel.add(mst_nhap);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Chi Nhánh");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(412, 34, 84, 32);
		panel.add(lblNewLabel_1_1);
		
		machinhanh_nhap = new JTextField();
		machinhanh_nhap.setColumns(10);
		machinhanh_nhap.setBounds(492, 28, 161, 51);
		panel.add(machinhanh_nhap);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(28, 119, 84, 32);
		panel.add(lblNewLabel_1_4);
		
		masp_nhap = new JTextField();
		masp_nhap.setColumns(10);
		masp_nhap.setBounds(119, 111, 161, 51);
		panel.add(masp_nhap);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "S\u01B0\u0309a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 285, 780, 300);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã Số Thuế");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(30, 30, 84, 32);
		panel_1.add(lblNewLabel_1_3);
		
		mst_sua = new JTextField();
		mst_sua.setColumns(10);
		mst_sua.setBounds(119, 21, 161, 51);
		panel_1.add(mst_sua);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã Chi Nhánh");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(412, 30, 84, 32);
		panel_1.add(lblNewLabel_1_1_1);
		
		machinhanh_sua = new JTextField();
		machinhanh_sua.setColumns(10);
		machinhanh_sua.setBounds(493, 21, 161, 51);
		panel_1.add(machinhanh_sua);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Người Đại Diện");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(30, 132, 84, 32);
		panel_1.add(lblNewLabel_1_2_1);
		
		nguoidaidien_sua = new JTextField();
		nguoidaidien_sua.setColumns(10);
		nguoidaidien_sua.setBounds(120, 120, 534, 51);
		panel_1.add(nguoidaidien_sua);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_1.setBounds(30, 224, 84, 32);
		panel_1.add(lblNewLabel_1_4_1);
		
		masp_sua = new JTextField();
		masp_sua.setColumns(10);
		masp_sua.setBounds(119, 216, 161, 51);
		panel_1.add(masp_sua);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Gía Sản Phẩm");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(412, 224, 84, 32);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		giasp_sua = new JTextField();
		giasp_sua.setColumns(10);
		giasp_sua.setBounds(493, 216, 161, 51);
		panel_1.add(giasp_sua);
		
		JButton btnCpNht = new JButton("Cập Nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNht_actionPerformed(e);
			}
		});
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht.setBounds(354, 609, 100, 54);
		contentPane.add(btnCpNht);
	}
	protected void do_btnCpNht_actionPerformed(ActionEvent e) {
		DoiTuong_CungCap cc_nhap = new DoiTuong_CungCap();
		DoiTuong_CungCap cc_sua = new DoiTuong_CungCap();
		
		cc_nhap.setMst(mst_nhap.getText());
		cc_nhap.setMachinhanh(machinhanh_nhap.getText());
		cc_nhap.setMasp(masp_nhap.getText());
		
		cc_sua.setMst(mst_sua.getText());
		cc_sua.setNguoidaidien(nguoidaidien_sua.getText());
		cc_sua.setMachinhanh(machinhanh_sua.getText());
		cc_sua.setMasp(masp_sua.getText());
		cc_sua.setGiasp(giasp_sua.getText());
		
		if(cc_sua.suaCungCap(cc_nhap,cc_sua, "DoiTac", "DoiTac")) {
			JOptionPane.showConfirmDialog(this, "Sửa thành công","Sửa Cung Cấp",JOptionPane.OK_OPTION);
		}
		else {
			JOptionPane.showConfirmDialog(this, "Sửa không thành công","Sửa Cung Cấp",JOptionPane.CANCEL_OPTION);
		}
	}
}
