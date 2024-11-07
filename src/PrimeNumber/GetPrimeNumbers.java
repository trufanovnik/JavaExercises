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
            boolean isPrime = true;
            for(int j = 2; j < number; j++){
                if(number % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(number);
            }
        }
    }
}
