package javas.study.inflearn.not.inflearn.udemy.stepeight;

public class SIBMain {

    public SIBMain() {
        System.out.println("SIB main constructor called");
    }

    static {
        System.out.println("SIB Main class called");

        SIBTestTwo sibTestTwo = new SIBTestTwo();
    }

    public static void main(String[] args) {
        System.out.println("Main called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);

        SIBMain sibMain1 = new SIBMain();
        SIBMain sibMain2 = new SIBMain();
        SIBMain sibMain3 = new SIBMain();
        SIBMain sibMain4 = new SIBMain();
        SIBMain sibMain5 = new SIBMain();
    }

    {
        System.out.println("here is SIB Main code block called");
    }
}
