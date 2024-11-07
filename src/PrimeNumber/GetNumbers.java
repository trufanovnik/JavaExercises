package PrimeNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetNumbers {
    public static void getNumbers() {
        ArrayList<Integer> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    list.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Введите корректное число.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
