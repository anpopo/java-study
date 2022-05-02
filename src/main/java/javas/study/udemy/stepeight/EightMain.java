package javas.study.udemy.stepeight;

import javas.study.udemy.stepeight._static.StaticTest;

public class EightMain {

    public static int multiplier = 7;

    public static void main(String[] args) {
//        for (int i = 0; i <= 10; i++) {
//            System.out.println(Series.nSum(i));
//        }
//        for (int i = 0; i <= 10; i++) {
//            System.out.println(Series.factorial(i));
//        }
//        for (int i = 0; i <= 10; i++) {
//            System.out.println(Series.fibonacci(i));
//        }

        Account wealthyAccount = new Account("Sehyeong");

        wealthyAccount.deposit(1000);
        wealthyAccount.withdraw(500);
        wealthyAccount.withdraw(-200);
        wealthyAccount.deposit(-20);
        wealthyAccount.calculateBalance();


        StaticTest firstInstance = new StaticTest("first instance");
        System.out.println(StaticTest.getNumInstances() + " / " + firstInstance.getName());

        StaticTest secondInstance = new StaticTest("Second instance");
        System.out.println(StaticTest.getNumInstances() + " / " + secondInstance.getName());


        int answer = multiply(5);
        System.out.println("the answer is " + answer);
        System.out.println("multiplier is " + multiplier);

        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");


        int pw = 12345;
        Password password = new Password(pw);
        password.storePassword();
        password.letMeIn(12345);
        password.letMeIn(12345555);

    }

    public static int multiply (int number) {
        return number * multiplier;
    }
}
