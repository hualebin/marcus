package com.marcus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private int userID;
	
	public UserInfo buildUserName(String userName){
		this.userName = userName;
		return this;
	}
	
	public UserInfo buildUserID(int userID){
		this.userID = userID;
		return this;
	}
	
	public final String getUserName(){
		return userName;
	}
	
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	
	public final int getUserID(){
		return userID;
	}
	
	public final void setUserID(int userID){
		this.userID = userID;
	}
	
	public byte[] codeC(){
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		byte[] value = this.userName.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		buffer.putInt(this.userID);
		buffer.flip();
		value = null;
		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;
	}
	
	public byte[] codeB(ByteBuffer buffer) {
		buffer.clear();
		byte[] value = this.userName.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		buffer.putInt(this.userID);
		buffer.flip();
		value = null;
		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;
		
	}
	
	public static void main(String[] args) throws IOException {
		UserInfo info = new UserInfo();
		info.buildUserID(100).buildUserName("Welcome to Netty");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bos);
		os.writeObject(info);
		os.flush();
		os.close();
		byte[] b = bos.toByteArray();
		System.out.println("This jdk serializable length is : " + b.length);
		bos.close();
		System.out.println("----------------------------");
		System.out.println("The byte array serializable length is : " + info.codeC().length);
	}
}
