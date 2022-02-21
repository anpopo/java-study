package javas.study.inflearn.not.inflear.udemy.thridcontrolflow;

public class LastDigitChecker {

    public static boolean hasSameLastDigit (int a, int b, int c) {
        if (!isValid(a) || !isValid(b) || !isValid(c)) return false;
        int a2 = a % 10;
        int b2 = b % 10;
        int c2 = c % 10;
        return (a2 == b2 || b2 == c2 ||c2 == a2);
    }

    public static boolean isValid (int number ) {
        return number >=10 && number <= 1000;
    }
}
