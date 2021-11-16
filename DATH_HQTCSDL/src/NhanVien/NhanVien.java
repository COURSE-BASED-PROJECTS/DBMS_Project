package NhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUD.CapNhat_HopDong;
import CRUD.CapNhat_SanPham;
import KetNoi.KetNoi;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CapNhat_HopDong capnhatHopDong =null;
	private static String taikhoan="";
	private static String matkhau="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien(taikhoan,matkhau);
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
	public NhanVien(String taikhoan, String matkhau) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		
		setTitle("Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 828, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhnVin = new JLabel("Nh\u00E2n Vi\u00EAn");
		lblNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNhnVin.setBounds(288, 10, 204, 61);
		contentPane.add(lblNhnVin);
		
		JButton btnThmHpng = new JButton(" Cập nhật Hợp Đồng");
		btnThmHpng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnThmHpng_actionPerformed(e);
			}
		});
		btnThmHpng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThmHpng.setBounds(10, 81, 171, 49);
		contentPane.add(btnThmHpng);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 794, 260);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTaiLai = new JButton("Tải lại");
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTaiLai.setBackground(Color.GREEN);
		btnTaiLai.setBounds(709, 81, 95, 49);
		contentPane.add(btnTaiLai);
		loadData();
	}
	
	private void initialRow(DefaultTableModel defaultTableModel) {
		defaultTableModel.addColumn("MST");
		defaultTableModel.addColumn("NGUOIDAIDIEN");
		defaultTableModel.addColumn("MAHD");
		defaultTableModel.addColumn("THGIANBATDAU");
		defaultTableModel.addColumn("THGIANHIEULUC");
		defaultTableModel.addColumn("PHIHOAHONG");
		defaultTableModel.addColumn("SOCHINHANHDK");
		defaultTableModel.addColumn("KICHHOAT");
	}
	
	private void loadData() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel);
		
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		ResultSet rs = kn.getResultSet("select * from HOPDONG");
		int numberColumn = kn.getNumberColumn();
		defaultTableModel.setRowCount(0);
		
		try {
			Vector<String> row = null;
			while(rs.next()) {
				row = new Vector<String>();
				
				for(int i=1;i<=numberColumn;i++)
					row.addElement(rs.getString(i));
				defaultTableModel.addRow(row);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table.setModel(defaultTableModel);
	}
	protected void do_btnThmHpng_actionPerformed(ActionEvent e) {
		if(capnhatHopDong ==null) {
			capnhatHopDong = new CapNhat_HopDong(taikhoan,matkhau);
			capnhatHopDong.setVisible(true);
			capnhatHopDong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capnhatHopDong.setVisible(true);
		}
	}
}
