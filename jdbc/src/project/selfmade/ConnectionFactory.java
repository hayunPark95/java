package project.selfmade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracldDriver");
			
			String url="jdbc:oracle:thin:@www.itwill.xyz:1521:xe";
			String user="jdbc_team10";
			String password="jdbc_team10";
			con=DriverManager.getConnection(url,user,password);
			
		} catch(Exception e) {
			System.out.println("[에러]Connection 객체를 생성할 수 없습니다");
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if(con!=null)con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement stmt) {
		try {
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
