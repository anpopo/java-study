package javas.study.inflearn.not.inflearn.udemy.stepseven;

import javas.study.inflearn.java8.interfacemethod.Foo;

import java.util.ArrayList;
import java.util.Collections;

public class GenericMain {
    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);
        items.add(6);

        printDouble(items);


        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer ham = new SoccerPlayer("Ham");

        Team<Player> gogochche1 = new Team<>("GoGo chche");
        gogochche1.addPlayer(joe);
        gogochche1.addPlayer(pat);
        gogochche1.addPlayer(ham);


    }

    private static void printDouble(ArrayList<Integer> items) {
        for (Integer item : items) {
            System.out.println(item  );
        }
    }
}
