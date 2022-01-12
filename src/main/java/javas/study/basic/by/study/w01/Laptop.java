package javas.study.basic.by.study.w01;

public class Laptop extends Product{
    private String core;

    public Laptop(int price, String name, String core) {
        super(price, name);
        this.core = core;
    }

    @Override
    public String getProperty() {
        return this.core;
    }
}
