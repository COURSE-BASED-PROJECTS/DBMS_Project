package DoiTuong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import KetNoi.KetNoi;

public class DoiTuong_HopDong {
	private String mst;
	private String nguoidaidien;
	private String mahd;
	private String tghieuluc;
	private String phihoahong;
	private String kichhoat;
	public String getMst() {
		return mst;
	}
	public void setMst(String mst) {
		this.mst = mst;
	}
	public String getNguoidaidien() {
		return nguoidaidien;
	}
	public void setNguoidaidien(String nguoidaidien) {
		this.nguoidaidien = nguoidaidien;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getTghieuluc() {
		return tghieuluc;
	}
	public void setTghieuluc(String tghieuluc) {
		this.tghieuluc = tghieuluc;
	}
	public String getPhihoahong() {
		return phihoahong;
	}
	public void setPhihoahong(String phihoahong) {
		this.phihoahong = phihoahong;
	}
	public String getKichhoat() {
		return kichhoat;
	}
	public void setKichhoat(String kichhoat) {
		this.kichhoat = kichhoat;
	}
	
	
	
	public boolean suaHopDong(DoiTuong_HopDong hopdong_nhap,DoiTuong_HopDong hopdong_sua, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "UPDATE HOPDONG SET THGIANIEULUC=?, PHIHOAHONG=?, KICHHOAT=? "
				+ "WHERE MST=? AND NGUOIDAIDIEN=? AND MAHD=?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, hopdong_sua.getTghieuluc());
			stmt.setString(2, hopdong_sua.getPhihoahong());
			stmt.setString(3, hopdong_sua.getKichhoat());

			
			stmt.setString(5, hopdong_nhap.getMst());
			stmt.setString(6, hopdong_nhap.getNguoidaidien());
			stmt.setString(7, hopdong_nhap.getMahd());
			
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
