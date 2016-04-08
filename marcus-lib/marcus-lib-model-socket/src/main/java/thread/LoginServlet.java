package thread;

public class LoginServlet {
	private static String userNameRef;
	private static String passWordRef;
	
	synchronized public static void doPost(String userName, String passWord){
		try{
			userNameRef = userName;
			if("a".equals(userName)){
				Thread.sleep(5000);
			}
			passWordRef = passWord;
			System.out.println("userName=" + userNameRef + ",passWord=" + passWord);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
