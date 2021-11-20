package javas.study.inflearn.java8.interfacemethod;

public interface Bar {
    default void printNameUpperCase() {
        System.out.println("hello".toUpperCase());
    };

}
