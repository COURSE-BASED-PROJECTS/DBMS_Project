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

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Them_ChiNhanh extends JFrame {

	private JPanel contentPane;
	private JTextField mst;
	private JTextField machinhanh;
	private JTextField nguoidaidien;
	private JTextField diachi;
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Them_ChiNhanh frame = new Them_ChiNhanh(taikhoan,matkhau);
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
	public Them_ChiNhanh(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Thêm Chi Nhánh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 701, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm Chi Nhánh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 667, 44);
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
		
		diachi = new JTextField();
		diachi.setColumns(10);
		diachi.setBounds(124, 279, 494, 51);
		contentPane.add(diachi);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(297, 354, 100, 54);
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
		
		JLabel lblNewLabel_1_3 = new JLabel("Địa Chỉ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(30, 285, 84, 32);
		contentPane.add(lblNewLabel_1_3);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		DoiTuong_ChiNhanh cn = new DoiTuong_ChiNhanh();
		cn.setMst(mst.getText());
		cn.setNguoidaidien(nguoidaidien.getText());
		cn.setMachinhanh(machinhanh.getText());
		cn.setDiachi(diachi.getText());
		
		if(cn.themChiNhanh(cn, taikhoan, matkhau)) {
			JOptionPane.showConfirmDialog(this, "Thêm thành công","Thêm Chi Nhánh",JOptionPane.OK_OPTION);
			
		}
		else {
			JOptionPane.showConfirmDialog(this, "Thêm không thành công","Thêm Chi Nhánh",JOptionPane.CANCEL_OPTION);
		}
	}
}
