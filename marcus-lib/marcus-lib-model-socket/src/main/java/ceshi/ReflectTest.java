package ceshi;

public class ReflectTest {
	
	public Object copy(Object object) throws Exception{
		Class classType = object.getClass();
		System.out.println("Class:" + classType.getName());
		
		Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
		return objectCopy;
	}

}
