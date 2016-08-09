package rmi;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rmi.impl.HelloServiceImpl;

public class SimpleServer {
	public static void main(String[] args) {
		try {
			HelloService service1 = new HelloServiceImpl("service1");
			HelloService service2 = new HelloServiceImpl("service2");
			
			Context namingContext = new InitialContext();
			namingContext.rebind("rmi://localhost:8000/HelloService1", service1);
			namingContext.rebind("rmi://localhost:8000/HelloService2", service2);
			
			System.out.println("服务器注册了两个远程对象");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
