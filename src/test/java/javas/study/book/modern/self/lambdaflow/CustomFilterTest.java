package javas.study.book.modern.self.lambdaflow;

import javas.study.book.modern.self.lambdaflow.predicate.CustomFilter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CustomFilterTest {

    @Test
    void 추상화된_Predicate_학생_테스트() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("test3", 16, Gender.WOMAN));
        studentList.add(new Student("test4", 17, Gender.WOMAN));
        studentList.add(new Student("test5", 18, Gender.PERSON));
        studentList.add(new Student("test1", 14, Gender.MAN));
        studentList.add(new Student("test2", 15, Gender.MAN));
        studentList.add(new Student("test6", 19, Gender.PERSON));


        List<Student> filteredStudent = CustomFilter.customFilter(studentList, (Student s) -> s.getGender().equals(Gender.WOMAN));

        Assertions.assertThat(filteredStudent.size()).isEqualTo(2);
        Assertions.assertThat(filteredStudent).extracting("name").containsExactly("test3", "test4");
    }

    @Test
    void 추상화된_Predicate_선생님_테스트() {
        List<Teacher> teacherList = new ArrayList<>();

        teacherList.add(new Teacher("teacher1", 31, Gender.MAN, Subjects.MATH));
        teacherList.add(new Teacher("teacher2", 32, Gender.WOMAN, Subjects.ENGLISH));
        teacherList.add(new Teacher("teacher3", 33, Gender.PERSON, Subjects.KOREAN));
        teacherList.add(new Teacher("teacher4", 34, Gender.MAN, Subjects.SCIENCE));
        teacherList.add(new Teacher("teacher5", 35, Gender.WOMAN, Subjects.MATH));
        teacherList.add(new Teacher("teacher6", 36, Gender.PERSON, Subjects.ENGLISH));

        List<Teacher> filteredTeacher = CustomFilter.customFilter(teacherList, (Teacher s) -> s.getSubjects().equals(Subjects.ENGLISH));

        Assertions.assertThat(filteredTeacher.size()).isEqualTo(2);
        Assertions.assertThat(filteredTeacher).extracting("name").containsExactly("teacher2", "teacher6");
    }
}