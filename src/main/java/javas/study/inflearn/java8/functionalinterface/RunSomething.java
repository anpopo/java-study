package javas.study.inflearn.java8.functionalinterface;

// 추상메서드가 1개만 있는경우
// 함수형 인터페이스
// 다른 형태의 메서드가 있더라도 추상 메서드가 1개만 있다면 함수형 인터페이스로 설정가능하다


@FunctionalInterface
public interface RunSomething {

    void doIt();

    static void printName() {
        System.out.println("sehyeong");
    }

    default void printAge() {
        System.out.println("30");
    }
}
