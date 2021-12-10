package TranhChap.PhantomRead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DoiTuong.DoiTuong_ChiNhanh;
import DoiTuong.DoiTuong_CungCap;
import DoiTuong.DoiTuong_DoiTac;
import KetNoi.KetNoi;

public class PhantomRead_3 {
	public static boolean them_chinhanh(DoiTuong_ChiNhanh cn) {
		KetNoi kn = new KetNoi();
		boolean result = false;
		String sql = "EXEC USP_THEMCHINHANH ?,?,?";
		Connection cnn = kn.getConnection();
		
		try {
			PreparedStatement stmt = cnn.prepareStatement(sql);
			
			stmt.setString(1, cn.getMst());
			stmt.setString(2, cn.getMachinhanh());
			stmt.setString(3, cn.getDiachi());
			
			result = stmt.executeUpdate()>0;
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kn.Disconnect();
		
		return result;
	}
	
	public static DefaultTableModel vantin_chinhanh(DefaultTableModel tabelModel, String mst,boolean fix) {
		KetNoi kn = new KetNoi();
		String sql="";
		
		if(!fix)
			sql="EXEC USP_LayDSCN '"+mst+"'";
		else {
			sql="EXEC USP_LayDSCN_FIX '"+mst+"'";
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
			System.out.println("Lỗi trong khi load dữ liệu từ bảng CHINHANH");
			e1.printStackTrace();
		}
		return tabelModel;
	}
	
	public static String soluong_cn(String mst) {
		
		KetNoi kn = new KetNoi();
		String sql="SELECT COUNT(*) FROM CHINHANH WHERE MST='"+mst+"'";
		
		try {
			Connection con = kn.getConnection();
			ResultSet rs = kn.getResultSet(sql);
//			int numberColumn = rs.getMetaData().getColumnCount();

			if(rs.next()) {
				return rs.getString(1);
			}
			
			return "0";
			
		} catch (SQLException e1) {
			System.out.println("Lỗi trong khi load dữ liệu từ bảng CHINHANH");
			e1.printStackTrace();
		}
		
		return "0";
	}
	
	
}
