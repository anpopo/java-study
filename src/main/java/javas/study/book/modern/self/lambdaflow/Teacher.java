package javas.study.book.modern.self.lambdaflow;

public class Teacher {

    private String name;
    private int age;
    private Gender gender;
    private Subjects subjects;

    public Teacher(String name, int age, Gender gender, Subjects subjects) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Subjects getSubjects() {
        return subjects;
    }
}
