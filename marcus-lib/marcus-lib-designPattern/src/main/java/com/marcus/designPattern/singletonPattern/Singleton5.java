package com.marcus.designPattern.singletonPattern;

/**
 * 单例模式实现方式一
 * 静态内部类
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较简单
 * 描述：instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。
 * @author Administrator
 *
 */
public class Singleton5 {
    private Singleton5() {}

    private static class SingletonHolder {
        private static final Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }

}
