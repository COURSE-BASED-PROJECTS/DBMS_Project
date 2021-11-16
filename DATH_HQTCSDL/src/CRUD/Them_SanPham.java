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

public class Them_SanPham extends JFrame {

	private JPanel contentPane;
	private JTextField masp;
	private JTextField tensp;
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Them_SanPham frame = new Them_SanPham(taikhoan,matkhau);
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
	public Them_SanPham(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Thêm Sản Phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 680, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm Sản Phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 667, 44);
		contentPane.add(lblNewLabel);
		
		masp = new JTextField();
		masp.setBounds(124, 88, 161, 51);
		contentPane.add(masp);
		masp.setColumns(10);
		
		tensp = new JTextField();
		tensp.setColumns(10);
		tensp.setBounds(457, 88, 161, 51);
		contentPane.add(tensp);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(292, 182, 100, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 96, 84, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Sản Phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(363, 96, 84, 32);
		contentPane.add(lblNewLabel_1_1);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		DoiTuong_SanPham sp = new DoiTuong_SanPham();
		sp.setMasp(masp.getText());
		sp.setTensp(tensp.getText());

		
		if(sp.themSanPham(sp, "DoiTac", "DoiTac")) {
			JOptionPane.showConfirmDialog(this, "Thêm thành công","Thêm Sản Phẩm",JOptionPane.OK_OPTION);
			
		}
		else {
			JOptionPane.showConfirmDialog(this, "Thêm không thành công","Thêm Sản Phẩm",JOptionPane.CANCEL_OPTION);
		}
	}
}
