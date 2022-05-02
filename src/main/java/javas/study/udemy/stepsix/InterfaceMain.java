package javas.study.udemy.stepsix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceMain {
    public static void main(String[] args) {

    }

    public static List<String> readValues() {
        List<String> values = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Choose\n" +
                "1 - to enter a string\n" +
                "2 - to quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter a string: ");
                    String stringValue = sc.nextLine();
                    values.add(stringValue);
                    break;
                case 2:
                    quit = true;
                    break;
            }
        }
        return values;

    }
}
