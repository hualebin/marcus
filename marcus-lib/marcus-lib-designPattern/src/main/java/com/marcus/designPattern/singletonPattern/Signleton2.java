package com.marcus.designPattern.singletonPattern;

/**
 * 单例模式实现方式之一
 * 懒汉式 线程安全
 * 是否延迟加载初始化：是
 * 是否多线程安全： 是
 * 实现难度：易
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * @author Administrator
 *
 */
public class Signleton2 {
	
	private static Signleton2 instance;
	
	private Signleton2() {
		
	}
	
	public static synchronized Signleton2 getInstance() {
		if (instance == null) {
			instance = new Signleton2();
		}
		
		return instance;
	}

}
