package javas.study.inflearn.not.inflearn.udemy.stepfive;

import java.util.Arrays;

public class ReverseArray {


    public static void main(String[] args) {
        int[] array = {1, 5, 9, 11, 4,2,14};

        System.out.println(Arrays.toString(array));

        reverse(array);

        System.out.println(Arrays.toString(array));

    }



    public static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }

}
