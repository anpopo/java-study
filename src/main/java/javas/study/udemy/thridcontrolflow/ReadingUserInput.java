package javas.study.udemy.thridcontrolflow;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ReadingUserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your year of birth : ");
        boolean hasNextInt = sc.hasNextInt();
        if (hasNextInt) {
            int yearOfBirth = sc.nextShort();
            sc.nextLine();  // 개행 문자 handle

            System.out.print("enter your name : ");
            String name = sc.nextLine();

            int age = LocalDateTime.now().getYear() - yearOfBirth;
            if (age >= 0 && age <= 200) {
                System.out.println("Your name is " + name + ", and you are " + age + " years old");
            } else {
                System.out.println("Invalid year of birth");
            }
        } else {
            System.out.println("Unable to parse year of birth");
        }

        sc.close();
    }
}
