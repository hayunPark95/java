package project;

public class ProjectDTO {
	private String mem;
	private String agency;
	private String name;
	private String gender;
	private String song;
	
	public ProjectDTO() {
	}

	public ProjectDTO(String mem, String agency, String name, String gender, String song) {
		super();
		this.mem = mem;
		this.agency = agency;
		this.name = name;
		this.gender = gender;
		this.song = song;
	}

	public String getMem() {
		return mem;
	}

	public void setMem(String mem) {
		this.mem = mem;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}
	@Override
	public String toString() {
		return name+"\t"+gender+"\t"+mem+"\t"+song+"\t"+agency;
	}
}
