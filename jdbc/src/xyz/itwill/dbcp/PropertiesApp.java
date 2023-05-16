package xyz.itwill.dbcp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PropertiesApp {
	public static void main(String[] args) throws FileNotFoundException {
//		FileInputStream in = new FileInputStream("src/xyz/itwill/dbcp/user.properties");
		
		InputStream in = PropertiesApp.class.getClassLoader().getResourceAsStream("src/xyz/itwill/dbcp/user.properties");
	}
}
