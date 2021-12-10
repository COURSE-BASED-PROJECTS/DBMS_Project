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

public class Unrepeatable_1 {
	private static String nameColumn_HOPDONG[]= {"MST", "NGUOIDAIDIEN", "MAHD", "THGIANBATDAU","THGIANHIEULUC", 
			"PHIHOAHONG","SOCHINHANHDK", "KICHHOAT"};
	
	public static boolean capnhat_hethan(String mhd, String tgcu, String tgmoi, boolean fix) {
		KetNoi kn = new KetNoi();
		boolean result = false;
		String sql = "";
		
		if(!fix)
			sql = "EXEC USP_GIAHANHD ?,?,?";
		else {
			sql = "EXEC USP_GIAHANHD_FIX ?,?,?";
		}
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, mhd);
			stmt.setString(2, tgcu);
			stmt.setString(3, tgmoi);
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public static DefaultTableModel vantin_hopdong(DefaultTableModel tabelModel,String mst, String ngayhethan, boolean fix) {
		KetNoi kn = new KetNoi();
		String sql="";
		
		if(!fix)
			sql="EXEC USP_TRUYVANHD "+"'"+mst+"','"+ngayhethan+"'";
		else {
			sql="EXEC USP_TRUYVANHD_FIX "+"'"+mst+"','"+ngayhethan+"'";
		}
		
		try {
			Connection con = kn.getConnection();
			ResultSet rs = null;
			int numberColumn = 0;
			
			try {
				rs = kn.getResultSet(sql);
				numberColumn = rs.getMetaData().getColumnCount();
			} catch (Exception e) {
				return initialRow(nameColumn_HOPDONG);
			}
		
			
			while (rs.next()) {
				Vector<String> row = new Vector<String>();

				for (int i = 1; i <= numberColumn; i++) {
					row.addElement(rs.getString(i));
				}
				tabelModel.addRow(row);
			}
		} catch (SQLException e1) {
			System.out.println("Lỗi trong khi load dữ liệu từ bảng HOPDONG");
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
