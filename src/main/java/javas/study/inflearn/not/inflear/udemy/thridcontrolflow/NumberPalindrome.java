package javas.study.inflearn.not.inflear.udemy.thridcontrolflow;

public class NumberPalindrome {

    public static boolean isPalindrome (int number) {
        if (number < 0) number *= -1;
        int origin = number;
        int reverse = 0;
        int cnt = 0;
        while (number > 0) {
            reverse = reverse * 10 + (number % 10);
            number /= 10;
        }
        return reverse == origin;
    }
}
