package com.marcus.string;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
    	InetAddress address = InetAddress.getByName("syu2147000001.my3w.com");
    	System.out.println("ip:" + address );
        System.out.println( "Hello World!" );
    }
}
