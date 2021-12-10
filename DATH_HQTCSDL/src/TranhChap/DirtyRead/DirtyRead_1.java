package TranhChap.DirtyRead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DoiTuong.DoiTuong_CungCap;
import KetNoi.KetNoi;

public class DirtyRead_1 {
	public static boolean capnhat_cungcap(DoiTuong_CungCap cc) {
		KetNoi kn = new KetNoi();
		boolean result = false;
		String sql = "EXEC USP_CAPNHATGIASP ?,?,?,"+cc.getGiasp();
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, cc.getMst());
			stmt.setString(2, cc.getMachinhanh());
			stmt.setString(3, cc.getMasp());
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public static DefaultTableModel vantin_cungcap_khongfix(DefaultTableModel tabelModel,String masp, boolean fix) {
		KetNoi kn = new KetNoi();
		String sql="";
		
		if(!fix)
			sql="EXEC USP_VANTINSP '"+masp+"'";
		else {
			sql="EXEC USP_VANTINSP_FIX '"+masp+"'";
		}
		
		try {
			Connection con = kn.getConnection();
			ResultSet rs = kn.getResultSet(sql);
			int numberColumn = rs.getMetaData().getColumnCount();

			while (rs.next()) {
				Vector<String> row = new Vector<String>();

				for (int i = 1; i <= numberColumn; i++) {
					row.addElement(rs.getString(i));
				}
				tabelModel.addRow(row);
			}
		} catch (SQLException e1) {
			System.out.println("Lỗi trong khi load dữ liệu từ bảng CUNGCAP");
			e1.printStackTrace();
		}
		return tabelModel;
	}
	
	
}
