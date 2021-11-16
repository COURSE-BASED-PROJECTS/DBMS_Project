package DoiTuong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import KetNoi.KetNoi;

public class DoiTuong_DDH {
	private String maddh;
	private String tinhtrang;
	public String getMaddh() {
		return maddh;
	}
	public void setMaddh(String maddh) {
		this.maddh = maddh;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	public boolean suaDDH(DoiTuong_DDH ddh_nhap, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "UPDATE DONDH SET TINHTRANG=? "
				+ "WHERE MADDH=?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, ddh_nhap.getTinhtrang());
			stmt.setString(2, ddh_nhap.getMaddh());

			
			result = stmt.executeUpdate() > 0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
}
