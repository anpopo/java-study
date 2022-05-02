package javas.study.udemy.secondstep;

public class SecondAndMinuteChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(12, 24));
        System.out.println(getDurationString(744));
    }

    public static String getDurationString(int minute, int seconds) {
        if (minute < 0 || seconds < 0 || seconds > 59) return "Invalid value";
        return String.format("%02dh %02dm %02ds", minute / 60, minute % 60, seconds);
    }

    public static String getDurationString (int seconds) {
        if (seconds < 0) return "Invalid value";
        return getDurationString(seconds / 60, seconds % 60);
    }
}
