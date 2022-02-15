package javas.study.inflearn.not.inflear.udemy.secondstep;

public class PayingCat {

    public static boolean isCatPlaying( boolean summer, int temperature) {
        if (temperature >= 25) {
            if (summer && temperature <= 45) return summer;
            else if (!summer && temperature <= 35) return !summer;
        }
        return false;
    }
}
