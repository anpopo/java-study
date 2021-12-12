package javas.study.book.modern.self.lambdaflow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

public class CapturingTest {

    private int instanceVar = 4;

    @Test
    @DisplayName("캡쳐링 테스트")
    void capturingTest() {

        Runnable r1 = () -> System.out.println(instanceVar);
        instanceVar = 5;


        int localVar = 10;
        Runnable r2 = () -> System.out.println(localVar);
//        localVar = 12;
    }

    @Test
    @DisplayName("메소드 참조")
    void methodReferenceTest() {

        String[] strings = {"3", "1", "2", "5", "4"};

        Arrays.sort(strings, Comparator.comparing(Integer::parseInt));


        Arrays.stream(strings).map(String::length).forEach(System.out::println);

        Student student = new Student();
    }

    @Test
    @DisplayName("다양한 종류의 메소드 참조 알아보기")
    void differentTypeOfMethodReferenceTest() {
        // 정적 메소드 참조
        Function<String, Integer> function = Integer::parseInt;
        Integer hello = function.apply("12345");
        System.out.println(hello.getClass().getName());

        // 인스턴스 메소드 참조
        UnaryOperator<String> unaryOperator = String::toUpperCase;
        String good = unaryOperator.apply("good");
        System.out.println(good);

        // 기존 객체의 인스턴스의 메소드 참조
        Student student = new Student("test name", 30, Gender.MAN);
        Predicate<Student> manChecker= student::isMan;
        System.out.println(manChecker.test(student));

        // 생성자 메소드 참조
        Supplier<Student> studentSupplier = Student::new;
        Student studentWithNothing= studentSupplier.get();
        System.out.println(studentWithNothing);

        Function<Integer, Student> studentFunction = Student::new;
        Student studentWithAge = studentFunction.apply(20);
        System.out.println(studentWithAge);

        BiFunction<Integer, String, Student> studentBiFunction = Student::new;
        Student studentWithAgeAndName = studentBiFunction.apply(30, "test name");
        System.out.println(studentWithAgeAndName);
    }
}
