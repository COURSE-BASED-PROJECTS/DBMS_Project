package TranhChap.LostUpdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DoiTuong.DoiTuong_CungCap;
import DoiTuong.DoiTuong_HopDong;
import KetNoi.KetNoi;

public class LostUpdate_2 {
	public static boolean capnhat_nguoidaidien(String mst,String ten, boolean fix) {
		KetNoi kn = new KetNoi();
		boolean result = false;
		
		
		String sql = "";
		
		if(!fix)
			sql = "EXEC USP_CAPNHATNGUOIDAIDIEN ?,N'"+ten+"'";
		else {
			sql = "EXEC USP_CAPNHATNGUOIDAIDIEN_FIX ?,N'"+ten+"'";
		}
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1,mst);
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	
	
	
}
