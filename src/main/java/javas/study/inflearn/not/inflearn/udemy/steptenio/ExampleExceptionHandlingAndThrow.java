package javas.study.inflearn.not.inflearn.udemy.steptenio;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExampleExceptionHandlingAndThrow {

    public static void main(String[] args) {

        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }
    }

    private static int divide() {

        int x, y;
//        try {
        x = getInt();
        y = getInt();
        System.out.printf("x is %d, y is %d\n", x, y);
        return x / y;
//        } catch (NoSuchElementException e) {
//            throw new NoSuchElementException("no suitable input");
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("attempt to divide by zero");
//        }
    }

    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("enter your number");
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
            }
        }
    }

}
