package javas.study.book.modern.self.lambdaflow;

public class Student {

    private String name;
    private int age;
    private Gender gender;

    public Student(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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
}
