package spring.core.di.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainGeneric {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di-generics.xml");

        UserService us = (UserService) ctx.getBean("userService");
        us.add();
    }
}
