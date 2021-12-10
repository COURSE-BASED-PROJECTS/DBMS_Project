package TranhChap.PhantomRead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DoiTuong.DoiTuong_CungCap;
import DoiTuong.DoiTuong_DoiTac;
import KetNoi.KetNoi;

public class PhantomRead_2 {
	public static boolean them_doitac(DoiTuong_DoiTac dt) {
		KetNoi kn = new KetNoi();
		boolean result = false;
		String sql = "EXEC USP_THEMDOITAC ?,?,?,'"+dt.getSlcn()+"',?,?,?,?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, dt.getMst());
			stmt.setString(2, dt.getNguoidaidien());
			stmt.setString(3, dt.getTendoitac());
			stmt.setString(4, dt.getLoaihang());
			stmt.setString(5, dt.getDiachi());
			stmt.setString(6, dt.getSdt());
			stmt.setString(7, dt.getEmail());
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public static DefaultTableModel vantin_doitac(DefaultTableModel tabelModel, boolean fix) {
		KetNoi kn = new KetNoi();
		String sql="";
		
		if(!fix)
			sql="EXEC USP_LayDSDT";
		else {
			sql="EXEC USP_LayDSDT_FIX";
		}
		
		try {
			Connection con = kn.getConnection();
			ResultSet rs = kn.getResultSet(sql);
			int numberColumn = rs.getMetaData().getColumnCount();

			while (rs.next()) {
				Vector<String> row = new Vector<String>();

				for (int i = 1; i <= numberColumn; i++) {
					row.addElement(rs.getString(i));
				}
				tabelModel.addRow(row);
			}
		} catch (SQLException e1) {
			System.out.println("Lỗi trong khi load dữ liệu từ bảng DOITAC");
			e1.printStackTrace();
		}
		return tabelModel;
	}
	
	public static String soluong_dt() {
		
		KetNoi kn = new KetNoi();
		String sql="SELECT COUNT(*) FROM DOITAC";
		
		try {
			Connection con = kn.getConnection();
			ResultSet rs = kn.getResultSet(sql);
//			int numberColumn = rs.getMetaData().getColumnCount();

			if(rs.next()) {
				return rs.getString(1);
			}
			
			return "0";
			
		} catch (SQLException e1) {
			System.out.println("Lỗi trong khi load dữ liệu từ bảng DOITAC");
			e1.printStackTrace();
		}
		
		return "0";
	}
	
	
}
