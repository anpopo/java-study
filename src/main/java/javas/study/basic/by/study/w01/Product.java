package javas.study.basic.by.study.w01;

public abstract class Product {

    private int price;
    private String name;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice () {
        return this.price;
    }

    public String getName() {
        return name;
    }

    public abstract  String getProperty ();
}
