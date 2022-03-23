package javas.study.inflearn.not.inflearn.udemy.stepeight;

public class Password {
    private static final int key = 58129412;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password) {
        return password ^ key;
    }

    public final void storePassword() {
        System.out.println("saving password as " + encryptedPassword);

    }

    public boolean letMeIn(int password) {
        if (encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        }
        System.out.println("Bye");
        return false;
    }

}
