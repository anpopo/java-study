package javas.study.inflearn.not.inflearn.udemy.secondstep;

public class NumberToWords {
    public static void main(String[] args) {
        numberToWords(10);
    }

    public static void numberToWords (int number) {
        String[] words = { "Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine", "Invalid Value" };
        if (number < 0) System.out.println(words[10]);
        int digitCount = getDigitCount(number);
        number = reverse(number);

        for (int i = 0; i< digitCount; i++) {
            int remain = number % 10;
            System.out.println(words[remain]);
            number /= 10;
        }
    }

    public static int reverse(int number) {
        int reverse = 0;
        while(number!=0) {
            reverse = (reverse*10) + number%10;
            number /= 10;
        }
        return reverse;
    }

    public static int getDigitCount (int number) {
        return number < 0 ? -1 : String.valueOf(number).length();
    }
}
