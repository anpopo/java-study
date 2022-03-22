package javas.study.inflearn.not.inflearn.udemy.stepeight;

import java.util.Scanner;

public class StepEightMain {

    public static void main(String[] args) {
//        MyWindow myWindow = new MyWindow("Complete Java");
//        myWindow.setVisible(true);

        String var4 = "this is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
//        System.out.println("scopeInstance.getPrivateVar() = " + scopeInstance.getPrivateVar());
//        System.out.println(var4);
//
//
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
//        innerClass.timesTwo();


        System.out.println("******************************************************");
        scopeInstance.useInner();
        System.out.println("var3 is not accessible here " + innerClass.getVar3());


        Scanner sc = new Scanner(System.in);
        X x = new X(sc);
        x.x();

    }
}
