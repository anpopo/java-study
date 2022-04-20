package javas.study.inflearn.not.inflearn.udemy.steptenio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {

    }

    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int getIntLBYL() {
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        String input = sc.next();

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(0))) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            return Integer.parseInt(input);
        }

        return 0;
    }

    private static int getIntEAFP() {
        Scanner sc = new Scanner(System.in);

        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    /**
     * 두 방법 모두 많이 사용되며, 어떤 것이 더 좋다고 할 수 없기 때문에 상황에 따라서 적절한 선택이 필요하다.
     */

    // look before you leap
    private static int divideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    /**
     * Easy to forgiveness than permission
     * @param x
     * @param y
     * @return
     */
    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    private static int divide (int x, int y) {
        return x / y;
    }
}
