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

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapNhat_ChiNhanh extends JFrame {

	private JPanel contentPane;
	private JTextField mst_nhap;
	private JTextField machinhanh_nhap;
	private JTextField mst_sua;
	private JTextField machinhanh_sua;
	private JTextField nguoidaidien_sua;
	private JTextField diachi_sua;
	private static String taikhoan="";
	private static String matkhau="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhat_ChiNhanh frame = new CapNhat_ChiNhanh(taikhoan,matkhau);
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
	public CapNhat_ChiNhanh(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Cập Nhật Chi Nhánh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 784, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpNhtChi = new JLabel("Cập Nhật Chi Nhánh");
		lblCpNhtChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpNhtChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpNhtChi.setBounds(10, 10, 750, 44);
		contentPane.add(lblCpNhtChi);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 64, 750, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Số Thuế");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(23, 41, 84, 32);
		panel.add(lblNewLabel_1);
		
		mst_nhap = new JTextField();
		mst_nhap.setColumns(10);
		mst_nhap.setBounds(117, 33, 161, 51);
		panel.add(mst_nhap);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Chi Nhánh");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(370, 41, 84, 32);
		panel.add(lblNewLabel_1_1);
		
		machinhanh_nhap = new JTextField();
		machinhanh_nhap.setColumns(10);
		machinhanh_nhap.setBounds(464, 33, 161, 51);
		panel.add(machinhanh_nhap);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "S\u01B0\u0309a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 201, 750, 275);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã Số Thuế");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(27, 37, 84, 32);
		panel_1.add(lblNewLabel_1_3);
		
		mst_sua = new JTextField();
		mst_sua.setColumns(10);
		mst_sua.setBounds(115, 29, 161, 51);
		panel_1.add(mst_sua);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã Chi Nhánh");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(377, 37, 84, 32);
		panel_1.add(lblNewLabel_1_1_1);
		
		machinhanh_sua = new JTextField();
		machinhanh_sua.setColumns(10);
		machinhanh_sua.setBounds(462, 29, 161, 51);
		panel_1.add(machinhanh_sua);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Người Đại Diện");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(27, 131, 84, 32);
		panel_1.add(lblNewLabel_1_2_1);
		
		nguoidaidien_sua = new JTextField();
		nguoidaidien_sua.setColumns(10);
		nguoidaidien_sua.setBounds(115, 119, 508, 51);
		panel_1.add(nguoidaidien_sua);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Địa Chỉ");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1.setBounds(27, 204, 84, 32);
		panel_1.add(lblNewLabel_1_3_1);
		
		diachi_sua = new JTextField();
		diachi_sua.setColumns(10);
		diachi_sua.setBounds(116, 198, 507, 51);
		panel_1.add(diachi_sua);
		
		JButton btnCpNht = new JButton("Cập Nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNht_actionPerformed(e);
			}
		});
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht.setBounds(327, 497, 100, 54);
		contentPane.add(btnCpNht);
	}
	protected void do_btnCpNht_actionPerformed(ActionEvent e) {
		DoiTuong_ChiNhanh cn_nhap = new DoiTuong_ChiNhanh();
		DoiTuong_ChiNhanh cn_sua = new DoiTuong_ChiNhanh();
		
		cn_nhap.setMst(mst_nhap.getText());
		cn_nhap.setMachinhanh(machinhanh_nhap.getText());
		
		cn_sua.setMst(mst_sua.getText());
		cn_sua.setNguoidaidien(nguoidaidien_sua.getText());
		cn_sua.setMachinhanh(machinhanh_sua.getText());
		cn_sua.setDiachi(diachi_sua.getText());
		
		if(cn_sua.suaChiNhanh(cn_nhap, "DoiTac", "DoiTac")) {
			JOptionPane.showConfirmDialog(this, "Sửa thành công","Sửa Chi Nhánh",JOptionPane.OK_OPTION);
		}
		else {
			JOptionPane.showConfirmDialog(this, "Sửa không thành công","Sửa Chi Nhánh",JOptionPane.CANCEL_OPTION);
		}
	}
}
