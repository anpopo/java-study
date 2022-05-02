package javas.study.udemy.steptenio;

import java.util.Scanner;

public class AdventureMain {
    private static Locations locations = new Locations();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int loc = 1;
        while(loc != 0) {
            Location location = locations.get(loc);
            System.out.println(location.getDescription());

            System.out.print("Available exits are ");
            for (String exit : location.getExits().keySet()) {
                System.out.print(exit + ",");
            }
            System.out.println();


            loc = sc.nextInt();
            sc.nextLine();

            if (!locations.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
                loc = 0;
            }
        }
    }
}
