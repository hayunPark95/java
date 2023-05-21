package project.selfmade;

public class DTO2 {
	private String agency;
	private String ename;
	
	public DTO2() {
		// TODO Auto-generated constructor stub
	}

	public DTO2(String agency, String ename) {
		super();
		this.agency = agency;
		this.ename = ename;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Override
	public String toString() {
		return agency+"\t"+ename;
	}
}
