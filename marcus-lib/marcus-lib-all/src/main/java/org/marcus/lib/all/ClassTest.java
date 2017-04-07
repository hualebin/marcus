package org.marcus.lib.all;

public class ClassTest {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("org.marcus.lib.all.TestForClass");
			Object obj = clazz.newInstance();
			if (obj instanceof TestForClass) {
				System.out.println("对象实例化成功");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class TestForClass {
	/*public TestForClass() {
		
	}*/
	public TestForClass(String name) {
		this.name = name;
	}
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}