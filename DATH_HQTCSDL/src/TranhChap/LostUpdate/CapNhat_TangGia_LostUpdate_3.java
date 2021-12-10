package TranhChap.LostUpdate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DoiTuong.DoiTuong_CungCap;
import DoiTuong.DoiTuong_HopDong;
import KetNoi.KetNoi;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapNhat_TangGia_LostUpdate_3 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextPane giaText;
	private JTextPane mstText;
	private JTextPane mcnText;
	private String nameColumn_CungCap[]= {"MAST","MACHINHANH","MASP","GIASP"};
	private JTextPane mspText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhat_TangGia_LostUpdate_3 frame = new CapNhat_TangGia_LostUpdate_3();
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
	public CapNhat_TangGia_LostUpdate_3() {
		setTitle("Cập nhật tăng giá");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin c\u1EADp nh\u1EADt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 391, 197);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MST");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 25, 71, 34);
		panel.add(lblNewLabel);
		
		JLabel lblMsp = new JLabel("Giá mới");
		lblMsp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMsp.setBounds(170, 114, 82, 34);
		panel.add(lblMsp);
		
		JLabel lblMcn = new JLabel("MCN");
		lblMcn.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMcn.setBounds(196, 25, 71, 34);
		panel.add(lblMcn);
		
		mstText = new JTextPane();
		mstText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mstText.setBounds(63, 25, 92, 34);
		panel.add(mstText);
		
		giaText = new JTextPane();
		giaText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		giaText.setBounds(252, 114, 92, 34);
		panel.add(giaText);
		
		mcnText = new JTextPane();
		mcnText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mcnText.setBounds(252, 25, 92, 34);
		panel.add(mcnText);
		
		JLabel lblMsp_1 = new JLabel("MSP");
		lblMsp_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsp_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMsp_1.setBounds(0, 114, 71, 34);
		panel.add(lblMsp_1);
		
		mspText = new JTextPane();
		mspText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mspText.setBounds(63, 114, 92, 34);
		panel.add(mspText);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(411, 10, 711, 335);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 691, 307);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadData("CUNGCAP", nameColumn_CungCap, table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "T\u00EDnh n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 211, 391, 134);
		contentPane.add(panel_1);
		
		JButton btnNewButton_2 = new JButton("Tải lại");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setBounds(147, 87, 93, 34);
		panel_1.add(btnNewButton_2);
		
		JButton btnCpNhtTng = new JButton("Cập nhật tăng giá");
		btnCpNhtTng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNhtTng_actionPerformed(e);
			}
		});
		btnCpNhtTng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCpNhtTng.setBounds(10, 30, 169, 47);
		panel_1.add(btnCpNhtTng);
		
		JButton btnCpNhtHng_1 = new JButton("Cập nhật tăng giá (fix)");
		btnCpNhtHng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCpNhtHng_1_actionPerformed(e);
			}
		});
		btnCpNhtHng_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCpNhtHng_1.setBounds(211, 30, 170, 47);
		panel_1.add(btnCpNhtHng_1);
		
		loadData("CUNGCAP", nameColumn_CungCap, table);
	}
	
	private void initialRow(DefaultTableModel defaultTableModel, String nameColumn[]) {
		for (String name : nameColumn) {
			defaultTableModel.addColumn(name);
		}
	}
	
	private void loadData(String nameTable,String nameColumn[], JTable table) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		initialRow(defaultTableModel,nameColumn);
		
		String query = "select * from " + nameTable;
		KetNoi kn = new KetNoi();
		ResultSet rs = kn.getResultSet(query);
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
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		loadData("CUNGCAP", nameColumn_CungCap, table);
	}
	
	
	protected void do_btnCpNhtTng_actionPerformed(ActionEvent e) {
		DoiTuong_CungCap cc = new DoiTuong_CungCap();
		cc.setMst(mstText.getText());
		cc.setMachinhanh(mcnText.getText());
		cc.setMasp(mspText.getText());
		
		
		if(LostUpdate_3.capnhat_gia(cc,giaText.getText(),false,false)) {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 0);
			loadData("CUNGCAP", nameColumn_CungCap, table);
		}
		else {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật không thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 3);
		}
	}
	protected void do_btnCpNhtHng_1_actionPerformed(ActionEvent e) {
		DoiTuong_CungCap cc = new DoiTuong_CungCap();
		cc.setMst(mstText.getText());
		cc.setMachinhanh(mcnText.getText());
		cc.setMasp(mspText.getText());
		
		
		if(LostUpdate_3.capnhat_gia(cc,giaText.getText(),true,false)) {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 0);
			loadData("CUNGCAP", nameColumn_CungCap, table);
		}
		else {
			JOptionPane.showConfirmDialog(contentPane, "Cập nhật không thành công", "Cập nhật", JOptionPane.CLOSED_OPTION, 3);
		}
	}
}
