package spring.core.di.beans;

/**
 * Created by Shubo on 4/10/2015.
 */
public class Address {
    private String address;

    public Address(){}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
