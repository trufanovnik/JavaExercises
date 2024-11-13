package BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int value = 2;
        System.out.println(binarySearch(array, value, 0, (array.length - 1)));
    }

    public static boolean binarySearch(int[] array, int value, int from, int to){
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
}
