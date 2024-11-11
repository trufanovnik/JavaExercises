package DeleteFromArray;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetNumber {
    public int getNumber() {
        int number;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целое число 0-10: ");
        while (true){
            try {
                number = in.nextInt();
                if (number >= 0 && number <= 10){
                    break;
                } else {
                    System.out.println("Число д.б. от 0 до 10. Попробуйте снова:");
                }
            } catch (InputMismatchException e){
                System.out.println("Введите корректное число: ");
                number = Integer.parseInt(in.next());
            }
        }
        return number;
    }
}
