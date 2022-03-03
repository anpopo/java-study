package javas.study.inflearn.not.inflearn.udemy.thridcontrolflow;

import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int counter = 0;
        int sum = 0;

         while (counter < 10) {
             int order = counter + 1;
             System.out.print("Enter number #" + order + " : ");
             boolean isAnInt = sc.hasNextInt();

             if (isAnInt) {
                int number = sc.nextInt();
                counter++;
                sum += number;
             } else {
                 System.out.println("Invalid number");
             }

             sc.nextLine();  // handle end of line (enter key)
         }

        System.out.println("sum = " + sum);
        sc.close();
    }
}
