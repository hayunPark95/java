package project.selfmade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOClass extends Jdbc implements DAOInterface,DAOInterface2 {
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
			
			String sql="INSERT INTO PROJECT VALUES(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, project.getName());		
			pstmt.setString(2, project.getGender());		
			pstmt.setString(3, project.getMem());		
			pstmt.setString(4, project.getSong());	
			pstmt.setString(5, project.getAgency());	
			
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
			
			String sql="UPDATE PROJECT SET GENDER=?,MEM=?,SONG=?,AGENCY=? WHERE NAME=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, project.getGender());
			pstmt.setString(2, project.getMem());
			pstmt.setString(3, project.getSong());
			pstmt.setString(4, project.getAgency());
			pstmt.setString(5, project.getName());
			
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
				project.setName(rs.getString("Name"));
				project.setGender(rs.getString("Gender"));
				project.setMem(rs.getString("Mem"));
				project.setSong(rs.getString("Song"));
				project.setAgency(rs.getString("Agency"));
			}
		} catch(SQLException e) {
			System.out.println("[에러] 검색 과정에서의 SQL 오류 >>"+e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return project;
	}
	@Override	
	public DTO2 selectAgencyProject(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DTO2 project=null;
		
		try {
			con=getConnection();
			String sql="SELECT ENAME FROM PROJECT3 INNER JOIN PROJECT ON PROJECT3.AGENCY=PROJECT.AGENCY WHERE NAME=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				project=new DTO2();
			}
		} catch(SQLException e) {
			System.out.println("[에러] SQL 오류 >>"+e.getMessage());
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
	public List<DTO2> selectAllAgencyProjectList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<DTO2> projectList2=new ArrayList<DTO2>();	
		
		try {
			con=getConnection();
			String sql="SELECT * FROM PROJECT3 ORDER BY AGENCY";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DTO2 project=new DTO2();
				project.setAgency(rs.getString("agency"));
				project.setEname(rs.getString("ename"));
				
				projectList2.add(project);
			}
		} catch(SQLException e) {
			System.out.println("[에러] 소속사 검색 과정에서의 SQL 오류 >>"+e.getMessage());			
		} finally {
			close(con, pstmt, rs);
		}
		return projectList2;
	}
}