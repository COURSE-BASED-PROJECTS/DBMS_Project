package DoiTuong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import KetNoi.KetNoi;

public class DoiTuong_QuanTri {
	private String taikhoan;
	private String matkhau;
	private String phanhe;
	private String tinhtrang;
	
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getPhanhe() {
		return phanhe;
	}
	public void setPhanhe(String phanhe) {
		this.phanhe = phanhe;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	public boolean themTaiKhoan(DoiTuong_QuanTri tk, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "INSERT INTO NGUOIDUNG(TAIKHOAN,MATKHAU,PHANHE,TINHTRANG) VALUES(?,?,?,?)";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, tk.getTaikhoan());
			stmt.setString(2, tk.getMatkhau());
			stmt.setString(3, tk.getPhanhe());
			stmt.setString(4, tk.getTinhtrang());
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public boolean xoaTaiKhoan(DoiTuong_QuanTri tk, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "DELETE FROM NGUOIDUNG WHERE TAIKHOAN=?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, tk.getTaikhoan());
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public boolean suaTaiKhoan(DoiTuong_QuanTri tk, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "UPDATE NGUOIDUNG SET TAIKHOAN=?, MATKHAU=?, PHANHE=?, TINHTRANG=? "
				+ "WHERE TAIKHOAN=?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, tk.getTaikhoan());
			stmt.setString(2, tk.getMatkhau());
			stmt.setString(3, tk.getPhanhe());
			stmt.setString(4, tk.getTinhtrang());
			stmt.setString(5, tk.getTaikhoan());
			
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
