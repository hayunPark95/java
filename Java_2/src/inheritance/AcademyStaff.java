package inheritance;

public class AcademyStaff extends AcademyPerson{
	private String depart;
	
	public AcademyStaff() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStaff(int num, String name, String depart) {
		super(num, name);
		this.depart = depart;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("직원번호 = "+getNum());
		System.out.println("직원이름 = "+getName());
		System.out.println("근무부서 = "+depart);
	}
}
