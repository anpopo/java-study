package javas.study.inflearn.not.inflearn.udemy.fourthstep.ooppart1;

public class Oop1Main {

    public static void main(String[] args) {

//        Car porsche = new Car();
//        Car holden = new Car();
//        porsche.setModel("Carrera");

//        Account sehyeongAccount = new Account();
//        sehyeongAccount.deposit(Double.MAX_VALUE);
//        sehyeongAccount.withdrawal(1000d);

        Animal animal = new Animal("Animal", 1, 1, 5, 5);
        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");
        dog.eat();

    }
}
