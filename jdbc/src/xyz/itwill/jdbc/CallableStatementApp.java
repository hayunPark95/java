package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementApp {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 삭제>>");
		
		System.out.print("학번입력>>");
		int no = Integer.parseInt(in.readLine());
		System.out.println("===========================================================================");
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "{call delete_STUDENT(?,?)}";
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, no);
		
		cstmt.registerOutParameter(2, Types.NVARCHAR);
		
		cstmt.execute();
		
		String name = cstmt.getString(2);
		
		if(name == null) {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다");
		} else {
			System.out.println("[메세지]"+name+"님을 삭제처리 하였습니다");
		}
		ConnectionFactory.close(con, cstmt);
	}
}
