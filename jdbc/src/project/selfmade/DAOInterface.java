package project.selfmade;

import java.util.List;

public interface DAOInterface {
	int insertProject(DTO project);
	int updateProject(DTO project);
	int deleteProject(String name);
	DTO selectProject(String name);
	
	List<DTO> selectNameList(String name);
	List<DTO> selectAllList();
}
