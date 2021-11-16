package javas.study.inflearn.java8.interfacemethod;

public interface Foo {

    void printName();

    /**
     * @ implSpec
     * default method 가 어떻게 사용하는지 명세서를 작성해주어야 한다.
     * default method 는 기본적으로 override 가 가능하다.
     * Object class 에서 제공하는 기본 method 는 재정의할 수 없다.
     */

    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    };

    String getName();

    static void printAnything() {
        System.out.println("print anything");
    }
}
