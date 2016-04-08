package datagramSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoClient {
	private String remoteHost = "localHost";
	private int remotePort = 8000;
	private DatagramSocket socket;
	
	public EchoClient() throws SocketException{
		socket = new DatagramSocket();
	}
	
	public void talk() throws IOException{
		try{
			InetAddress remoteIp = InetAddress.getByName(remoteHost);
			BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			while((msg = localReader.readLine()) != null){
				byte[] outputData = msg.getBytes();
				DatagramPacket outputPacket = new DatagramPacket(outputData, outputData.length, remoteIp, remotePort);
				socket.send(outputPacket);
				DatagramPacket inputPacket = new DatagramPacket(new byte[512], 512);
				socket.receive(inputPacket);
				System.out.println(new String(inputPacket.getData(), 0, inputPacket.getLength()));
				if(msg.equals("bye")){
					break;
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		}finally{
			socket.close();
		}
	}
	
	public static void main(String args[]) throws SocketException, IOException{
		new EchoClient().talk();
	}

}
