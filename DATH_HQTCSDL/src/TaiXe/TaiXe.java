package TaiXe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUD.CapNhat_DDH;
import DoiTuong.TaiKhoan_HienTai;
import KetNoi.KetNoi;
import TranhChap.DirtyRead.CapNhat_TinhTrang_DirtyRead_2;
import TranhChap.DirtyRead.VanTin_DDH_DirtyRead_3;
import TranhChap.Unrepeatable.DangNhap_Unrepeatable_3;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class TaiXe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CapNhat_DDH capnhatDDH =null;
	private CapNhat_TinhTrang_DirtyRead_2 dirtyRead_2=null;
	private VanTin_DDH_DirtyRead_3 dirtyRead_3=null;
	private DangNhap_Unrepeatable_3 unrepeatable_3=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaiXe frame = new TaiXe();
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
	public TaiXe() {
		
		setTitle("Tai Xe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 773, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTaiX = new JLabel("Ta\u0300i X\u00EA\u0301");
		lblTaiX.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiX.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTaiX.setBounds(265, 10, 204, 61);
		contentPane.add(lblTaiX);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 739, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCpNhtTinh = new JButton("Cập nhật Tình Trạng Đơn Hàng");
		btnCpNhtTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNhtTinh_actionPerformed(e);
			}
		});
		btnCpNhtTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNhtTinh.setBounds(10, 74, 245, 49);
		contentPane.add(btnCpNhtTinh);
		
		JButton btnTaiLai = new JButton("Tải lại");
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTaiLai_actionPerformed(e);
			}
		});
		btnTaiLai.setBackground(Color.GREEN);
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTaiLai.setBounds(654, 74, 95, 49);
		contentPane.add(btnTaiLai);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(10, 394, 739, 102);
		contentPane.add(panel_1_1);
		
		JButton btnDirtyRead = new JButton("Dirty read 2");
		btnDirtyRead.setBounds(10, 34, 141, 47);
		panel_1_1.add(btnDirtyRead);
		btnDirtyRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDirtyRead_actionPerformed(e);
			}
		});
		btnDirtyRead.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnDirtyRead_2 = new JButton("Dirty read 3");
		btnDirtyRead_2.setBounds(179, 34, 141, 47);
		panel_1_1.add(btnDirtyRead_2);
		btnDirtyRead_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDirtyRead_2_actionPerformed(e);
			}
		});
		btnDirtyRead_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnDirtyRead_2_1 = new JButton("Unrepeatable 3");
		btnDirtyRead_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDirtyRead_2_1_actionPerformed(e);
			}
		});
		btnDirtyRead_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDirtyRead_2_1.setBounds(353, 34, 141, 47);
		panel_1_1.add(btnDirtyRead_2_1);
		
		loadData();
	}
	
	private void initialRow(DefaultTableModel defaultTableModel) {
		defaultTableModel.addColumn("MADDH");
		defaultTableModel.addColumn("MAKH");
		defaultTableModel.addColumn("MATAIXE");
		defaultTableModel.addColumn("DIACHIGIAOHANG");
		defaultTableModel.addColumn("HINHTHUCTT");
		defaultTableModel.addColumn("PHIVANCHUYEN");
		defaultTableModel.addColumn("PHISP");
		defaultTableModel.addColumn("TINHTRANG");
		defaultTableModel.addColumn("TONGTIEN");
	}
	
	private void loadData() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel);
		
		KetNoi kn = new KetNoi(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
		ResultSet rs = kn.getResultSet("select * from DONDH");
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

	protected void do_btnCpNhtTinh_actionPerformed(ActionEvent e) {
		if(capnhatDDH ==null) {
			capnhatDDH = new CapNhat_DDH(TaiKhoan_HienTai.getTaikhoan(), TaiKhoan_HienTai.getMatkhau());
			capnhatDDH.setVisible(true);
			capnhatDDH.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			capnhatDDH.setVisible(true);
		}
	}
	protected void do_btnTaiLai_actionPerformed(ActionEvent e) {
		loadData();
	}
	protected void do_btnDirtyRead_actionPerformed(ActionEvent e) {
		if(dirtyRead_2 ==null) {
			dirtyRead_2 = new CapNhat_TinhTrang_DirtyRead_2();
			dirtyRead_2.setVisible(true);
			dirtyRead_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			dirtyRead_2.setVisible(true);
		}
	}
	protected void do_btnDirtyRead_2_actionPerformed(ActionEvent e) {
		if(dirtyRead_3 ==null) {
			dirtyRead_3 = new VanTin_DDH_DirtyRead_3();
			dirtyRead_3.setVisible(true);
			dirtyRead_3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			dirtyRead_3.setVisible(true);
		}
	}
	protected void do_btnDirtyRead_2_1_actionPerformed(ActionEvent e) {
		if(unrepeatable_3 ==null) {
			unrepeatable_3 = new DangNhap_Unrepeatable_3();
			unrepeatable_3.setVisible(true);
			unrepeatable_3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else {
			unrepeatable_3.setVisible(true);
		}
	}
}
