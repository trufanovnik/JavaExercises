package DeleteFromArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] array = {0, 1, 2, 3, 4, 5, 5, 7, 5, 5, 10};

        GetNumber getNumber = new GetNumber();
        int number = getNumber.getNumber();
        System.out.println("Изначальный массив: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Измененный массив: ");
        DeleteNumberFromArray.deleteNumberFromArray(array, number);
    }
}
