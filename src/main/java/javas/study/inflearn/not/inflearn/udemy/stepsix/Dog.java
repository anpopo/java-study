package javas.study.inflearn.not.inflearn.udemy.stepsix;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }

    @Override
    public void breath() {
        System.out.println("breathe in and out");
    }
}
