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

public class LostUpdate_1 {
	public static boolean capnhat_phihoahong(DoiTuong_HopDong hd, boolean fix, boolean thang) {
		KetNoi kn = new KetNoi();
		boolean result = false;
		
		
		String sql = "";
		
		if(!fix)
			if(thang)
				sql = "EXEC USP_PHIHH_HANGTHANG ?,?,"+hd.getPhihoahong();
			else {
				sql = "EXEC USP_PHIHH_HANGNAM ?,?,"+hd.getPhihoahong();
			}
		else {
			if(thang) {
				sql = "EXEC USP_PHIHH_HANGTHANG_FIX ?,?,"+hd.getPhihoahong();
				System.out.println("hang thang");
			}
			else {
				sql = "EXEC USP_PHIHH_HANGNAM_FIX ?,?,"+hd.getPhihoahong();
				System.out.println("hang nam");
			}
		}
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, hd.getMst());
			stmt.setString(2, hd.getMahd());
			
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
