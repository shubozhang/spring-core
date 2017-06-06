package spring.core.di.annotation;

import org.springframework.stereotype.Component;

/**
 * Created by uc0006 on 5/28/2015.
 */
@Component("Bean2")
public class Bean2 {

    private int x;
    Bean2() {
        System.out.println("Bean2 constructor start---------");
        this.x = 20;
        System.out.println("Bean2-------" + this);
        System.out.println("Bean2 constructor end");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
