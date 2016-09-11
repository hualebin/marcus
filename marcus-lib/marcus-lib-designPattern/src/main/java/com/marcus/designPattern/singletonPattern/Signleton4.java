package com.marcus.designPattern.singletonPattern;

/**
 * 单例模式实现方式一
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起 
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * @author Administrator
 *
 */
public class Signleton4 {
	
	private volatile static Signleton4 instance;
	
	private Signleton4() {
		
	}
	
	public static Signleton4 getInstance() {
		if (instance == null) {
			synchronized (Signleton4.class) {
				if (instance == null) {
					instance = new Signleton4();
				}
			}
		}
		return instance;
	}
	
}
