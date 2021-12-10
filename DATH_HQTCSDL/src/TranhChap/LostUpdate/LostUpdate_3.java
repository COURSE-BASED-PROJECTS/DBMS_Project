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

public class LostUpdate_3 {
	public static boolean capnhat_gia(DoiTuong_CungCap cc,String gia, boolean fix, boolean khuyenmai) {
		KetNoi kn = new KetNoi();
		boolean result = false;
		
		
		String sql = "";
		
		if(!fix)
			if(khuyenmai)
				sql = "EXEC USP_KHUYENMAI ?,?,?,"+gia;
			else {
				sql = "EXEC USP_TANGGIA ?,?,?,"+gia;
			}
		else {
			if(khuyenmai)
				sql = "EXEC USP_KHUYENMAI_FIX ?,?,?,"+gia;
			else {
				sql = "EXEC USP_TANGGIA_FIX ?,?,?,"+gia;
			}
		}
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
	
	
	
	
}
