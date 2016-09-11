package rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import rmi.HelloService;


/**
 * UnicastRemoteObject类提供默认构造方法(监听一个匿名端口)及自定义端口构造方法
 * 且覆盖了Object类中的equals()、hashcode()、clone()方法
 *
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
	
	private String name;
	
	public HelloServiceImpl(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public String echo(String msg) throws RemoteException {
		System.out.println("name: " + name + "调用echo方法");
		return "echo:" + msg + "form" + name;
	}

	@Override
	public Date getTime() throws RemoteException {
		System.out.println("name: " + name + "调用getTime方法");
		return new Date();
	}

}
