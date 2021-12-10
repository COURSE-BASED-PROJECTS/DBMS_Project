package DoiTuong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public void themLogin(DoiTuong_QuanTri tk, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi();
		String sql_1 = "EXEC sp_addLogin '"+tk.getTaikhoan()+"','"+tk.getMatkhau()+"','QLCH'";
		String sql_2 = "CREATE USER "+tk.getTaikhoan()+" FOR LOGIN "+tk.getTaikhoan();
		String sql_3 = "ALTER ROLE "+tk.getPhanhe()+"_ROLE" + " ADD member "+tk.getTaikhoan();
		Connection cnn = kn.getConnection();
		
		try {
			Statement stmt = cnn.createStatement();
			
			stmt.executeUpdate(sql_1);
			stmt.executeUpdate(sql_2);
			stmt.executeUpdate(sql_3);
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
	}
	
	public void xoaLogin(DoiTuong_QuanTri tk, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi();
		String sql_0 = "USE [master]; "
				+ "DECLARE @kill varchar(8000) = '';  "
				+ "SELECT @kill = @kill + 'kill ' + CONVERT(varchar(5), session_id) + ';'  "
				+ "FROM sys.dm_exec_sessions "
				+ "WHERE database_id  = db_id('MyDB') "
				+ "EXEC(@kill);";
		String sql_1 = "DROP USER "+tk.getTaikhoan();
		String sql_2 = "DROP LOGIN "+tk.getTaikhoan();
		Connection cnn = kn.getConnection();
		
		try {
			Statement stmt = cnn.createStatement();
			
			stmt.executeUpdate(sql_1);
			stmt.executeUpdate(sql_0);
			stmt.executeUpdate(sql_2);
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
	}
	
	public void suaLogin(DoiTuong_QuanTri tk, String taikhoan, String matkhau) {
		KetNoi kn = new KetNoi();
		String sql_1 = "DROP USER "+tk.getTaikhoan();
		String sql_2 = "CREATE USER "+tk.getTaikhoan()+" FOR LOGIN "+tk.getTaikhoan();
		String sql_3 = "ALTER ROLE "+tk.getPhanhe()+"_ROLE" + " ADD member "+tk.getTaikhoan();
		String sql_4 = "ALTER LOGIN "+tk.getTaikhoan() + 
				" WITH PASSWORD = '"+tk.getMatkhau()+"'";
		System.out.print(tk.getMatkhau()+ tk.getTaikhoan());
		
		Connection cnn = kn.getConnection();
		
		try {
			Statement stmt = cnn.createStatement();
			
			stmt.executeUpdate(sql_1);
			stmt.executeUpdate(sql_2);
			stmt.executeUpdate(sql_3);
			stmt.executeUpdate(sql_4);
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
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
			themLogin(tk,taikhoan,matkhau);
			
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
			xoaLogin(tk,taikhoan,matkhau);
			
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
			suaLogin(tk,taikhoan,matkhau);
			
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
}
