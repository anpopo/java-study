package javas.study.inflearn.not.inflearn.udemy.stepsix;

import java.util.ArrayList;
import java.util.List;

public class GearBox {
    private List<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();

        for (int i = 0; i < maxGears; i++ ) {
            addGear(i, i * 5.3);
        }
    }

    public void addGear (int number, double ratio) {
        if (number > 0 && number <= maxGears) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear (int newGear) {
        if (newGear >= 0 && newGear < this.gears.size() && clutchIsIn) {
            this.currentGear = newGear;
        } else {
            this.currentGear = 0;
        }
    }

    public double wheelSpeed (int revs) {
        if (clutchIsIn) {
            return 0;
        }
        return revs * gears.get(currentGear).getRatio();
    }

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }
    private class Gear {
        private int gearNumber;
        private double ratio;
        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed(int revs) {
            return revs * (ratio);
        }

        public double getRatio() {
            return ratio;
        }
    }
}
