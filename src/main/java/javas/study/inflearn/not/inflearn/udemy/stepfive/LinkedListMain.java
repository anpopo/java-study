package javas.study.inflearn.not.inflearn.udemy.stepfive;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMain {

    public static void main(String[] args) {

        LinkedListCustomer customer1 = new LinkedListCustomer("sehyeong", 53.14);
        LinkedListCustomer customer2;

        customer2 = customer1;
        customer2.setBalance(11.11);

        System.out.printf("%s - %f\n", customer1.getName(), customer1.getBalance());
        System.out.printf("%s - %f\n", customer2.getName(), customer2.getBalance());

        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        integers.add(1, 4);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
