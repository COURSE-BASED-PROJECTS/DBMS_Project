package KetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoi {
	private Connection connection = null;
	private int numberColumn=0;
	
	public KetNoi(String taikhoan, String matkhau)  {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String ConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLCH"
					+ ";username="+taikhoan+";password="+matkhau;
			
			try {
				this.connection = DriverManager.getConnection(ConnectionUrl);
				System.out.println("Ket noi thanh cong vao sql!");
				
			} catch (SQLException e) {
				System.out.println("Ket noi that bai vao sql!");
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Ket noi that bai vao sql!");
			e.printStackTrace();
		}
		
	}
	
	public KetNoi()  {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String ConnectionUrl = "jdbc:sqlserver://localhost;databaseName=QLCH;integratedSecurity=true;";
			
			try {
				this.connection = DriverManager.getConnection(ConnectionUrl);
				System.out.println("Ket noi thanh cong vao sql!");
				
			} catch (SQLException e) {
				System.out.println("Ket noi that bai vao sql!");
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Ket noi that bai vao sql!");
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public int getNumberColumn() {
		return numberColumn;
	}
	
	public ResultSet getResultSet(String query) {
		Statement stmt;
		ResultSet rs = null;
		
		
		try {
			stmt = this.connection.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData metaData = rs.getMetaData();
		
			this.numberColumn = metaData.getColumnCount();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	
		return rs;
	}
	
	public void Disconnect() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
