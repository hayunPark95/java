package project.selfmade;

import java.util.List;

public interface DAOInterface2 {
	DTO2 selectAgencyProject(String name);
	
	List<DTO2> selectAllAgencyProjectList();
}
