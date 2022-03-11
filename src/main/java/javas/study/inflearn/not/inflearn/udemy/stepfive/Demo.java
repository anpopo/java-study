package javas.study.inflearn.not.inflearn.udemy.stepfive;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

        placesToVisit.add("시드니");
        placesToVisit.add("멜버른");
        placesToVisit.add("브리즈번");
        placesToVisit.add("퍼스");
        placesToVisit.add("캔버라");
        placesToVisit.add("뉴욕");
        placesToVisit.add("다윈");

        printList(placesToVisit);

        placesToVisit.add(1, "삿뽀로");

        printList(placesToVisit);

        placesToVisit.remove(4);

        printList(placesToVisit);

        placesToVisit.clear();

        addInOrder(placesToVisit, "시드니");
        addInOrder(placesToVisit, "브리즈번");
        addInOrder(placesToVisit, "뉴욕");
        addInOrder(placesToVisit, "부에노스아이레스");
        addInOrder(placesToVisit, "브라질시티");
        addInOrder(placesToVisit, "서울");

        printList(placesToVisit);

        visit(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination.");
                return false;
            } else if (comparison > 0) {
                // new city sjould appear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
        }
        stringListIterator.add(newCity);
        return true;

    }

    private static void visit(LinkedList<String> cities) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            return ;
        } else {
            System.out.println("now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday Vacation over");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) listIterator.next();
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("now visiting " + listIterator.next());
                    } else {
                        System.out.println("reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) {
                    if (listIterator.hasNext()) listIterator.previous();
                    goingForward = false;
                }
                    if (listIterator.hasPrevious()) {
                        System.out.println("now visiting " + listIterator.previous());
                    } else {
                        System.out.println("we are at the start of the list");
                        goingForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("available action\n");
        System.out.println("press\n" +
                "0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu option\n");
    }
}
