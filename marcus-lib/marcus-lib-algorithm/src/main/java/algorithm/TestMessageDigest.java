package algorithm;

import java.io.IOException;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestMessageDigest {
	
	/**
	 * MD5加密
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static byte[] testMD5(String content) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bytes = md.digest(content.getBytes("UTF-8"));
		return bytes;
	}
	
	/**
	 * SHA加密
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static byte[] testSHA1(String content) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] bytes = md.digest(content.getBytes("utf8"));
		return bytes;
	}
	
	/**
	 * 生成DES秘钥
	 * @return
	 * @throws Exception
	 */
	public static String genKeyDES() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(56);
		SecretKey key = keyGen.generateKey();
		String base64Str = byte2base64(key.getEncoded());
		return base64Str;
	}
	
	public static SecretKey loadKeyDES(String base64Key) throws Exception {
		byte[] bytes = base642byte(base64Key);
		SecretKey key = new SecretKeySpec(bytes, "DES");
		return key;
	}
	
	/**
	 * DES加密
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptDES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
	
	/**
	 * DES解密
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptDES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
	
	/**
	 * 生成AES秘钥
	 * @return
	 * @throws Exception
	 */
	public static String genKeyAES() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);	//支持128、192、256三种秘钥强度
		SecretKey key = keyGen.generateKey();
		String base64Str = byte2base64(key.getEncoded());
		return base64Str;
	}
	
	public static SecretKey loadKeyAES(String base64Key) throws Exception {
		byte[] bytes = base642byte(base64Key);
		SecretKey key = new SecretKeySpec(bytes, "AES");
		return key;
	}
	
	/**
	 * AES加密
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptAES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
	
	/**
	 * AES解密
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptAES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
	
	public static void main(String[] args) throws Exception {
		String content = "marcus hua le bin";
		System.out.println(bytes2hex(testMD5(content)));
		System.out.println(bytes2hex(testSHA1(content)));
		System.out.println(byte2base64(testMD5(content)));
		System.out.println(byte2base64(testSHA1(content)));
		//DES
		String base64Key = genKeyDES();
		SecretKey key = loadKeyDES(base64Key);
		System.out.println(base64Key);
		System.out.println(byte2base64(encryptDES(content.getBytes(), key)));
		//DES
		String base64Key1 = genKeyAES();
		SecretKey key1 = loadKeyAES(base64Key1);
		System.out.println(base64Key1);
		System.out.println(byte2base64(encryptAES(content.getBytes(), key1)));
	}
	
	/**
	 * 十六进制编码
	 * @param bytes
	 * @return
	 */
	private static String bytes2hex(byte[] bytes) {
		StringBuilder hex = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			boolean negative = false;	//是否是负数
			if (b < 0) {
				negative = true;
			}
			int inte = Math.abs(b);
			if (negative) {
				inte = inte | 0x80;
			}
			//负数会转成正数(最高位的负号变为数值计算，再转十六进制
			String temp = Integer.toHexString(inte & 0xFF);
			if (temp.length() == 1) {
				hex.append("0");
			}
			hex.append(temp.toLowerCase());
		}
		return hex.toString();
	}
	
	/**
	 * 十六进制解码
	 * @param hex
	 * @return
	 */
	private static byte[] hex2bytes (String hex) {
		byte[] bytes = new byte[hex.length()/2];
		for (int i = 0; i < hex.length(); i = i + 2) {
			String subStr = hex.substring(i, i + 2);
			boolean negative = false;	//是否为负数
			int inte = Integer.parseInt(subStr, 16);
			if (inte > 127) {
				negative = true;
			}
			if (inte == 187) {
				inte = -128;
			} else if (negative) {
				inte = 0 - (inte & 0x7F);
			}
			byte b = (byte) inte;
			bytes[i/2] = b;
		}
		return bytes;
	}
	
	private static String byte2base64(byte[] bytes) { 
		BASE64Encoder base64Eecoder = new BASE64Encoder();
		return base64Eecoder.encode(bytes);
	}
	
	private static byte[] base642byte(String base64) throws IOException {
		BASE64Decoder base64Decoder = new BASE64Decoder();
		return base64Decoder.decodeBuffer(base64);
	}
}
