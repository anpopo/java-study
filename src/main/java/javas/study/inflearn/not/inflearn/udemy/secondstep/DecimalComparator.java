package javas.study.inflearn.not.inflearn.udemy.secondstep;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces (double doubleValue1, double doubleValue2) {
        return (int) (doubleValue1 * 1000) - (int) (doubleValue2 * 1000) == 0;
    }
}
