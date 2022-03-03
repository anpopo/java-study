package javas.study.inflearn.not.inflearn.udemy.thridcontrolflow;

public class SumOdd {

    public static boolean isOdd(int number) {
        return number >= 1 && number % 2 != 0;
    }

    public static int sumOdd(int start, int end) {
        if (start > end || start < 1) return -1;
        int sum = 0;
        for (; start <= end; start++) {
            if (isOdd(start)) sum += start;
        }
        return sum;
    }
}
