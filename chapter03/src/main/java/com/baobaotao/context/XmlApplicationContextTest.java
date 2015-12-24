package com.baobaotao.context;

import com.baobaotao.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/com.baobaotao/context/*.xml");
		Car car1 = ctx.getBean("car",Car.class);
//		ctx = new FileSystemXmlApplicationContext("D:/masterSpring/chapter3/src/com/com.baobaotao/context/*.xml");
//		Car car2 = ctx.getBean("car",Car.class);
	}
}
