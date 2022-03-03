package javas.study.inflearn.not.inflearn.udemy.fourthstep.ooppart1;

public class Audi extends Cars{

    private int roadServiceMonth;

    public Audi(int roadServiceMonth) {
        super("Audi", "4WD", 5, 5, 6, false);
        this.roadServiceMonth = roadServiceMonth;
    }

    public void accelerate (int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity <= 0) {
            stop();
            changeGear(1);
        }
        else if (newVelocity <= 10) changeGear(1);
        else if (newVelocity <= 20) changeGear(2);
        else if (newVelocity <= 30) changeGear(3);
        else if (newVelocity <= 40) changeGear(4);
        else if (newVelocity <= 50) changeGear(5);
        else changeGear(6);

        if (newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
}
