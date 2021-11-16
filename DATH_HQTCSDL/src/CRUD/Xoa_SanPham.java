package CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import DoiTuong.DoiTuong_ChiNhanh;
import DoiTuong.DoiTuong_SanPham;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Xoa_SanPham extends JFrame {

	private JPanel contentPane;
	private JTextField masp;
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xoa_SanPham frame = new Xoa_SanPham(taikhoan,matkhau);
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
	public Xoa_SanPham(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Xóa Sản Phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 680, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Xóa Sản Phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 667, 44);
		contentPane.add(lblNewLabel);
		
		masp = new JTextField();
		masp.setBounds(265, 88, 161, 51);
		contentPane.add(masp);
		masp.setColumns(10);
		
		JButton btnNewButton = new JButton("Xóa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(291, 163, 100, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(171, 96, 84, 32);
		contentPane.add(lblNewLabel_1);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		DoiTuong_SanPham sp = new DoiTuong_SanPham();
		sp.setMasp(masp.getText());
		
		if(sp.xoaSanPham(sp, "DoiTac", "DoiTac")) {
			JOptionPane.showConfirmDialog(this, "Xóa thành công","Xóa Sản Phẩm",JOptionPane.OK_OPTION);
		}
		else {
			JOptionPane.showConfirmDialog(this, "Xóa không thành công","Xóa Sản Phẩm",JOptionPane.CANCEL_OPTION);
		}
	}
}
