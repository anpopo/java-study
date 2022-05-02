package javas.study.udemy.stepfive;

import java.util.Scanner;

public class MinimumElementArray {

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("enter count : ");
        int count = sc.nextInt();
        sc.nextLine();

        int[] returnedArray = readIntegers(count);
        int returnedMin = findMin(returnedArray);
        System.out.println(returnedMin);

    }

    private static int[] readIntegers(int count) {
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

}
