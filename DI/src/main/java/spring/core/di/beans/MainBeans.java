package spring.core.di.beans;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBeans {

    //Create Spring IOC container object: ApplicationContext is an interface, ClassPathXmlApplicationContext is an implementation class
    private static  ApplicationContext ctx1 = new ClassPathXmlApplicationContext("di-beans.xml");
    private static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("di-beans.xml");


    public static void main(String[] args) {

        ex00();
        ex01();
        ex02();
        ex03();
        ex04();
        ex05();
        ex06();
        ex07();
        ex08();
        ex09();
        ex10();
        ex11();
        ex12();
        ex13();
        ex14();
        ex15();
        ex16();
        ex17();
        ex18();
        ex20();
        ex21();
        ex22();
        ex19();
    }

    // Not a Spring
    public static void ex00() {
        System.out.println("start ex00");

        HelloWorld hi = new HelloWorld();
        hi.setUser("Tom");
        hi.hello();

        System.out.println("exit ex00");
    }


    //Create Spring IOC container object: use ApplicationContext
    public static void ex01() {

        System.out.println("start ex01");

        /* Get bean instance from IOC container
         getBean(className.class), there must be only one bean in this case.*/

        HelloWorld helloWorld = (HelloWorld) ctx1.getBean("helloWorld");

       //Invoke bean method, setter injection
        helloWorld.hello();

        System.out.println("exit 01");
    }


    public static void ex02() {
        System.out.println("start ex02");

        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        helloWorld.hello();

        System.out.println("exit ex02");

    }

    //Constructor injection
    public static void ex03() {
        System.out.println("start ex03");

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);

        Car car4 = (Car) ctx.getBean("car4");
        System.out.println(car4);

        System.out.println("exit ex03");
    }

    //Map, List
    public static void ex04() {
        System.out.println("start ex04");

        User user = (User) ctx.getBean("user2");
        System.out.println(user);

        System.out.println("exit ex04");
    }

    // props
    public static void ex05() {

        System.out.println("start ex05");

        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
        System.out.println(dataSource);

        System.out.println("exit ex05");
    }


    // Autowire: byName
    public static void ex06() {
        System.out.println("start ex06");

        Person p1 = (Person) ctx.getBean("person");
        System.out.println(p1);

        System.out.println("exit ex06");
    }

    //Autowire: byType
    public static void ex07() {
        System.out.println("start ex07");

        Account account = (Account) ctx.getBean("account");
        System.out.println(account);

        System.out.println("exit ex07");
    }

    // Bean inheritance
    public static void ex08() {
        System.out.println("start ex08");

        Address ad2 = (Address) ctx.getBean("address2");
        System.out.println(ad2);

        System.out.println("exit 08");
    }


    // 9. Bean inherit Abstract bean
    public static void ex09() {
        System.out.println("start ex09");

        Address ad3 = (Address) ctx.getBean("address3");
        System.out.println(ad3);

        System.out.println("exit ex09");
    }

    // 10. Bean inherit Abstract bean
    public static void ex10() {
        System.out.println("start ex10");

        Address ad4 = (Address) ctx.getBean("address4");
        System.out.println(ad4);

        System.out.println("exit ex10");
    }


    // 11. Bean scope: default singleton
    // singleton: 单例的. 每次调用 getBean 方法都会返回同一个 bean. 且在 IOC 容器初始化时即创建 bean 的实例. 默认值
    // prototype: 原型的. 每次调用 getBean 方法都会返回一个新的 bean. 且在第一次调用 getBean 方法时才创建实例
    public static void ex11() {
        System.out.println("start ex11");

        Car car100 = (Car) ctx.getBean("car");
        Car car200 = (Car) ctx.getBean("car");
        System.out.println(car100 == car200);

        System.out.println("exit ex11");

    }

    // 12. Bean scope: testing prototype. Bean only be created when getBean is called.
    public static void ex12() {
        System.out.println("start ex12");

        Car car300 = (Car) ctx.getBean("carPrototype");
        Car car400 = (Car) ctx.getBean("carPrototype");
        System.out.println(car300 == car400);

        System.out.println("exit ex12");
    }


    //13. Testing dataSource
    public static void ex13() {

        System.out.println("start ex13");
        ComboPooledDataSource source = (ComboPooledDataSource) ctx.getBean("db_source");
        System.out.println(source.getUser() + " : " + source.getPassword() + " : " + source.getJdbcUrl() + " : " + source.getDriverClass());

        System.out.println("exit ex13");
    }



    //14. Testing di_db.properties
    public static void ex14() {
        System.out.println("start ex14");

        ComboPooledDataSource source2 = (ComboPooledDataSource) ctx.getBean("db_properties");
        System.out.println(source2.getUser() + " : " + source2.getPassword() + " : " + source2.getJdbcUrl() + " : " + source2.getDriverClass());

        System.out.println("exit ex14");
    }


    // 15. SpEL: assign a value
    public static void ex15() {

        System.out.println("start ex15");
        Address addressEL = (Address) ctx.getBean("addressEL");
        System.out.println(addressEL);
        System.out.println("exit ex15");
    }

    //16. SpEL: assign a static property
    public static void ex16() {

        System.out.println("start ex16");
        Car carEL = (Car) ctx.getBean("carEL");
        System.out.println(carEL.toString());
        System.out.println("exit ex16");
    }


    //17. SpEl: refer to another bean, bean.field, and operator
    public static void ex17() {
        System.out.println("start ex17");
        Person personEL = (Person) ctx.getBean("personEL");
        System.out.println(personEL);
        System.out.println("exit ex17");
    }

    // 18. Testing Bean Cycle
    public static void ex18() {
        System.out.println("start ex18");

        Car carBeanCycle = (Car) ctx.getBean("carBeanCycle");
        System.out.println(carBeanCycle);

        System.out.println("exit ex18");
    }

    //19. Testing beanPostProcessor
    public static void ex19() {
        System.out.println("start ex19");
        ctx.close();
        System.out.println("exit ex19");
    }

    // 20. Testing staticFactory
    public static void ex20() {

        System.out.println("start ex20");
        Car carFromStaticFactory = (Car) ctx.getBean("carFromStaticFactory");
        System.out.println(carFromStaticFactory.getBrand() + " : " + carFromStaticFactory.getPrice());
        System.out.println("exit ex20");
    }

    //21. Testing staticFactory
    public static void ex21() {

        System.out.println("start ex21");
        Car carFromInstanceFactory = (Car) ctx.getBean("carFromInstanceFactory");
        System.out.println(carFromInstanceFactory.getBrand() + " : " + carFromInstanceFactory.getPrice());

        System.out.println("exit ex21");
    }


    public static void ex22() {
        System.out.println("start ex22");

        Car car = (Car)ctx.getBean("carFromFactoryBean");
        System.out.println(car);

        System.out.println("exit ex22");
    }

}
