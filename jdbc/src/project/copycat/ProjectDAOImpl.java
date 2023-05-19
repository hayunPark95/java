package project.copycat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProjectDAOImpl extends DAO implements ProjectDAOInterface {
	private static ProjectDAOImpl _dao;
	
	private ProjectDAOImpl() {
	}
	
	static {
		_dao=new ProjectDAOImpl();
	}
	
	public static ProjectDAOImpl getDAO() {
		return _dao;
	}
	
	@Override
	public int insertProject(ProjectDTO project) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into idol values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, project.getName());
			pstmt.setString(2, project.getGender());
			pstmt.setString(3, project.getMem());
			pstmt.setString(4, project.getSong());
			pstmt.setString(5, project.getAgency());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertIdol() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	@Override
	public int updateProject(ProjectDTO project) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update idol set gender=?,mem=?,song=?,agency=?, where name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, project.getGender());
			pstmt.setString(2, project.getMem());
			pstmt.setString(3, project.getSong());
			pstmt.setString(4, project.getAgency());
			pstmt.setString(5, project.getName());

			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateIdol() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
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
			
			String sql="delete from idol where name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);

			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteIdol() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	@Override
	public ProjectDTO selectProject(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProjectDTO project=null;
		try {
			con=getConnection();
			
			String sql="select * from idol where name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//검색행이 있는 경우
				project=new ProjectDTO();
				//처리행의 컬럼값을 반환받아 DTO 객체의 필드값으로 변경
				project.setName(rs.getString("name"));
				project.setGender(rs.getString("gender"));
				project.setMem(rs.getString("mem"));
				project.setSong(rs.getString("song"));
				project.setAgency(rs.getString("agency"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectIdol() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		//검색행이 없는 경우 [null]를 반환하고 검색행이 있으면 DTO 객체 반환
		return project;
	}

	@Override
	public List<ProjectDTO> selectNameProjectList(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProjectDTO> projectList=new ArrayList<>();
		try {
			con=getConnection();
			
			String sql="select * from project where name=? order by name";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			//검색행이 0개 이상인 경우 반복문 사용
			while(rs.next()) {
				//하나의 검색행을 DTO 객체로 매핑 처리
				ProjectDTO project=new ProjectDTO();
				project.setName(rs.getString("name"));
				project.setGender(rs.getString("gender"));
				project.setMem(rs.getString("mem"));
				project.setSong(rs.getString("song"));
				project.setAgency(rs.getString("agency"));
				
				//DTO 객체를 List 객체의 요소로 추가 
				projectList.add(project);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNameProjectList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return projectList;
	}


	@Override
	public List<ProjectDTO> selectAllProjectList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProjectDTO> projectList=new ArrayList<>();
		try {
			con=getConnection();
			
			String sql="select * from idol order by name";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ProjectDTO project=new ProjectDTO();
				project.setName(rs.getString("name"));
				project.setGender(rs.getString("gender"));
				project.setMem(rs.getString("mem"));
				project.setSong(rs.getString("song"));
				project.setAgency(rs.getString("agency"));
				
				projectList.add(project);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllIdolList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return projectList;
	}
}