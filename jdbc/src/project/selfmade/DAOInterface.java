package project.selfmade;

import java.util.List;

public interface DAOInterface {
	String insertProject(DTO project);
	String updateProject(DTO project);
	String deleteProject(String name);
	DTO selectProject(String name);
	
	List<DTO> selectGenderList(String gender);
	List<DTO> selectAllList();
}
