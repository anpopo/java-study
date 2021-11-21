package javas.study.book.modern.ch02;

import java.util.ArrayList;
import java.util.List;

// 제네릭을 사용한 리스트 형식으로 추상화
public class GeneralFilter {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}
