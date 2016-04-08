package socket;

import java.io.IOException;
import java.net.Socket;

public class PortScanner {
	public void scan(String host){
		Socket socket = null;
		for(int port = 0; port<1024; port++){
			try{
				socket = new Socket(host,port);
				System.out.println("This is a server on port "+port);
			}catch(IOException e){
				System.out.println("Cannot connect to port"+port);
			}finally{
				try{
					if(socket!=null){
						socket.close();
					}
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[]){
		String host = "localhost";
		if(args.length>0){
			host = args[0];
		}
		new PortScanner().scan(host);
	}
}
