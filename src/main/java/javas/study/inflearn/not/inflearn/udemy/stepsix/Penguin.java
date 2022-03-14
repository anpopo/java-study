package javas.study.inflearn.not.inflearn.udemy.stepsix;

public class Penguin extends Bird{
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I'm not very good at that, can i go for a  swim instead");
    }
}
