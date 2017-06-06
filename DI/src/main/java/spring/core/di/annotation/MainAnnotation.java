package spring.core.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.di.annotation.controller.UserController;
import spring.core.di.annotation.repository.UserRepository;
import spring.core.di.annotation.service.UserService;

public class MainAnnotation {

    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("di-annotation.xml");

    public static void main(String[] args){
        ex01();
        ex02();
    }

    private static void ex01() {
        System.out.println("start ex01");

        Bean to = (Bean) ctx.getBean("bean");
        to.test1();
        to.test2();

        System.out.println("exit ex01");
    }


    private static void ex02() {
        System.out.println("start ex02");
        UserController uc = (UserController) ctx.getBean("userController");
        System.out.println(uc);
        uc.execute();

        UserService us = (UserService) ctx.getBean("userService");
        System.out.println(us);

        UserRepository ur = (UserRepository) ctx.getBean("userRepository");
        System.out.println(ur);

        System.out.println("exit ex02");
    }
}
