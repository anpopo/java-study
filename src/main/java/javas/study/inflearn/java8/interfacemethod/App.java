package javas.study.inflearn.java8.interfacemethod;

import lombok.Builder;

public class App {
    public static void main(String[] args) {
        DefaultFoo foo = new DefaultFoo("sehyeong");
        foo.printName();
        foo.printNameUpperCase();


        foo.printNameUpperCase();

        Foo.printAnything();


    }
}
