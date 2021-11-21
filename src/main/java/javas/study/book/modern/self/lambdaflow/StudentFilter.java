package javas.study.book.modern.self.lambdaflow;

import javas.study.book.modern.ch02.Predicate;
import javas.study.book.modern.self.lambdaflow.predicate.StudentPredicate;

import java.util.ArrayList;
import java.util.List;

public class StudentFilter {

    public static List<Student> filteringManStudent(List<Student> studentList) {

        List<Student> resultStudentList = new ArrayList<>();

        for(Student student : studentList) {
            if(Gender.MAN.equals(student.getGender())) resultStudentList.add(student);
        }

        return resultStudentList;
    }

    public static List<Student> filteringManStudent1(List<Student> studentList, Gender gender) {

        List<Student> resultStudentList = new ArrayList<>();

        for(Student student : studentList) {
            if(student.getGender().equals(gender)) resultStudentList.add(student);
        }

        return resultStudentList;
    }

    public static List<Student> filterStudent(List<Student> studentList, StudentPredicate predicate) {

        List<Student> resultStudentList = new ArrayList<>();

        for(Student student : studentList) {
            if(predicate.test(student)) resultStudentList.add(student);
        }

        return resultStudentList;
    }
}
