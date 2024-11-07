package PrimeNumber;

import java.util.ArrayList;

public class GetPrimeNumbers {
    public ArrayList<Integer> listOfNumbers;

    public GetPrimeNumbers(ArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    public void setListOfNumbers(ArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    public void getPrimeNumbers(){
        for (int number : listOfNumbers){
            if(number % number == 0){
                System.out.println(number);
            }
        }
    }
}
