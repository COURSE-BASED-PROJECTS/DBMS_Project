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

public class Unrepeatable_3 {
	
	public static boolean capnhat_taikhoan(String taikhoan, String mkmoi, boolean fix) {
		KetNoi kn = new KetNoi();
		boolean result = false;
		String sql = "";
		
		if(!fix)
			sql = "EXEC USP_DOIMATKHAU N'"+taikhoan+"',N'"+mkmoi+"'";
		else {
			sql = "EXEC USP_DOIMATKHAU_FIX N'"+taikhoan+"',N'"+mkmoi+"'";
		}
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
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
