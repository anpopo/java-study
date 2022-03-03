package javas.study.inflearn.not.inflearn.udemy.fourthstep.ooptest;

public class HealthyBurger extends Hamburger {
    private String healthyExtra1Name;
    private double healthyExtra1Price;

    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("healthy burger", meat, price, "brown rye");
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double basicPrice = super.itemizeHamburger();
        if (this.healthyExtra1Name != null) basicPrice += healthyExtra1Price;
        if (this.healthyExtra2Name != null) basicPrice += healthyExtra2Price;
        return basicPrice;
    }
}
