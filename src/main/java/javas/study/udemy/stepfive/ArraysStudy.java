package javas.study.udemy.stepfive;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysStudy {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        int[] intArrays = getIntegers();

        printArray(intArrays);

        int[] sortedArray = sortIntegers(intArrays);

        printArray(sortedArray);

    }

    private static int[] getIntegers() {
        int[] array = new int[sc.nextInt()];
        System.out.println("enter your number");
        for (int i = 0; i< array.length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            System.out.println("element " + i + " = " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
//        int[] sortedArray = new int[array.length];
//
//        for (int i = 0; i < array.length; i++) {
//            sortedArray[i] = array[i];
//        }
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;

        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
