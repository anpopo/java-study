package javas.study.udemy.stepsix;

public interface ITelephone {
    void powerOn();

    void dial(int phoneNumber);

    void answer();

    boolean callPhone(int phoneNumber);

    boolean isRinging();

}
