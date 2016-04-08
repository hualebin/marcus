package datagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {
	private int port = 8000;
	private DatagramSocket socket;
	
	public EchoServer() throws IOException{
		socket = new DatagramSocket(port);	//绑定到本地的一个端口
		System.out.println("服务器启动.........");
	}
	
	public String echo(String msg){
		return "echo:" + msg;
	}
	
	public void service(){
		while(true){
			try {
				DatagramPacket packet = new DatagramPacket(new byte[512], 512);
				socket.receive(packet);
				String msg = new String(packet.getData(), 0, packet.getLength());
				System.out.println(packet.getAddress() + ":" + packet.getPort() + ">" + msg);
				packet.setData(echo(msg).getBytes());
				socket.send(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		new EchoServer().service();
	}

}
