package javas.study.book.modern.self.lambdaflow.predicate;

import javas.study.book.modern.self.lambdaflow.Gender;
import javas.study.book.modern.self.lambdaflow.Student;

public class StudentManPredicate implements StudentPredicate{
    @Override
    public boolean test(Student student) {
        return student.getGender().equals(Gender.MAN);
    }
}
