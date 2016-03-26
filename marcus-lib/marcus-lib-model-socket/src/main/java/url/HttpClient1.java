package url;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpClient1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("http://www.baidu.com");
		
		InputStream is = url.openStream();
		
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		
		int len = -1;
		while((len = is.read(buff)) != -1){
			buffer.write(buff, 0, len);
		}
		
		System.out.println(new String(buffer.toByteArray()));
	}

}
