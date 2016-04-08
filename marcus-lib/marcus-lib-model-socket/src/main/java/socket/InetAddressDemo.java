package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String args[]) {
		try {
			InetAddress addr1 = InetAddress.getLocalHost();
			System.out.println("本机IP地址为：" + addr1);
			InetAddress addr2 = InetAddress.getByName("www.baidu.com");
			System.out.println("百度地址为：" + addr2);
			InetAddress addr3[] = InetAddress.getAllByName("www.qidian.com");
			for (int i = 0; i < addr3.length; i++) {
				System.out.println("起点第" + i + "个地址为：" + addr3[i]);
			}
			InetAddress addr4 = InetAddress.getByName("192.168.2.116");
			System.out.println("域名为：" + addr4.getHostName());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
