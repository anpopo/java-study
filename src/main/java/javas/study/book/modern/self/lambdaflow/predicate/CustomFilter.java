package javas.study.book.modern.self.lambdaflow.predicate;

import java.util.ArrayList;
import java.util.List;
import javas.study.book.modern.self.lambdaflow.predicate.CustomPredicate;


public class CustomFilter {


    public static<T> List<T> customFilter(List<T> list, CustomPredicate<T> p) {

        List<T> resultList = new ArrayList<>();

        for(T t : list) {
            if(p.test(t)) resultList.add(t);
        }

        return resultList;
    }
}
