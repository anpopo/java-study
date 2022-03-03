package javas.study.inflearn.not.inflearn.udemy.secondstep;

public class BarkingDog {

    public static boolean shouldWakeUp (boolean isBarking, int hourOfDay) {
        return isBarking && hourOfDay  >= 0 && hourOfDay <= 24 && (hourOfDay < 8 || hourOfDay > 22);
    }
}
