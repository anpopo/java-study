package javas.study.inflearn.not.inflearn.udemy.stepsix;

public class DeskPhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;


    @Override
    public void powerOn() {
        System.out.println("desk phone does not have a power button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("dial " + phoneNumber);
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("answering the desk phone");
            this.isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber) {
            isRinging = true;
        } else isRinging = false;
        return false;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
