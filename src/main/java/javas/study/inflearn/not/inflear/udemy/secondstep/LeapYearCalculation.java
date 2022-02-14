package javas.study.inflearn.not.inflear.udemy.secondstep;

public class LeapYearCalculation {
    public static boolean isLeapYear (int year) {
        if (year >= 1 && year <= 9999) {
            return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        }
        return false;
    }
}
