package project; 

/********************************************************
파    일   명 : StudentGUIApp.java
기         능 : 학생 관리 프로그램
*********************************************************/
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProjectGUIApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;

	JTextField nameTF, genderTF, memTF, songTF, agencyTF;
	JButton addB, deleteB, updateB, searchB, cancelB;

	//JTable : 테이블(표)를 제공하기 위한 컴퍼넌트
	JTable table;
	
	int cmd;
	/********************************************
	 * 생성자 정의
	 *********************************************/
	public ProjectGUIApp() throws Exception {
		setTitle("###아이돌 백과사전###");
		setSize(900, 500);

		//Dimension : 컴퍼넌트 크기를 저장하기 위한 객체
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));

		JPanel pname = new JPanel();
		pname.add(new JLabel("이름"));
		pname.add(nameTF = new JTextField(10));

		JPanel pgender = new JPanel();
		pgender.add(new JLabel("성별"));
		pgender.add(genderTF = new JTextField(10));
		
		JPanel pmem = new JPanel();
		pmem.add(new JLabel("멤버"));
		pmem.add(memTF = new JTextField(10));

		JPanel psong = new JPanel();
		psong.add(new JLabel("노래"));
		psong.add(songTF = new JTextField(10));

		JPanel pagency = new JPanel();
		pagency.add(new JLabel("소속사"));
		pagency.add(agencyTF = new JTextField(10));

		left.add(pname);
		left.add(pgender);
		left.add(pmem);
		left.add(psong);
		left.add(pagency);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5));

		bottom.add(addB = new JButton("삽  입"));
		addB.addActionListener(this);

		bottom.add(updateB = new JButton("변  경"));
		updateB.addActionListener(this);

		bottom.add(deleteB = new JButton("삭  제"));
		deleteB.addActionListener(this);

		bottom.add(searchB = new JButton("검  색"));
		searchB.addActionListener(this);
		
		bottom.add(cancelB = new JButton("초기화"));
		cancelB.addActionListener(this);

		Object[] title={"이름","성별","멤버","노래","소속사"};
		//DefaultTableModel : 테이블의 행과 열을 표현하기 위한 객체
		table=new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		JScrollPane sp=new JScrollPane(table);
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE;
		initialize();

		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력
		displayAllIdol();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//모든 JTextField 컴퍼넌트를 비활성화 처리하는 메소드
	public void initialize() {
		nameTF.setEditable(false);
		genderTF.setEditable(false);
		memTF.setEditable(false);
		songTF.setEditable(false);
		agencyTF.setEditable(false);
	}

	//이벤트에 따른 JTextField 컴퍼넌트의 활성화 상태 변경
	public void setEditable(int n) {
		switch (n) {
		case ADD:
			nameTF.setEditable(true);
			genderTF.setEditable(true);
			memTF.setEditable(true);
			songTF.setEditable(true);
			agencyTF.setEditable(true);
			break;
		case DELETE:
			nameTF.setEditable(true);
			break;
		case UPDATE:
			nameTF.setEditable(true);
			break;
		case UPDATE_CHANGE:
			nameTF.setEditable(true);
			genderTF.setEditable(true);
			memTF.setEditable(true);
			songTF.setEditable(true);
			agencyTF.setEditable(true);
			break;
		case SEARCH:
			nameTF.setEditable(true);
			break;
		case NONE:
			nameTF.setEditable(false);
			genderTF.setEditable(false);
			memTF.setEditable(false);
			songTF.setEditable(false);
			agencyTF.setEditable(false);
		}
	}

	//이벤트에 따른 JTextField 컴퍼넌트와 JButton 컴퍼넌트의 활성화 상태 변경
	public void setEnable(int n) {
		addB.setEnabled(false);
		deleteB.setEnabled(false);
		updateB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			setEditable(ADD);
			cmd = ADD;
			break;
		case DELETE:
			deleteB.setEnabled(true);
			setEditable(DELETE);
			cmd = DELETE;
			break;
		case UPDATE:
			updateB.setEnabled(true);
			setEditable(UPDATE);
			cmd = UPDATE;
			break;			
		case UPDATE_CHANGE:
			updateB.setEnabled(true);
			setEditable(UPDATE_CHANGE);
			cmd = UPDATE_CHANGE;
			break;			
		case SEARCH:
			searchB.setEnabled(true);
			setEditable(SEARCH);
			cmd = SEARCH;
			break;
		case NONE:
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}

	//JTextField 컴퍼넌트의 입력값 초기화
	public void clear() {
		nameTF.setText("");
		genderTF.setText("");
		memTF.setText("");
		songTF.setText("");
		agencyTF.setText("");
	}

	//모든 컴퍼넌트의 상태 초기화
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();		
	}

	public static void main(String args[]) throws Exception {
		new ProjectGUIApp();
	}
	
	public void actionPerformed(ActionEvent ev) {
		Component c = (Component) ev.getSource();
		try {
			if (c == addB) {
				if (cmd != ADD) {//첫번째 [삽입] 버튼을 누른 경우 - NONE 상태
					setEnable(ADD);//컴퍼넌트의 활성화 상태 변경 - ADD 상태 변경					
				} else {//두번째 [삽입] 버튼을 누른 경우 - ADD 상태
					//학생정보를 입력받아 STUDENT 테이블에 삽입하는 메소드 호출
					addIdol();
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {//첫번째 [변경] 버튼을 누른 경우 - NONE 상태
					setEnable(UPDATE);//입출력 컴퍼넌트의 활성화 상태 변경 - UPDATE 상태 변경		
				} else if (cmd != UPDATE_CHANGE) {//두번째 [변경] 버튼을 누른 경우	- UPDATE 상태
					searchNameProject();
				} else {//두번째 [변경] 버튼을 누른 경우 - UPDATE_CHANGE 상태		
					modifyIdol();
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) {//첫번째 [삭제] 버튼을 누른 경우 - NONE 상태
					setEnable(DELETE);//입출력 컴퍼넌트의 활성화 상태 변경 - DELETE 상태 변경		
				} else {//두번째 [삭제] 버튼을 누른 경우 - DELETE 상태
					removeIdol();
				}
			} else if (c == searchB) {
				if (cmd != SEARCH) {
					setEnable(SEARCH);//입출력 컴퍼넌트의 활성화 상태 변경 - SEARCH 상태 변경		
				} else {//두번째 [검색] 버튼을 누른 경우 - SEARCH 상태
					//입력된 이름으로 STUDENT 테이블에 저장된 해당 이름이 포함된 학생정보를 
					//검색하는 출력하는 메소드 호출
					searchNameProject();
				}
			} else if (c == cancelB) {
				displayAllIdol();
				initDisplay();
			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e);
		}		
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
	public void displayAllIdol() {
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 DAO 클래스의 메소드
		List<ProjectDTO> projectList=ProjectDAOImpl.getDAO().selectAllProjectList();

		if(projectList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 아이돌정보가 없습니다.");
			return;
		}
		
		//JTable.getModel() : JTable 컴퍼넌트의 행정보가 저장된 TableModel 객체를 반환하는 메소드
		// => DefaultTableModel 클래스로 명시적 객체 형변환 
		//DefaultTableModel 객체 : JTable 컴퍼넌트의 행과 열을 조작할 수 있는 메소드를 제공하는 객체 
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//JTable 컴퍼넌트 초기화 - 기존 출력행 삭제 처리
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);//JTable 컴퍼넌트의 첫번째 행을 제거
		}
		
		//List 객체의 요소(StudentDTO 객체)를 하나씩 제공받아 처리하는 반복문
		for(ProjectDTO project : projectList) {
			//Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
			Vector<Object> rowData=new Vector<>();
			//StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
			rowData.add(project.getName());
			rowData.add(project.getGender());
			rowData.add(project.getMem());
			rowData.add(project.getSong());
			rowData.add(project.getAgency());
		
			//JTable 컴퍼넌트에 행을 추가하여 출력
			model.addRow(rowData);
		}
	}
	
	//JTextField 컴퍼넌트로 입력된 학생정보를 제공받아 STUDENT 테이블에 삽입하고 
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
	// => 컴퍼넌트 초기화 및 NONE 상태 변경
	public void addIdol() {
		String nameTemp=nameTF.getText();//JTextField 컴퍼넌트의 입력값을 반환받아 저장
		if(nameTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			nameTF.requestFocus();//JTextField 컴퍼넌트에 입력촛점을 제공하는 메소드
			return;
		}
		
		String nameReg="^[가-힣]{1,8}$/";
		if(!Pattern.matches(nameReg, nameTemp)) {//정규표현식과 입력값의 입력패턴이 다른 경우
			JOptionPane.showMessageDialog(this, "제대로된 이름을 입력해 주세요.");
			nameTF.requestFocus();
			return;	
		}
		
		String name= nameTemp;//문자열을 정수값으로 변환하여 변수에 저장
		
		if(ProjectDAOImpl.getDAO().selectProject(name) != null) {
			JOptionPane.showMessageDialog(this, "이미 사용중인 이름을 입력 하였습니다.");
			nameTF.requestFocus();
			return;	
		}
		
		String gender=genderTF.getText();
		
		if(gender.equals("")) {
			JOptionPane.showMessageDialog(this, "성별을 반드시 기입해 주세요.");
			genderTF.requestFocus();
			return;	
		}
		
		String genderReg="^[남]||[녀]{1}$";
		if(!Pattern.matches(genderReg, gender)) {
			JOptionPane.showMessageDialog(this, "성별은 반드시 남 또는 녀로 입력해 주세요.");
			genderTF.requestFocus();
			return;
		}
		
		String mem=memTF.getText();
		
		if(mem.equals("")) {
			JOptionPane.showMessageDialog(this, "몇인조 그룹인지 반드시 입력해 주세요.");
			memTF.requestFocus();
			return;
		}
		
		String memReg="^[1-9]*$";
		if(!Pattern.matches(memReg, mem)) {
			JOptionPane.showMessageDialog(this, "명수를 정확히 입력해 주세요.");
			memTF.requestFocus();
			return;
		}
		
		String song=songTF.getText();
		
		if(song.equals("")) {
			JOptionPane.showMessageDialog(this, "노래를 반드시 입력해 주세요.");
			songTF.requestFocus();
			return;
		}
		
		String agency=agencyTF.getText();

		
		if(agency.equals("")) {
			JOptionPane.showMessageDialog(this, "소속사를 반드시 입력해 주세요.");
			agencyTF.requestFocus();
			return;
		}
		
		String agencyReg="[가-힣][A-z]{1,8}$/)";
		if(!Pattern.matches(agencyReg, agency)) {
			JOptionPane.showMessageDialog(this, "존재하는 소속사 형식에 맞게 입력해 주세요.");
			agencyTF.requestFocus();
			return;
		}
		
		ProjectDTO project=new ProjectDTO();
		project.setName(name);
		project.setGender(gender);
		project.setMem(mem);
		project.setSong(song);
		project.setAgency(agency);
		
		int rows=ProjectDAOImpl.getDAO().insertProject(project);
		
		JOptionPane.showMessageDialog(this, rows+"명의 아이돌정보를 삽입 하였습니다.");

		displayAllIdol();//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력
		initDisplay();//모든 컴퍼넌트 초기화
	}
	
	//JTextField 컴퍼넌트로 입력된 학번을 제공받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 
	//검색하여 JTextField 컴퍼넌트에 출력하는 메소드 - UPDATE_CHANGE 상태 변경
	public void searchNameProject() {
		String nameTemp=nameTF.getText();
		if(nameTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[가-힣]{1,8}$/";
		if(!Pattern.matches(nameReg, nameTemp)) {
			JOptionPane.showMessageDialog(this, "이름은 8자리 이내의 한글로만 입력해 주세요.");
			nameTF.requestFocus();
			return;	
		}
		
		String name=nameTF.getText();
		
		//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 
		//반환하는 DAO 클래스의 메소드 호출
		ProjectDTO project=ProjectDAOImpl.getDAO().selectProject(name);
		
		if(project == null) {//검색된 학생정보가 없는 경우
			JOptionPane.showMessageDialog(this, "변경할 이름의 아이돌정보가 없습니다.");
			nameTF.requestFocus();
			nameTF.setText("");
			return;
		}
		
		//검색된 학생정보를 JTextField 컴퍼넌트에 출력
		nameTF.setText(project.getName());
		genderTF.setText(project.getGender());
		memTF.setText(project.getMem());
		songTF.setText(project.getSong());
		agencyTF.setText(project.getAgency());
		
		//UPDATE_CHANGE 상태로 변경
		setEnable(UPDATE_CHANGE);
	}
	
	//JTextField 컴퍼넌트로 입력된 학생정보를 제공받아 STUDENT 테이블에 저장된 학생정보를 변경하고 
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
	public void modifyIdol() {
		String name=nameTF.getText();//학번을 반환받아 저장
	
		//JTextField 컴퍼넌트에 입력된 변경값을 반환받아 저장 
		String gender=nameTF.getText();
		
		if(gender.equals("")) {
			JOptionPane.showMessageDialog(this, "성별을 반드시 입력해 주세요.");
			genderTF.requestFocus();
			return;	
		}
		
		String genderReg="[남]|[녀]{1}$/";
		if(!Pattern.matches(genderReg, gender)) {
			JOptionPane.showMessageDialog(this, "성별은 남 또는 녀로만 입력해 주세요.");
			genderTF.requestFocus();
			return;
		}
		
		String mem=memTF.getText();
		if(mem.equals("")) {
			JOptionPane.showMessageDialog(this, "멤버 명수를 반드시 입력해 주세요.");
			memTF.requestFocus();
			return;
		}
		
		String memReg="^[1-9]*$";
		if(!Pattern.matches(memReg, mem)) {
			JOptionPane.showMessageDialog(this, "멤버 명수를 형식에 맞게 입력해 주세요.");
			memTF.requestFocus();
			return;
		}
		
		String song=songTF.getText();
		
		if(song.equals("")) {
			JOptionPane.showMessageDialog(this, "노래제목을 반드시 입력해 주세요.");
			songTF.requestFocus();
			return;
		}
		
		String agency=agencyTF.getText();
		
		if(agency.equals("")) {
			JOptionPane.showMessageDialog(this, "소속사를 반드시 입력해 주세요.");
			agencyTF.requestFocus();
			return;
		}
		
		String agencyReg="[가-힣][A-z]{1,8}$/)";
		if(!Pattern.matches(agencyReg, agency)) {
			JOptionPane.showMessageDialog(this, "소속사 이름을 형식에 맞게 입력해 주세요.");
			agencyTF.requestFocus();
			return;
		}
		
		ProjectDTO project=new ProjectDTO();
		project.setName(name);
		project.setGender(gender);
		project.setMem(mem);
		project.setSong(song);
		project.setAgency(agency);
		
		//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하는 DAO 클래스의 메소드 호출
		int rows=ProjectDAOImpl.getDAO().updateProject(project);
		
		JOptionPane.showMessageDialog(this, rows+"명의 아이돌정보를 변경 하였습니다.");

		displayAllIdol();
		initDisplay();
	}
	
	//JTextField 컴퍼넌트로 입력된 학번을 제공받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 
	//삭제하고 STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
	public void removeIdol() {
		String nameTemp=nameTF.getText();
		if(nameTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[가-힣]{1,8}$/";
		if(!Pattern.matches(nameReg, nameTemp)) {
			JOptionPane.showMessageDialog(this, "이름은 8자리 이내의 한글로만 입력해 주세요.");
			nameTF.requestFocus();
			return;	
		}
		
		String name=nameTF.getText();
		
		//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하는
		//DAO 클래스의 메소드 호출
		int rows=ProjectDAOImpl.getDAO().deleteProject(name);
		
		if(rows > 0) {
			JOptionPane.showMessageDialog(this, rows+"명의 아이돌정보를 삭제 하였습니다.");
			displayAllIdol();
		} else {
			JOptionPane.showMessageDialog(this, "삭제할 아이돌의 정보가 없습니다.");
		}
		
		initDisplay();
	}
	
	//JTextField 컴퍼넌트로 입력된 이름을 제공받아 STUDENT 테이블에 저장된 해당 이름이 포함된  
	//학생정보를 검색하고 JTable 컴퍼넌트에 출력하는 메소드	
	public void searchNameProject1() {
		String name=nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			nameTF.requestFocus();
			return;	
		}
		
		String nameReg="^[가-힣]{1,8}$/";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "이름은 8글자 이하의 한글로만 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환
		//하는 DAO 클래스의 메소드 호출
		List<ProjectDTO> projectList=ProjectDAOImpl.getDAO().selectNameProjectList(name);
		
		if(projectList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "검색된 학생정보가 없습니다.");
			return;
		}
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//JTable 컴퍼넌트 초기화 - 기존 출력행 삭제 처리
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}

		for(ProjectDTO project : projectList) {
			Vector<Object> rowData=new Vector<>();

			rowData.add(project.getName());
			rowData.add(project.getGender());
			rowData.add(project.getMem());
			rowData.add(project.getSong());
			rowData.add(project.getAgency());
		
			model.addRow(rowData);
		}
	}
}