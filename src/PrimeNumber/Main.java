package PrimeNumber;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GetNumbers.getNumbers();
        ArrayList<Integer> list = GetNumbers.list;
        GetPrimeNumbers gP = new GetPrimeNumbers(list);
        gP.getPrimeNumbers();
    }
}
