package javas.study.book.modern.ch02;

import java.util.ArrayList;
import java.util.List;

public class AppleFilter {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
