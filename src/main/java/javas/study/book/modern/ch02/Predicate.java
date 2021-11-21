package javas.study.book.modern.ch02;

// 정확히 1개의 추상메서드만 지정하는 인터페이스! -> 함수형 인터페이스
public interface Predicate<T> {
    boolean test(T t);
}
