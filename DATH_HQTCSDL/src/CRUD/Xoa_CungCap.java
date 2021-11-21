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

public class Xoa_CungCap extends JFrame {

	private JPanel contentPane;
	private JTextField mst;
	private JTextField machinhanh;
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
					Xoa_CungCap frame = new Xoa_CungCap(taikhoan,matkhau);
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
	public Xoa_CungCap(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Xóa Cung Cấp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 730, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Xóa Cung Cấp");
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
		
		JButton btnNewButton = new JButton("Xóa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(301, 270, 100, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Số Thuế");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 96, 84, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Chi Nhánh");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(363, 96, 84, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(30, 194, 84, 32);
		contentPane.add(lblNewLabel_1_4);
		
		masp = new JTextField();
		masp.setColumns(10);
		masp.setBounds(124, 186, 161, 51);
		contentPane.add(masp);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		DoiTuong_CungCap cc = new DoiTuong_CungCap();
		cc.setMst(mst.getText());
		cc.setMachinhanh(machinhanh.getText());
		cc.setMasp(masp.getText());
		
		if(cc.xoaCungCap(cc, "DoiTac", "DoiTac")) {
			JOptionPane.showConfirmDialog(this, "Xóa thành công","Xóa Cung Cấp",JOptionPane.OK_OPTION);
		}
		else {
			JOptionPane.showConfirmDialog(this, "Xóa không thành công","Xóa Cung Cấp",JOptionPane.CANCEL_OPTION);
		}
	}
}
