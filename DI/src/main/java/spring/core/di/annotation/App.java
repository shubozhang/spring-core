package spring.core.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di-annotation.xml");

        TestObject to = (TestObject) ctx.getBean("testObject");
        System.out.println(to);

//        UserController uc = (UserController) ctx.getBean("userController");
//        System.out.println(uc);
//        uc.execute();
//
//        UserService us = (UserService) ctx.getBean("userService");
//        System.out.println(us);
//
//        UserRepository ur = (UserRepository) ctx.getBean("userRepository");
//        System.out.println(ur);
    }
}
