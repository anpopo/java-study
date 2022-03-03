package javas.study.inflearn.not.inflearn.udemy.fourthstep.ooptest;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.54, "White");
        super.addHamburgerAddition1("chips", 2.85);
        super.addHamburgerAddition2("drink", 1.22);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
    }
}
