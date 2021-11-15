package javas.study.inflearn.java8.functionalinterface;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("this is anonymous abstract class (익명 추상 클래스)");
            }
        };

        // 자바에서 함수형
        RunSomething runSomethingWithLambda = () -> System.out.println("this is lambda expression");


        // Function
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(10));

        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        plus10.compose(multiply2);

        System.out.println(plus10.andThen(multiply2).apply(2));

        Supplier<Integer> get10 = () -> 10;
        BinaryOperator<Integer> sum = Integer::sum;

        Foo foo = new Foo();
        foo.fun();


    }

    private static String apply(Integer i) {
        return "number";
    }

    // 로컬 변수 캡쳐
    private void fun() {
        // 자바 8 부터는 immutable 한 변수에 관해서 final 을 생략할 수 있다.
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                System.out.println(baseNumber);
            }
        }
        // 람다
        // 람다 스코프는 람다를 감싸고 있는 메서드와 같은 스코프이다.
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);

        printInt.accept(10);

        Function<Integer, String> intToString = Foo::apply;
    }
}
