package spring.core.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * What happens when autowired bean is initialized with new constructor?
 * 1. Bean1 instance is created by new constructor. Bean1@7276c8cd
 * 2. Bean instance is created.
 * 3. Then another Bean1 is created and injected into Bean. Bean1@5acf93bb
 * 4. Bean2 is created and injected into Bean.
 * 5. Bean.Bean1 == Bean1@5acf93bb. So Bean will only use the injected one.
 */
@Component
public class Bean {

    @Autowired
    @Qualifier("Bean1")
    private Bean1 bean1 = new Bean1();

    @Autowired
    @Qualifier("Bean2")
    private Bean2 bean2;


    Bean() {
        System.out.println("Bean constructor---------");
        System.out.println(this.bean1);
    }

    public void test1() {
        System.out.println(bean1);
        System.out.println( +bean1.getX());
    }

    public void test2() {
        System.out.println(bean2);
        System.out.println(bean2.getX());
    }


}
