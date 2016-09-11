package rmi;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rmi.impl.HelloServiceImpl;

public class SimpleServer {
	
	public static void main(String[] args) {
		try {
			HelloService service1 = new HelloServiceImpl("service1");	//创建远程对象
			HelloService service2 = new HelloServiceImpl("service2");
			Context namingContext = new InitialContext();
			//namingContext.bind("rmi:HelloService1", service1); 	//注册对象，将对象与一个名字绑定，如果该名字已经与其他对象绑定，就会抛出NameAlreadyBoundException
			namingContext.rebind("rmi://localhost:8000/HelloService1", service1);	//注册远程对象
			namingContext.rebind("rmi://localhost:8000/HelloService2", service2);
			
			System.out.println("服务器注册了两个HelloService对象");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
