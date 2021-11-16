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
import DoiTuong.DoiTuong_CungCap;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Them_CungCap extends JFrame {

	private JPanel contentPane;
	private JTextField mst;
	private JTextField machinhanh;
	private JTextField nguoidaidien;
	private JTextField masp;
	private JTextField giasp;
	private static String taikhoan="";
	private static String matkhau="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Them_CungCap frame = new Them_CungCap(taikhoan,matkhau);
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
	public Them_CungCap(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Thêm Cung Cấp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 730, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm Cung Cấp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 696, 44);
		contentPane.add(lblNewLabel);
		
		mst = new JTextField();
		mst.setBounds(124, 88, 161, 51);
		contentPane.add(mst);
		mst.setColumns(10);
		
		machinhanh = new JTextField();
		machinhanh.setColumns(10);
		machinhanh.setBounds(457, 88, 161, 51);
		contentPane.add(machinhanh);
		
		nguoidaidien = new JTextField();
		nguoidaidien.setColumns(10);
		nguoidaidien.setBounds(124, 186, 494, 51);
		contentPane.add(nguoidaidien);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(310, 374, 100, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Số Thuế");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 96, 84, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Chi Nhánh");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(363, 96, 84, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Người Đại Diện");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(30, 194, 84, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(30, 288, 84, 32);
		contentPane.add(lblNewLabel_1_4);
		
		masp = new JTextField();
		masp.setColumns(10);
		masp.setBounds(124, 280, 161, 51);
		contentPane.add(masp);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gía Sản Phẩm");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(363, 288, 84, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		giasp = new JTextField();
		giasp.setColumns(10);
		giasp.setBounds(457, 280, 161, 51);
		contentPane.add(giasp);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		DoiTuong_CungCap cc = new DoiTuong_CungCap();
		cc.setMst(mst.getText());
		cc.setNguoidaidien(nguoidaidien.getText());
		cc.setMachinhanh(machinhanh.getText());
		cc.setMasp(masp.getText());
		cc.setGiasp(giasp.getText());
		
		if(cc.themCungCap(cc, "DoiTac", "DoiTac")) {
			JOptionPane.showConfirmDialog(this, "Thêm thành công","Thêm Cung Cấp",JOptionPane.OK_OPTION);
			
		}
		else {
			JOptionPane.showConfirmDialog(this, "Thêm không thành công","Thêm Cung Cấp",JOptionPane.CANCEL_OPTION);
		}
	}
}
