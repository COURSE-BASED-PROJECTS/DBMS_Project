package TranhChap.Unrepeatable;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DoiTuong.DoiTuong_CungCap;
import KetNoi.KetNoi;

public class Unrepeatable_2 {
	private static String nameColumn_SanPham[]= {"MASP","TENSP"};
	
	public static boolean capnhat_tensanpham(String msp, String tencu, String tenmoi, boolean fix) {
		KetNoi kn = new KetNoi();
		boolean result = false;
		String sql = "";
		
		if(!fix)
			sql = "EXEC USP_DOITENSP ?,N'"+tencu+"',N'"+tenmoi+"'";
		else {
			sql = "EXEC USP_DOITENSP_FIX ?,N'"+tencu+"',N'"+tenmoi+"'";
		}
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, msp);
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public static DefaultTableModel vantin_tensanpham(DefaultTableModel tabelModel,String ten, boolean fix) {
		KetNoi kn = new KetNoi();
		String sql="";
		
		if(!fix)
			sql="EXEC USP_TRUYVANSP "+"N'"+ten+"'";
		else {
			sql="EXEC USP_TRUYVANSP_FIX "+"N'"+ten+"'";
		}
		
		try {
			Connection con = kn.getConnection();
			ResultSet rs = null;
			int numberColumn = 0;
			
			try {
				rs = kn.getResultSet(sql);
				numberColumn = rs.getMetaData().getColumnCount();
			} catch (Exception e) {
				return initialRow(nameColumn_SanPham);
			}
		
			
			while (rs.next()) {
				Vector<String> row = new Vector<String>();

				for (int i = 1; i <= numberColumn; i++) {
					row.addElement(rs.getString(i));
				}
				tabelModel.addRow(row);
			}
		} catch (SQLException e1) {
			System.out.println("Lỗi trong khi load dữ liệu từ bảng SANPHAM");
			e1.printStackTrace();
		}
		return tabelModel;
	}
	private static DefaultTableModel initialRow(String nameColumn[]) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
		for (String name : nameColumn) {
			defaultTableModel.addColumn(name);
		}
		
		return defaultTableModel;
	}
	
	
}
