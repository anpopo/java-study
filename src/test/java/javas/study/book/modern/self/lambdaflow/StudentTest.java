package javas.study.book.modern.self.lambdaflow;

import javas.study.book.modern.self.lambdaflow.predicate.StudentAgeOver15Predicate;
import javas.study.book.modern.self.lambdaflow.predicate.StudentManPredicate;
import javas.study.book.modern.self.lambdaflow.predicate.StudentPredicate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StudentTest {

    public List<Student> studentList = new ArrayList<>(){};;

    @BeforeEach
    void setup() {
        studentList.add(new Student("test1", 14, Gender.MAN));
        studentList.add(new Student("test2", 15, Gender.MAN));
        studentList.add(new Student("test3", 16, Gender.WOMAN));
        studentList.add(new Student("test4", 17, Gender.WOMAN));
        studentList.add(new Student("test5", 18, Gender.PERSON));
        studentList.add(new Student("test6", 19, Gender.PERSON));
    }

    @AfterEach
    void clear() {
        studentList.clear();
    }

    @Test
    void 이름_조건에_맞는_학생을_가져온다() {
        List<Student> students = StudentFilter.filterStudent(studentList, new StudentManPredicate());

        Assertions.assertThat(students.size()).isEqualTo(2);
        Assertions.assertThat(students).extracting("name").containsExactly("test1", "test2");
    }

    @Test
    void 나이_조건에_맞는_학생을_가져온다() {
        List<Student> students = StudentFilter.filterStudent(studentList, new StudentAgeOver15Predicate());

        Assertions.assertThat(students.size()).isEqualTo(5);
        Assertions.assertThat(students).extracting("name").containsExactly("test2", "test3", "test4", "test5", "test6");
    }

    @Test
    void 익명클래스를_사용해_조건에_맞는_학생을_가져온다() {
        List<Student> students = StudentFilter.filterStudent(studentList, new StudentPredicate() {
            @Override
            public boolean test(Student student) {
                return student.getName().contains("1");
            }
        });

        Assertions.assertThat(students.size()).isEqualTo(1);
        Assertions.assertThat(students).extracting("name").containsExactly("test1");
    }

    @Test
    void 람다_표현식을_사용해_조건에_맞는_학생을_가져온다() {
        List<Student> students = StudentFilter.filterStudent(studentList, (Student s) -> s.getName().contains("1"));

        Assertions.assertThat(students.size()).isEqualTo(1);
        Assertions.assertThat(students).extracting("name").containsExactly("test1");
    }
}