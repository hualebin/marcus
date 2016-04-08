package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SocketServer1 {
	
	private static Object xWait = new Object();
	private ServerSocket serverSocket;
	private static int port = 8000;
	
	public SocketServer1() throws IOException{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(100);
		System.out.println("服务器启动成功了..............");
	}
	
	public void service() {
		try {
            while(true) {
            	Socket socket = null;
            	try{
            		socket = serverSocket.accept();
            	}catch(SocketTimeoutException se){
            		synchronized (SocketServer1.xWait) {
						System.out.println("这次没有从底层接收到任务数据报文，等待10毫秒，模拟事件X的处理时间");
						SocketServer1.xWait.wait(10);
					}
            		continue;
            	}
            	InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Integer sourcePort = socket.getPort();
                int maxLen = 2048;
                byte[] contextBytes = new byte[maxLen];
                int realLen;
                StringBuffer message = new StringBuffer();
                //下面我们收取信息（设置成非阻塞方式，这样read信息的时候，又可以做一些其他事情）
                socket.setSoTimeout(10);
                BIORead:while(true) {
                    try {
                        while((realLen = in.read(contextBytes, 0, maxLen)) != -1) {
                            message.append(new String(contextBytes , 0 , realLen));
                            /*
                             * 我们假设读取到“over”关键字，
                             * 表示客户端的所有信息在经过若干次传送后，完成
                             * */
                            if(message.indexOf("over") != -1) {
                                break BIORead;
                            }
                        }
                    } catch(SocketTimeoutException e2) {
                        //===========================================================
                        //      执行到这里，说明本次read没有接收到任何数据流
                        //      主线程在这里又可以做一些事情，记为Y
                        //===========================================================
                        System.out.println("这次没有从底层接收到任务数据报文，等待10毫秒，模拟事件Y的处理时间");
                        continue;
                    }
                }
                //下面打印信息
                System.out.println("服务器收到来自于端口：" + sourcePort + "的信息：" + message);

                //下面开始发送信息
                out.write("回发响应信息！".getBytes());

                //关闭
                out.close();
                in.close();
                socket.close();
            }
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if(serverSocket != null) {
                try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
	}
	
	public static void main(String args[]) throws IOException{
		new SocketServer1().service();
	}

}
