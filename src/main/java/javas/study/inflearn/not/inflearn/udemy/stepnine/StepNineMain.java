package javas.study.inflearn.not.inflearn.udemy.stepnine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StepNineMain {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("CGV", 8, 12);
//        ArrayList<Theatre.Seat> seats = new ArrayList<Theatre.Seat>(theatre.getSeats());
//        printList(seats);
//        Collections.shuffle(seats);
//        System.out.println("after shuffling");
//        printList(seats);
//
//        sortList(seats);
//        System.out.println("after sort");
//        printList(seats);

        printList(theatre.getSeats());

        List<Theatre.Seat> priceSeat = new ArrayList<>(theatre.getSeats());
        priceSeat.sort(Theatre.PRICE_ORDER);
        printList(priceSeat);

    }

    public static void printList (Collection<? extends Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("=============================================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
