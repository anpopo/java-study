package javas.study.inflearn.not.inflearn.udemy.thridcontrolflow;

public class PrimeNumberCheck {
    public boolean isPrime(int n) {
        if (n == 1) return false;

        for (int i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
