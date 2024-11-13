package BinarySearch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] array = generateArray(1000000);
        Arrays.sort(array);

        long time = System.currentTimeMillis();
        bruteForce(array, 0.7);
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        binarySearch(array, 0.7, 0, array.length - 1);
        System.out.println(System.currentTimeMillis() - time);

        double[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        double value = 20;
        System.out.println(binarySearch(sortedArray, value, 0, (sortedArray.length - 1)));
    }

    private static boolean binarySearch(double[] array, double value, int from, int to){
        if (from > to)
            return false;

        int mid = from + (to - from)/2;

        if(value == array[mid]) {
            return true;
        } else if(value > array[mid]) {
            return binarySearch(array, value, mid + 1, to);
        } else {
            return binarySearch(array, value, from, mid - 1);
        }
    }
    private static boolean bruteForce(double[] array, double value){
        for (double v : array) {
            if (v == value)
                return true;
        }
        return false;
    }
    public static double[] generateArray(int numbers){
        double[] array = new double[numbers];
        for (int i=0; i < numbers; i++){
            array[i] = Math.random();
        }
        return array;
    }
}
