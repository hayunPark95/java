package project.selfmade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOClass extends Jdbc implements DAOInterface {
	private static DAOClass _dao;
	
	private DAOClass() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new DAOClass();
	}
	
	public static DAOClass getDao() {
		return _dao;
	}	
	@Override
	public int insertProject(DTO project) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="INSERT INTO PROJECT VALUES(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, project.getName());		
			pstmt.setString(2, project.getGender());		
			pstmt.setString(3, project.getMem());		
			pstmt.setString(4, project.getMname());		
			pstmt.setString(5, project.getSong());	
			pstmt.setString(6, project.getAgency());	
			
			rows=pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[에러] 삽입과정에서의 SQL 오류 >>"+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	@Override
	public int updateProject(DTO project) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="UPDATE PROJECT SET GENDER=?,MEM=?,MNAME=?,SONG=?,AGENCY=? WHERE NAME=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, project.getName());		
			pstmt.setString(2, project.getGender());		
			pstmt.setString(3, project.getMem());		
			pstmt.setString(4, project.getMname());		
			pstmt.setString(5, project.getSong());	
			pstmt.setString(6, project.getAgency());

			
			rows=pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[에러] 업데이트 과정에서의 SQL 오류 >>"+e.getMessage());
		} finally {
			close(con,pstmt);
		}
		return rows;
	}
	@Override
	public int deleteProject(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="DELETE FROM PROJECT WHERE NAME=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rows=pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("[에러] 삭제 과정에서의 SQL 오류 >>"+e.getMessage());
		} finally {
			close(con,pstmt);
		}
		return rows;
	}
	@Override	
	public DTO selectProject(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DTO project=null;
		
		try {
			con=getConnection();
			String sql="SELECT * FROM PROJECT WHERE NAME=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				project=new DTO();
				project.setName(rs.getString("name"));
				project.setGender(rs.getString("gender"));
				project.setMem(rs.getString("mem"));
				project.setMname(rs.getString("mname"));
				project.setSong(rs.getString("song"));
				project.setAgency(rs.getString("agency"));
			}
		} catch(SQLException e) {
			System.out.println("[에러] 검색 과정에서의 SQL 오류 >>"+e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return project;
	}

	@Override
	public List<DTO> selectAllProjectList(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<DTO> projectList=new ArrayList<DTO>();
		
		try {
			con=getConnection();
			String sql="SELECT * FROM PROJECT ORDER BY NAME";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				DTO project=new DTO();
				project.setName(rs.getString("name"));
				project.setGender(rs.getString("gender"));
				project.setMem(rs.getString("mem"));
				project.setMname(rs.getString("mname"));
				project.setSong(rs.getString("song"));
				project.setAgency(rs.getString("agency"));
				
				projectList.add(project);
			}
		} catch(SQLException e) {
			System.out.println("[에러] 모두 검색하기 과정에서의 SQL 오류 >>"+e.getMessage());			
		} finally {
			close(con, pstmt, rs);
		}
		return projectList;
	}
	
	@Override
	public List<DTO> selectAllProjectListOrderByRandom(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<DTO> projectList=new ArrayList<DTO>();
		
		try {
			con=getConnection();
			String sql="SELECT * FROM (SELECT * FROM PROJECT ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM <=1";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				DTO project=new DTO();
				project.setName(rs.getString("name"));
				project.setGender(rs.getString("gender"));
				project.setMem(rs.getString("mem"));
				project.setMname(rs.getString("mname"));
				project.setSong(rs.getString("song"));
				project.setAgency(rs.getString("agency"));
				
				projectList.add(project);
			}
		} catch(SQLException e) {
			System.out.println("[에러] 모두 검색하기 과정에서의 SQL 오류 >>"+e.getMessage());			
		} finally {
			close(con, pstmt, rs);
		}
		return projectList;
	}
}