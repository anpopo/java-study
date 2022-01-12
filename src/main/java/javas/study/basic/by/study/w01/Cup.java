package javas.study.basic.by.study.w01;

public class Cup extends Product{

    private String material;

    public Cup(int price, String name, String material) {
        super(price, name);
        this.material = material;
    }

    @Override
    public String getProperty() {
        return this.material;
    }
}
