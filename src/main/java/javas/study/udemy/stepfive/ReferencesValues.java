package javas.study.udemy.stepfive;

import java.util.Arrays;

public class ReferencesValues {
    public static void main(String[] args) {

        // value type 예시
        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println(myIntValue);
        System.out.println(anotherIntValue);

        myIntValue++;

        System.out.println(myIntValue);
        System.out.println(anotherIntValue);

        // reference type 예시
        int[] myIntArray = {1, 2, 3, 4, 5};
        int[] anotherArray = myIntArray;

        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherArray));

        myIntArray[4] = 555;

        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherArray));

        // reference type with method
        modifyArray(anotherArray);

        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherArray));

    }

    private static void modifyArray(int[] array) {
        array[0] = 545;
    }
}
