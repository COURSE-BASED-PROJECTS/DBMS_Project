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
import DoiTuong.DoiTuong_SanPham;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapNhat_SanPham extends JFrame {

	private JPanel contentPane;
	private JTextField masp_nhap;
	private JTextField masp_sua;
	private JTextField tensp_sua;
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhat_SanPham frame = new CapNhat_SanPham(taikhoan,matkhau);
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
	public CapNhat_SanPham(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Cập Nhật Sản Phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 672, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpNhtSan = new JLabel("Cập Nhật Sản Phẩm");
		lblCpNhtSan.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpNhtSan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpNhtSan.setBounds(10, 10, 638, 44);
		contentPane.add(lblCpNhtSan);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 64, 638, 180);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(34, 69, 84, 32);
		panel.add(lblNewLabel_1);
		
		masp_nhap = new JTextField();
		masp_nhap.setColumns(10);
		masp_nhap.setBounds(114, 61, 161, 51);
		panel.add(masp_nhap);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "S\u01B0\u0309a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 261, 638, 180);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(32, 39, 84, 32);
		panel_1.add(lblNewLabel_1_1);
		
		masp_sua = new JTextField();
		masp_sua.setColumns(10);
		masp_sua.setBounds(115, 26, 161, 51);
		panel_1.add(masp_sua);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên Sản Phẩm");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(32, 111, 84, 32);
		panel_1.add(lblNewLabel_1_1_1);
		
		tensp_sua = new JTextField();
		tensp_sua.setColumns(10);
		tensp_sua.setBounds(115, 103, 161, 51);
		panel_1.add(tensp_sua);
		
		JButton btnCpNht = new JButton("Cập Nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNht_actionPerformed(e);
			}
		});
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht.setBounds(278, 460, 100, 54);
		contentPane.add(btnCpNht);
	}
	protected void do_btnCpNht_actionPerformed(ActionEvent e) {
		DoiTuong_SanPham sp_nhap = new DoiTuong_SanPham();
		DoiTuong_SanPham sp_sua = new DoiTuong_SanPham();
		
		sp_nhap.setMasp(masp_nhap.getText());

		
		sp_sua.setMasp(masp_sua.getText());
		sp_sua.setTensp(tensp_sua.getText());

		
		if(sp_nhap.suaSanPham(sp_sua, "DoiTac", "DoiTac")) {
			JOptionPane.showConfirmDialog(this, "Sửa thành công","Sửa Sản Phẩm",JOptionPane.OK_OPTION);
		}
		else {
			JOptionPane.showConfirmDialog(this, "Sửa không thành công","Sửa Sản Phẩm",JOptionPane.CANCEL_OPTION);
		}
	}
}
