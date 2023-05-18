package project;

import java.util.List;

public interface ProjectDAOInterface {
	int insertProject(ProjectDTO project);
	int updateProject(ProjectDTO project);
	int deleteProject(String name);
	
	ProjectDTO selectProject(String name);
	
	List<ProjectDTO> selectNameProjectList(String name);
	
	List<ProjectDTO> selectAllProjectList();
}
