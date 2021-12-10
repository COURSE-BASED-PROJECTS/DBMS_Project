package DoiTuong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import KetNoi.KetNoi;

public class DoiTuong_CungCap {
	private String mst;
	private String machinhanh;
	private String masp;
	private String giasp;
	public String getMst() {
		return mst;
	}
	public void setMst(String mst) {
		this.mst = mst;
	}
	public String getMachinhanh() {
		return machinhanh;
	}
	public void setMachinhanh(String machinhanh) {
		this.machinhanh = machinhanh;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getGiasp() {
		return giasp;
	}
	public void setGiasp(String giasp) {
		this.giasp = giasp;
	}
	
	public boolean themCungCap(DoiTuong_CungCap cc, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "INSERT INTO CUNGCAP(MST,MACHINHANH,MASP,GIASP) VALUES(?,?,?,?)";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, cc.getMst());
			stmt.setString(2, cc.getMachinhanh());
			stmt.setString(3, cc.getMasp());
			stmt.setString(4, cc.getGiasp());
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public boolean xoaCungCap(DoiTuong_CungCap cc, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "DELETE FROM CUNGCAP WHERE MST=? AND MACHINHANH=? AND MASP=?";
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
	
	public boolean suaCungCap(DoiTuong_CungCap cungcap_nhap,DoiTuong_CungCap cungcap_sua, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "UPDATE CUNGCAP SET MST=?, MACHINHANH=?, MASP=?, GIASP=? "
				+ "WHERE MST=? AND MACHINHANH=? AND MASP=?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, cungcap_sua.getMst());
			stmt.setString(2, cungcap_sua.getMachinhanh());
			stmt.setString(3, cungcap_sua.getMasp());
			stmt.setString(4, cungcap_sua.getGiasp());
			
			stmt.setString(5, cungcap_nhap.getMst());
			stmt.setString(6, cungcap_nhap.getMachinhanh());
			stmt.setString(7, cungcap_nhap.getMasp());
			
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
