package javas.study.inflearn.not.inflearn.udemy.stepeight;

public class ExtendedPassword extends Password{
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

}
