package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author marcus
 * 2018/6/26
 */
public class SocketTest {

	public static void main(String[] args) {
		Socket socket = null;
		OutputStream os = null;

		InputStream socketReader = null;
		String strOutput = "";
		try {
			socket = new Socket("192.168.1.18", 50000);
			// String str = "CCDDA101FFFFFFFF9E3C";  //全开
			//String str = "CCDDA1010000FFFFA040";  //全关
			String str = "CCDDA10100010001A448";  //全关

			os = socket.getOutputStream();
			os.write(hexStrToBinaryStr(str));
			// os.write(msg);
			os.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {

				}
			}
			if (socketReader != null) {
				try {
					socketReader.close();
				} catch (IOException e) {

				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {

				}
			}

		}


		System.out.println("done");

	}

	/**
	 * 将十六进制的字符串转换成字节数组
	 *
	 * @param hexString
	 * @return
	 */
	public static byte[] hexStrToBinaryStr(String hexString) {

		hexString = hexString.replaceAll(" ", "");

		int len = hexString.length();
		int index = 0;


		byte[] bytes = new byte[len / 2];

		while (index < len) {

			String sub = hexString.substring(index, index + 2);

			bytes[index/2] = (byte)Integer.parseInt(sub,16);

			index += 2;
		}


		return bytes;
	}

}
