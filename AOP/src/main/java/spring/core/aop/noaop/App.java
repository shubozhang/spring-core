package spring.core.aop.noaop;


public class App {
    public static void main(String[] args){
         Calculator calculator = null;
         calculator = new CalculatorImpl();

        int add = calculator.add(1, 4);
        int mul = calculator.mul(2, 6);

        System.out.println(add + " : " + mul);
    }
}
