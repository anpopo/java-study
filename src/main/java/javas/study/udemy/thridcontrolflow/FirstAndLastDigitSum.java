package javas.study.udemy.thridcontrolflow;

public class FirstAndLastDigitSum {

    public static int sumFirstAndLastDigit (int number) {
        if (number < 0) return -1;

        if (number < 10) return 2 * number;

        boolean first = true;
        int ret = 0;

        while (number > 0) {
            if (first) {
                first = false;
                ret += number % 10;
            }

            if (number < 10) {
                ret += number;
            }

            number /= 10;
        }
        return ret;
    }
}
