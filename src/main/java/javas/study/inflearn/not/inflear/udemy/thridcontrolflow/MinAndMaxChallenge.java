package javas.study.inflearn.not.inflear.udemy.thridcontrolflow;

import java.util.Scanner;

public class MinAndMaxChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

//        boolean first = true;

        while (true) {
            System.out.print("Enter number : ");
            boolean isAnInt = sc.hasNextInt();

            if (isAnInt) {
                int number = sc.nextInt();
//                if (first) {
//                    first = false;
//                    min = number;
//                    max = number;
//                }

                if (number > max) max = number;
                if (number < min) min = number;

            } else {
                break;
            }

            sc.nextLine();  // handle input character (enter key)
        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);

        sc.close();
    }
}
