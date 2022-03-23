package javas.study.inflearn.not.inflearn.udemy.stepeight;

public class SIBTest {

    public static final String owner;

    static {
        owner = "Sehyeong";
        System.out.println("SIBTest static initialization block called");
    }

    public SIBTest() {
        System.out.println("SIB Constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod() {
        System.out.println("some method called");

    }
}
