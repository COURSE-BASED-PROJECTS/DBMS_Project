package DoiTuong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import KetNoi.KetNoi;

public class DoiTuong_SanPham {
	private String masp;
	private String tensp;
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	
	public boolean themSanPham(DoiTuong_SanPham sp, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "INSERT INTO SANPHAM(MASP,TENSP) VALUES(?,?)";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, sp.getMasp());
			stmt.setString(2, sp.getTensp());
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public boolean xoaSanPham(DoiTuong_SanPham sp, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "DELETE FROM SANPHAM WHERE MASP=?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, sp.getMasp());
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public boolean suaSanPham(DoiTuong_SanPham sp, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "UPDATE SANPHAM MASP=?, TENSP=? "
				+ "WHERE MASP=?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, sp.getMasp());
			stmt.setString(2, sp.getTensp());
			stmt.setString(3, this.getMasp());
			
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
