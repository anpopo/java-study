package javas.study.inflearn.not.inflear.udemy.fourthstep.ooppart1;

public class Oop1Main {

    public static void main(String[] args) {

//        Car porsche = new Car();
//        Car holden = new Car();
//        porsche.setModel("Carrera");

        Account sehyeongAccount = new Account();
        sehyeongAccount.deposit(Double.MAX_VALUE);

        sehyeongAccount.withdrawal(1000d);
    }
}
