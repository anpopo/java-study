package javas.study.inflearn.java8.optionalandstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalStreamApp {

    public static void main(String[] args) {
        List<OnlineCourse> onlineCourseList = new ArrayList<>();

        onlineCourseList.add(new OnlineCourse(1L, "자바의 기본에 대해서 학습한다.", true) );
        onlineCourseList.add(new OnlineCourse(2L, "spring boot study", true) );
        onlineCourseList.add(new OnlineCourse(3L, "spring boot code analysis", false) );
        onlineCourseList.add(new OnlineCourse(4L, "Clean Code", true) );
        onlineCourseList.add(new OnlineCourse(5L, "JAVA ORM JPA", false) );
        onlineCourseList.add(new OnlineCourse(6L, "Clean Architecture", true) );
        onlineCourseList.add(new OnlineCourse(7L, "Test Driven Development", true) );

        // NPE 발생 -> null 에 . 을 찍으면 발생함
        Optional<Progress> progress = Optional.ofNullable(onlineCourseList.get(1).getProgress());

        if(progress.isPresent()) System.out.println("present");
        else System.out.println("not present");

        Optional<OnlineCourse> optional = onlineCourseList.stream()
                .filter(oc -> oc.getTitle().startsWith("Clean"))
                .findFirst();

        // orElse() 를 사용하면 값이 있든 없든 parameter 구문이 실행되긴 함
        OnlineCourse onlineCourse = optional.orElse(createNewCourse());
        System.out.println(onlineCourse.getTitle());

        System.out.println("---------------------------------");

        OnlineCourse onlineCourse1 = optional.orElseGet(OptionalStreamApp::createNewCourse);
        System.out.println(onlineCourse1.getTitle());

        System.out.println("---------------------------------");

        // filter 는 해당 조건이 참인 경우에 가지고 온다.
        // map 은 리턴되는 타입으로 하나의 스트림을 만들어 반환한다.
        onlineCourseList.stream()
                .filter(OnlineCourse::isClosed)
                .map(OnlineCourse::getTitle)
                .forEach(System.out::println);

        System.out.println("---------------------------------");
        // 병렬처리는 순서는 보장하지 못한다.
        // multi 스레드 사용함에 있어 숙고해 봐야 되는 부분이 있다.
        onlineCourseList.parallelStream()
                .forEach(oc -> {
                    System.out.println(oc.getTitle() + " / " + Thread.currentThread().getName());
                });

        System.out.println("---------------------------------");

        onlineCourseList.forEach(oc -> {
                    System.out.println(oc.getTitle() + " / " + Thread.currentThread().getName());
                });

        System.out.println("---------------------------------");
        boolean b = onlineCourseList.stream()
                .anyMatch(oc -> oc.getTitle().length() > 10);
        System.out.println(b);

    }

    private static OnlineCourse createNewCourse() {
        System.out.println("here is static method");
        return new OnlineCourse(8L, "Welcome to Software Developer Engineer world", true);
    }
}
