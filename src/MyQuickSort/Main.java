package MyQuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] array = {8, 5, 1, 10, 9, 7, 3, 2, 6, 4};
        int length = array.length;

        System.out.println(Arrays.toString(array));
        quickSort(array, 0, length - 1);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] array, int min, int max){
        if (min > max) return;

        int pivot = array[max];
        int j = min - 1;

        for (int i = min; i < max+1; i++) {
            if (array[i] <= pivot){
                j++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        quickSort(array, min, j - 1 );
        quickSort(array, j + 1, max);
    }
}
