package MyException;

import java.util.Arrays;

public class MyApp {
    public static void main(String[] args) {
        String [][] array;
        array = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "1-"},
                {"13", "14", "15", "16"}
        };
        try {
            System.out.println(sum(array, 4, 4));
        } catch (ArraySizeException e) {
            System.err.println(e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println(e.getMessage());
        }

    }
    public static void checkedRequiredArraySize(String[][] arr, int colSize, int rowSize) throws ArraySizeException {
        int nColumn = 0;
        int[] nRow = new int[colSize];

        for (int i = 0; i < arr.length; i++) {
            nColumn++;
            for (int j = 0; j < arr[i].length; j++) {
                nRow[i]++;
            }
            if (nRow[i] != rowSize){
                throw new ArraySizeException("Кол-во столбцов массива не совпадает с требуемым");
            }
        }
        if (nColumn != colSize){
            throw new ArraySizeException("Кол-во строк массива не совпадает с требуемым");
        }
    }

    public static int sum(String[][] arr, int colSize, int rowSize) throws ArraySizeException, ArrayDataException {
        checkedRequiredArraySize(arr, colSize, rowSize);
        int sumValue = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sumValue += Integer.valueOf(arr[i][j]);
                } catch (NumberFormatException e){
                    throw new ArrayDataException(i, j, arr);
                }
            }
        }
        return sumValue;
    }
}
