package spring.core.di.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Shubo on 6/6/2017.
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public Car getObject() throws Exception {
        return new Car(brand,26850);
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
