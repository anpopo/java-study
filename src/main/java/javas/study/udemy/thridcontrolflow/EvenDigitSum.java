package javas.study.udemy.thridcontrolflow;

public class EvenDigitSum {
    public static int getEvenDigitSum (int number) {
        if (number < 0) return -1;

        int ret = 0;
        while (number > 0) {
            int i = number % 10;
            if (i % 2 == 0) ret += i;
            number /= 10;
        }
        return ret;
    }
}
