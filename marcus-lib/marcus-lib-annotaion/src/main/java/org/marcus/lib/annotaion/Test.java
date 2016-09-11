package org.marcus.lib.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)	//定义注解应用于方法
@Retention(RetentionPolicy.RUNTIME)	//定义注解级别为运行时
public @interface Test {

}
