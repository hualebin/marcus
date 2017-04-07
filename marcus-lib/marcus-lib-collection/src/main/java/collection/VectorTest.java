package collection;

import java.util.UUID;
import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>(1);
		vector.addElement("sss");
		vector.addElement("sssa");
		System.out.println(vector.size());
		
		System.out.println(UUID.randomUUID());
	}

}
