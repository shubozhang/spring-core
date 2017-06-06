package spring.core.di.annotation;

import org.springframework.stereotype.Component;

/**
 * Created by uc0006 on 5/28/2015.
 */
@Component("Bean1")
public class Bean1 {

    private int x;

    Bean1() {
        System.out.println("Bean1 constructor start");
        this.x = 10;
        System.out.println("Bean1-------" + this);
        System.out.println("Bean1 constructor end");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
