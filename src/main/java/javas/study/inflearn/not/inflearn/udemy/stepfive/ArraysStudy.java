package javas.study.inflearn.not.inflearn.udemy.stepfive;

public class ArraysStudy {

    public static void main(String[] args) {
        int[] intArray = new int[10];

        intArray[5] = 15;
        intArray[2] = 12;

        int[] intArrays = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < intArrays.length; i++) {
            System.out.println(intArrays[i]);
        }
    }
}
