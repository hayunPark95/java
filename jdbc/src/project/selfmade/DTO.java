package project.selfmade;

public class DTO {
	private String name;
	private String gender;
	private String mem;
	private String song;
	private String agency;
	
	public DTO() {
		// TODO Auto-generated constructor stub
	}

	public DTO(String name, String gender, String mem, String song, String agency) {
		super();
		this.name = name;
		this.gender = gender;
		this.mem = mem;
		this.song = song;
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

	public String getMem() {
		return mem;
	}

	public void setMem(String mem) {
		this.mem = mem;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}
	@Override
	public String toString() {
		return name+"\t"+gender+"\t"+mem+"\t"+song+"\t"+agency;
	}
}
