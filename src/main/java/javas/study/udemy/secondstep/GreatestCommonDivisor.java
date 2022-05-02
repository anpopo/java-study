package javas.study.udemy.secondstep;

import java.io.IOException;
import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean hasAnInt1 = sc.hasNextInt();
        boolean hasAnInt2 = sc.hasNextInt();

        if (hasAnInt1 && hasAnInt2) {
            int inputNumber1 = sc.nextInt();
            int inputNumber2 = sc.nextInt();

            System.out.printf("The result of getGreatestCommonDivisor : %d\n", leastCommonMultiple(inputNumber1, inputNumber2));
        }
        sc.close();
    }

    private static int leastCommonMultiple(int a, int b) {
        return (a * b) / gcdByRecursive(Math.max(a, b), Math.min(a, b));
    }

    private static int gcdByWhileLoop (int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int gcdByRecursive(int a, int b) {
        if (a % b == 0) return b;
        return gcdByRecursive(b, a % b);
    }


    public static int getGreatestCommonDivisor (int first, int second) {
        if (first < 10 || second < 10) return -1;

        int minValue = Math.min(first, second);
        int maxValue = Math.max(first, second);

        while (minValue != 0) {
            int r = maxValue % minValue;
            maxValue = minValue;
            minValue = r;
        }
        return maxValue;
    }

}
