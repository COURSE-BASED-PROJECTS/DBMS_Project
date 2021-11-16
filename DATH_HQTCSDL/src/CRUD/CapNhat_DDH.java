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

import DoiTuong.DoiTuong_DDH;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapNhat_DDH extends JFrame {

	private JPanel contentPane;
	private JTextField maDDH;
	private JTextField tinhtrang;
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhat_DDH frame = new CapNhat_DDH(taikhoan,matkhau);
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
	public CapNhat_DDH(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Cập Nhật Đơn Đặt Hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 680, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cập Nhật Đơn Đặt Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 646, 44);
		contentPane.add(lblNewLabel);
		
		maDDH = new JTextField();
		maDDH.setBounds(124, 88, 161, 51);
		contentPane.add(maDDH);
		maDDH.setColumns(10);
		
		tinhtrang = new JTextField();
		tinhtrang.setColumns(10);
		tinhtrang.setBounds(457, 88, 161, 51);
		contentPane.add(tinhtrang);
		
		JLabel lblNewLabel_1 = new JLabel("Mã ĐĐH");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 96, 84, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tình Trạng");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(363, 96, 84, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnCpNht = new JButton("Cập Nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNht_actionPerformed(e);
			}
		});
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht.setBounds(287, 183, 100, 54);
		contentPane.add(btnCpNht);
	}
	protected void do_btnCpNht_actionPerformed(ActionEvent e) {
		DoiTuong_DDH ddh = new DoiTuong_DDH();
		ddh.setMaddh(maDDH.getText());
		ddh.setTinhtrang(tinhtrang.getText());
		
		if(ddh.suaDDH(ddh, "TaiXe", "TaiXe"))
			JOptionPane.showConfirmDialog(this, "Đã cập nhật thành công","Cập nhật",JOptionPane.CLOSED_OPTION);
		else {
			JOptionPane.showConfirmDialog(this, "Cập nhật không thành công","Cập nhật",JOptionPane.CLOSED_OPTION);
		}
	}
}
