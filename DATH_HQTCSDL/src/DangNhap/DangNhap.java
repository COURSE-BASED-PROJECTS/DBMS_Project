package DangNhap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import DangKy.DangKy;
import DoiTac.DoiTac;
import DoiTuong.TaiKhoan_HienTai;
import KetNoi.KetNoi;
import KhachHang.KhachHang;
import NhanVien.NhanVien;
import QuanTri.QuanTri;
import TaiXe.TaiXe;

import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;
	private JDesktopPane desktopPane;
	private static DangNhap frame;
	private DoiTac dt;
	private KhachHang kh;
	private NhanVien nv;
	private TaiXe tx;
	private QuanTri qt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DangNhap();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap() {
		setTitle("ĐĂNG NHẬP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		userName = new JTextField();
		userName.setBounds(126, 45, 188, 35);
		desktopPane.add(userName);
		userName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(126, 105, 188, 35);
		desktopPane.add(password);
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				do_password_keyPressed(e);
			}
		});
		
		JButton loginButton = new JButton("Đăng Nhập");
		loginButton.setBounds(174, 172, 86, 28);
		desktopPane.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_loginButton_actionPerformed(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Tài Khoản");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(36, 49, 61, 26);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(36, 109, 61, 26);
		desktopPane.add(lblNewLabel_1);
		
	}
	protected void do_loginButton_actionPerformed(ActionEvent e) {
		String usernameString = userName.getText();
		String passString = String.valueOf(password.getPassword());
		KetNoi kn = new KetNoi();
		
		ResultSet rs = kn.getResultSet("select * from NGUOIDUNG");
		int numberColumn = kn.getNumberColumn();
		Vector<String> row = null;
		boolean found = false;
		boolean lock = false;
		
		try {
			while(rs.next()) {
				row = new Vector<String>();
				
				for(int i=1;i<=numberColumn;i++)
					row.addElement(rs.getString(i));
				
				if(row.get(0).equals(usernameString) && row.get(1).equals(passString)) {
					found = true;
					lock = row.get(3).equals("1");
					break;
				}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			kn.Disconnect();
			try {
				rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		if(!found) {
			JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu sai",
					"lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if(!lock) {
			JOptionPane.showMessageDialog(this, "Tài khoản đã bị khóa",
					"lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		classification(row.get(2));
	}

	protected void classification(String type) {
		TaiKhoan_HienTai.setTaikhoan(userName.getText());
		TaiKhoan_HienTai.setMatkhau(String.valueOf(password.getPassword()));
		
		switch (type) {
		case "DoiTac": {
			dt = new DoiTac();
			dt.setVisible(true);
			this.dispose();
			
			break;
		}
		case "KhachHang": {
			kh = new KhachHang();
			kh.setVisible(true);
			this.dispose();
			
			break;
		}
		case "NhanVien": {
			nv = new NhanVien();
			nv.setVisible(true);
			this.dispose();
			
			break;
		}
		case "TaiXe": {
			tx = new TaiXe();
			tx.setVisible(true);
			this.dispose();
			
			break;
		}
		case "QuanTri": {
			qt = new QuanTri();
			qt.setVisible(true);
			this.dispose();
			
			break;
		}
		default:
			JOptionPane.showMessageDialog(this, "Tài khoản này chưa được phân hệ",
					"lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	protected void do_password_keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			String usernameString = userName.getText();
			String passString = String.valueOf(password.getPassword());
			KetNoi kn = new KetNoi();
			
			ResultSet rs = kn.getResultSet("select * from NGUOIDUNG");
			int numberColumn = kn.getNumberColumn();
			Vector<String> row = null;
			boolean found = false;
			
			try {
				while(rs.next()) {
					row = new Vector<String>();
					
					for(int i=1;i<=numberColumn;i++)
						row.addElement(rs.getString(i));
					
					if(row.get(0).equals(usernameString) && row.get(1).equals(passString)) {
						found = true;
						break;
					}
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				kn.Disconnect();
				try {
					rs.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
			if(!found) {
				JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu sai",
						"lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
				return;
			}
			classification(row.get(2));
		}
	}
}
