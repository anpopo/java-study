package javas.study.book.modern.ch02;

public class AppleHeavyWeightPredicate implements ApplePredicate{


    public static final int HEAVY_WEIGHT_STANDARD = 150;

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > HEAVY_WEIGHT_STANDARD;
    }
}
