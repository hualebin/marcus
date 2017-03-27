package org.marcus.lib.all.jdk8;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Test {
    
    public static void main(String args[]) {
        Runnable noArguments = () -> System.out.println("Hello world");
        noArguments.run();
        
        ActionListener oneArgument = event -> System.out.println("button clicked");
       
        Runnable multiArgument = () -> {
            System.out.print("Hello");
            System.out.println(" world");
        };
        
        multiArgument.run();
        
        BinaryOperator<Long> add = (x, y) -> x + y;
        
        
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
        
        
        //函数接口必须是只有一个抽象方法接口，用作Lambda表达式的类型
        TestInterface ti1 = name -> System.out.println("test success " + name);
        
        //TestInterface ti2 = (a, b) -> a + b;
        
        ti1.test("yes");
        
        //Lambda表达式中引用的局部变量必须是final或既成事实上的final变量
        
        //接口                                      参数                返回类型
        //Predicate<T>    T      boolean
        //Consumer<T>     T      void
        //Function<T,R>   T      R
        //Supplier<T>     NONE   T
        //UnaryOperator<T>T      T
        //BinaryOperator<T> (T,T) T
        
        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
        Map<String, Integer> diamondWorldCounts = new HashMap<>();
        
        
        Predicate<Integer> atLeast5 = x -> x > 5;
        
        System.out.println(atLeast5);      
    }

}
