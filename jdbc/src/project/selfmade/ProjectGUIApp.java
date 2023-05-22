package project.selfmade;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
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
	// 여기부터
	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;
	
	JTextField nameTF,genderTF, memTF, mnameTF, songTF, agencyTF;
	JButton addB,deleteB,updateB,searchB,cancelB,enameB,rankingB,musicB,randomB;
	// 얘는 표(테이블)가 나오게 하기 위한 컴퍼넌트
	JTable table;
	
	int cmd;
	// 여기까지 버튼자체를 인식하게 만드는 식
	public ProjectGUIApp() throws Exception {
		setTitle("◈◈◈ 가수 백과사전 ◈◈◈");
		// 여기서 우리 프로그램 사이즈 조절할 수 있음
		setSize(1080,720);
		
		// 여기서 우리 버튼 크기 바꿀 수 있음
		Dimension dim=getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 -getHeight() / 2);
		// 여기는 JPanel(그 입력값 받는 곳) 설정
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5,1));
		
		JPanel pname = new JPanel();
		pname.add(new JLabel("그룹명"));
		pname.add(nameTF = new JTextField(10));

		JPanel pgender = new JPanel();
		pgender.add(new JLabel("보이그룹/걸그룹"));
		pgender.add(genderTF = new JTextField(10));
		
		JPanel pmem = new JPanel();
		pmem.add(new JLabel("멤버수"));
		pmem.add(memTF = new JTextField(10));
		
		JPanel pmname = new JPanel();
		pmname.add(new JLabel("멤버구성"));
		pmname.add(mnameTF = new JTextField(10));

		JPanel psong = new JPanel();
		psong.add(new JLabel("대표곡"));
		psong.add(songTF = new JTextField(10));

		JPanel pagency = new JPanel();
		pagency.add(new JLabel("소속사"));
		pagency.add(agencyTF = new JTextField(10));
		
		JButton enameB = new JButton("소속사 정보");
		JButton rankingB = new JButton("아이돌 랭킹 보기");
		JButton musicB = new JButton("음원 차트");
		JButton randomB = new JButton("오늘의 IDOL");
		
		  //커스텀 커서 만들기
		  Toolkit tk = Toolkit.getDefaultToolkit();
		  Image cursorimage = tk.getImage("src/image/HH.png");
		  Point point = new Point(0,0);
		  Cursor cursor = tk.createCustomCursor(cursorimage, point, "HH");

	      //버튼에 이미지 넣기
		  ImageIcon img = new ImageIcon("src/image/cc.png");
		  ImageIcon img2 = new ImageIcon("src/image/hhh.jpg");
		  ImageIcon img3 = new ImageIcon("src/image/music.jpg");
	      ImageIcon img4 = new ImageIcon("src/image/what.jpg");
	      
	      enameB.setIcon(img);
	      enameB.setCursor(cursor); // 커서 변경
	      enameB.setBackground(Color.white); //배경색 변경
	      enameB.setForeground(Color.red); //글자색 변경
	      
	      rankingB.setIcon(img2);
	      rankingB.setCursor(cursor);         
	      rankingB.setBackground(Color.white);
	      rankingB.setForeground(Color.orange);

	      musicB.setIcon(img3);
	      musicB.setCursor(cursor);      
	      musicB.setBackground(Color.white);
	      musicB.setForeground(Color.blue);
	      
	      randomB.setIcon(img4);
	      randomB.setCursor(cursor); // 커서 변경
	      randomB.setBackground(Color.white); //배경색 변경
	      randomB.setForeground(Color.red); //글자색 변경

	      	
	      
		left.add(pname);
		left.add(pgender);
		left.add(pmem);
		left.add(pmname);
		
		left.add(psong);
		left.add(pagency);
		left.add(enameB);
		left.add(rankingB);
		left.add(musicB);
		left.add(randomB);
		//여기는 새로운 버튼 추가한거
		enameB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1=ADOR   2=YG   3=STARSHIP   4=SOURCE   5=SM   6=BIGHIT   7=PLEDIS   8=YG   9=JYP");
			}
		});
		setVisible(true);
		setSize(1200,480);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		rankingB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
				try {
				URI uri = new URI("https://www.idol-chart.com/");
					desktop.browse(uri);
				} catch(IOException ex) {
					ex.printStackTrace();
				} catch(URISyntaxException ex) {
					ex.printStackTrace();
					} 
				}
			}
		});
		setVisible(true);
		setSize(1200,480);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		musicB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
				try {
				URI uri = new URI("https://vibe.naver.com/chart/total");
					desktop.browse(uri);
				} catch(IOException ex) {
					ex.printStackTrace();
				} catch(URISyntaxException ex) {
					ex.printStackTrace();
					} 
				}
			}
		});
		setVisible(true);
		setSize(1200,480);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		randomB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "랜덤 뽑기 성공!");
				displayAllProjectOrderByAgency();
			}
		});
		//~여기까지
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1,5));
		
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
		
		Object[] title={"그룹명","보이그룹/걸그룹","멤버수","멤버 구성","대표곡","소속사"};
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
		
		// PROJECT 테이블에 저장된 모든 정보를 검색해서 JTable 컴퍼넌트에 출력
		displayAllProject();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	//모든 JTextField 컴퍼넌트를 비활성화 처리하는 메소드
	public void initialize() {
		nameTF.setEditable(false);
		genderTF.setEditable(false);
		memTF.setEditable(false);
		mnameTF.setEditable(false);
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
			mnameTF.setEditable(true);
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
			mnameTF.setEditable(true);
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
			mnameTF.setEditable(false);
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
		mnameTF.setText("");
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
				if (cmd != ADD) {
					setEnable(ADD);					
				} else {
					addProject();
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);		

				} else if (cmd != UPDATE_CHANGE) {
					searchNameProject();
				} else {
					modifyProject();
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) {
					setEnable(DELETE);		
				} else {
					removeProject();
				}
			} else if (c == searchB) {
				if (cmd != SEARCH) {
					setEnable(SEARCH);		
				}else {
					searchNameProject();
				}
			} else if (c == cancelB) {
				displayAllProject();
				initDisplay(); 
			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e);
		}		
	}
	public void displayAllProject() {
		List<DTO> projectList=DAOClass.getDao().selectAllProjectList();

		if(projectList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 정보가 없습니다.");
			return;
		}
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		for(DTO project : projectList) {
			Vector<Object> rowData=new Vector<>();
			rowData.add(project.getName());
			rowData.add(project.getGender());
			rowData.add(project.getMem());
			rowData.add(project.getMname());
			rowData.add(project.getSong());
			rowData.add(project.getAgency());
		
			model.addRow(rowData);
		}
	}
	public void displayAllProjectOrderByAgency() {
		List<DTO> projectList=DAOClass.getDao().selectAllProjectListOrderByRandom();

		if(projectList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 정보가 없습니다.");
			return;
		}
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		for(DTO project : projectList) {
			Vector<Object> rowData=new Vector<>();
			rowData.add(project.getName());
			rowData.add(project.getGender());
			rowData.add(project.getMem());
			rowData.add(project.getMname());
			rowData.add(project.getSong());
			rowData.add(project.getAgency());
		
			model.addRow(rowData);
		}
	}
	public void addProject() {
		String nameTemp=nameTF.getText();
		if(nameTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "그룹명을 반드시 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[가-힣]+$";
		if(!Pattern.matches(nameReg, nameTemp)) {
			JOptionPane.showMessageDialog(this, "그룹명은 한글로만 입력해 주세요.");
			nameTF.requestFocus();
			return;	
		}
		
		String name=nameTF.getText();		
		if(DAOClass.getDao().selectProject(name) != null) {
			JOptionPane.showMessageDialog(this, "이미 존재하는 그룹명을 입력 하였습니다.");
			nameTF.requestFocus();
			return;	
		}
		
		String gender=genderTF.getText();
		
		if(gender.equals("")) {
			JOptionPane.showMessageDialog(this, "성별을 반드시 구분해 주세요.");
			genderTF.requestFocus();
			return;	
		}
		
		String genderReg="[보이그룹|걸그룹]+$";
		if(!Pattern.matches(genderReg, gender)) {
			JOptionPane.showMessageDialog(this, "성별은 반드시 보이그룹이나 걸그룹으로 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String mem=memTF.getText();
		
		if(mem.equals("")) {
			JOptionPane.showMessageDialog(this, "멤버수를 반드시 입력해 주세요.");
			memTF.requestFocus();
			return;
		}
		
		String memReg="^[0-9]+$";
		if(!Pattern.matches(memReg, mem)) {
			JOptionPane.showMessageDialog(this, "멤버수를 숫자로만 입력해 주세요.");
			memTF.requestFocus();
			return;
		}
		
		String mname=mnameTF.getText();
		
		String mnameTemp=mnameTF.getText();
		if(mnameTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "멤버 구성을 반드시 입력해 주세요.");
			mnameTF.requestFocus();
			return;
		}
		
		String song=songTF.getText();
		
		if(song.equals("")) {
			JOptionPane.showMessageDialog(this, "대표곡을 반드시 입력해 주세요.");
			songTF.requestFocus();
			return;
		}
		
		String agency=agencyTF.getText();

		
		if(agency.equals("")) {
			JOptionPane.showMessageDialog(this, "소속사를 반드시 입력해 주세요.");
			agencyTF.requestFocus();
			return;
		}
		
		String agencyReg="^[0-9]+$";
		if(!Pattern.matches(agencyReg, agency)) {
			JOptionPane.showMessageDialog(this, "소속사를 형식에 맞게 숫자로 입력해 주세요.");
			agencyTF.requestFocus();
			return;
		}
		
		DTO project=new DTO();
		project.setName(name);
		project.setGender(gender);
		project.setMem(mem);
		project.setMname(mname);
		project.setSong(song);
		project.setAgency(agency);
		
		int rows=DAOClass.getDao().insertProject(project);
		
		JOptionPane.showMessageDialog(this, rows+"명의 정보를 삽입 하였습니다.");

		displayAllProject();
		initDisplay();
	}
	public void searchNameProject() {
		String nameTemp=nameTF.getText();
		if(nameTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "그룹명을 반드시 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[가-힣]+$";
		if(!Pattern.matches(nameReg, nameTemp)) {
			JOptionPane.showMessageDialog(this, "그룹명은 한글로만 입력해 주세요.");
			nameTF.requestFocus();
			return;	
		}

		DTO project=DAOClass.getDao().selectProject(nameTemp);
		
		if(project == null) {
			JOptionPane.showMessageDialog(this, "검색한 그룹명의 그룹정보가 없습니다.");
			nameTF.requestFocus();
			nameTF.setText("");
			return;
		}
		
		nameTF.setText(project.getName());
		genderTF.setText(project.getGender());
		memTF.setText(project.getMem());
		mnameTF.setText(project.getMname());
		songTF.setText(project.getSong());
		agencyTF.setText(project.getAgency());
		
		//UPDATE_CHANGE 상태로 변경
		setEnable(UPDATE_CHANGE);
	}
	public void modifyProject() {
		String name=nameTF.getText();
	
		//JTextField 컴퍼넌트에 입력된 변경값을 반환받아 저장 
		String gender=genderTF.getText();
		
		if(gender.equals("")) {
			JOptionPane.showMessageDialog(this, "성별을 반드시 구분해 주세요.");
			genderTF.requestFocus();
			return;	
		}
		
		String genderReg="[보이그룹|걸그룹]+$";
		if(!Pattern.matches(genderReg, gender)) {
			JOptionPane.showMessageDialog(this, "성별은 반드시 보이그룹이나 걸그룹으로 입력해 주세요.");
			genderTF.requestFocus();
			return;
		}
		
		String mem=memTF.getText();
		
		if(mem.equals("")) {
			JOptionPane.showMessageDialog(this, "멤버수를 반드시 입력해 주세요.");
			memTF.requestFocus();
			return;
		}
		
		String memReg="^[0-9]+$";
		if(!Pattern.matches(memReg, mem)) {
			JOptionPane.showMessageDialog(this, "멤버수는 숫자로만 입력해 주세요.");
			memTF.requestFocus();
			return;
		}
		
		String mname=mnameTF.getText();
		
		String mnameTemp=mnameTF.getText();
		if(mnameTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "멤버 구성을 반드시 입력해 주세요.");
			mnameTF.requestFocus();
			return;
		}
		
		String song=songTF.getText();
		
		if(song.equals("")) {
			JOptionPane.showMessageDialog(this, "대표곡을 반드시 입력해 주세요.");
			songTF.requestFocus();
			return;
		}
		
		String agency=agencyTF.getText();
		
		if(agency.equals("")) {
			JOptionPane.showMessageDialog(this, "소속사를 반드시 입력해 주세요.");
			agencyTF.requestFocus();
			return;
		}
		
		String agencyReg="^[0-9]+$";
		if(!Pattern.matches(agencyReg, agency)) {
			JOptionPane.showMessageDialog(this, "소속사 입력을 형식에 맞게 숫자로 입력해 주세요.");
			agencyTF.requestFocus();
			return;
		}
		
		DTO project=new DTO();
		project.setName(name);
		project.setGender(gender);
		project.setMem(mem);
		project.setMname(mname);
		project.setSong(song);
		project.setAgency(agency);
		
		int rows=DAOClass.getDao().updateProject(project);
		
		JOptionPane.showMessageDialog(this, rows+"개의 그룹정보를 변경 하였습니다.");

		displayAllProject();
		initDisplay();
	}
	
	public void removeProject() {
		String name=nameTF.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "그룹명을 반드시 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[가-힣]+$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "그룹명은 한글로만 입력해 주세요.");
			nameTF.requestFocus();
			return;	
		}
		
		int rows=DAOClass.getDao().deleteProject(name);
		
		if(rows > 0) {
			JOptionPane.showMessageDialog(this, rows+"개의 그룹 정보를 삭제 하였습니다.");
			displayAllProject();
		} else {
			JOptionPane.showMessageDialog(this, "삭제할 이름의 그룹명을 가진 그룹 정보가 없습니다.");
		}
		
		initDisplay();
	}
}
