package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

public class ObjectInputStreamApp {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/data/object.txt"));
		
		String string = (String)in.readObject();
		Date date = (Date)in.readObject();
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>)in.readObject();
		
		System.out.println("String = "+string);
		System.out.println("Date = "+date);
		System.out.println("List = "+list);
		
		in.close();
	}
}
