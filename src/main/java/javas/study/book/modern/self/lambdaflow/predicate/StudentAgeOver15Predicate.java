package javas.study.book.modern.self.lambdaflow.predicate;

import javas.study.book.modern.self.lambdaflow.Student;

public class StudentAgeOver15Predicate implements StudentPredicate{
    @Override
    public boolean test(Student student) {
        return student.getAge() >= 15;
    }
}
