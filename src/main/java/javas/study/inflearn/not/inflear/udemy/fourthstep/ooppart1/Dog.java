package javas.study.inflearn.not.inflear.udemy.fourthstep.ooppart1;

public class Dog extends Animal {
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew () {
        System.out.println("dog chew");
    }
    @Override
    public void eat() {
        System.out.println("dog eat");
        this.chew();
    }

    @Override
    public void move(int speed) {
        System.out.println("dog move");
        moveLegs(speed);
        super.move(speed);
    }

    private void moveLegs(int speed) {
        System.out.println("dog move legs");
    }

    public void walk () {
        System.out.println("dog walk");
        move(5);
    }

    public void run () {
        System.out.println("dog run");
        move(10);
    }
}
