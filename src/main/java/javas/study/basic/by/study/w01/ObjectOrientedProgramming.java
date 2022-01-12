package javas.study.basic.by.study.w01;

import java.util.List;


public class ObjectOrientedProgramming {

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Cup(10000, "컵1", "다이아몬드"),
                new Laptop(1000000, "컴퓨터1", "intel i7")
        );

        for (Product product : products) {
            System.out.println(product.getPrice());
            System.out.println(product.getName());
            System.out.println(product.getProperty());
            System.out.println("----------------");
        }

    }
}
