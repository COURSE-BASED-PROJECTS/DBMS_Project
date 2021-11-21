package DoiTuong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import KetNoi.KetNoi;

public class DoiTuong_ChiNhanh {
	private String mst;
	private String machinhanh;
	private String nguoidaidien;
	private String diachi;
	
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
	public String getNguoidaidien() {
		return nguoidaidien;
	}
	public void setNguoidaidien(String nguoidaidien) {
		this.nguoidaidien = nguoidaidien;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	public boolean themChiNhanh(DoiTuong_ChiNhanh cn, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "INSERT INTO CHINHANH(MST,NGUOIDAIDIEN,MACHINHANH,DIACHI) VALUES(?,?,?,?)";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, cn.getMst());
			stmt.setString(2, cn.getNguoidaidien());
			stmt.setString(3, cn.getMachinhanh());
			stmt.setString(4, cn.getDiachi());
			
			result = stmt.executeUpdate() > 0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public boolean xoaChiNhanh(DoiTuong_ChiNhanh cn, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result =false;
		String sql = "DELETE FROM CHINHANH WHERE MST=? AND MACHINHANH=?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, cn.getMst());
			stmt.setString(2, cn.getMachinhanh());
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public boolean suaChiNhanh(DoiTuong_ChiNhanh cn, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi(taikhoan, matkhau);
		boolean result = false;
		String sql = "UPDATE CHINHANH SET MST=?, NGUOIDAIDIEN=?, MACHINHANH=?, DIACHI=? "
				+ "WHERE MST=? AND MACHINHANH=?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, this.getMst());
			stmt.setString(2, this.getNguoidaidien());
			stmt.setString(3, this.getMachinhanh());
			stmt.setString(4, this.getDiachi());
			
			stmt.setString(5, cn.getMst());
			stmt.setString(6, cn.getMachinhanh());
			
			
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
