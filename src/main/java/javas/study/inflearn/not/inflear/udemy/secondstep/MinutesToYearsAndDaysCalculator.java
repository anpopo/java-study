package javas.study.inflearn.not.inflear.udemy.secondstep;

public class MinutesToYearsAndDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) System.out.println("Invalid Value");
        else {
            System.out.printf("%d min = %d y and %d d%n", minutes, minutes / (365 * 24 * 60),( minutes % (365 * 24 * 60)) / (24 * 60));
        }
    }
}
