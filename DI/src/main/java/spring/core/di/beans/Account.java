package spring.core.di.beans;


public class Account {

    private String name;
    private Bank bank;

    public Account() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", bank=" + bank +
                '}';
    }
}
