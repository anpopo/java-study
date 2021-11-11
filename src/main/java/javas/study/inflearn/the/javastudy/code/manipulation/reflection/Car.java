package javas.study.inflearn.the.javastudy.code.manipulation.reflection;

public class Car {

    public static String A = "A";

    private String b = "B";

    public Car() {
    }

    public Car(String b) {
        b = b;
    }

    private void c() {
        System.out.println("C");
    }

    public int d(int left, int right) {
        return left + right;
    }
}
