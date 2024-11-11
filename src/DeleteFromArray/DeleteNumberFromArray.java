package DeleteFromArray;

import java.util.Arrays;

public class DeleteNumberFromArray {
    public static int[] deleteNumberFromArray(int[] array, int number){
        int [] modifiedArray;
        int modifiedArraySize;
        int counter = 0;

        for(int element : array){
            if(element == number){counter++;}
        }
        modifiedArraySize = array.length - counter;
        modifiedArray = new int[modifiedArraySize];

        for (int i = 0, j = 0; i < modifiedArraySize;) {
            if(array[j] != number){
                modifiedArray[i] = array[j];
                j++;
                i++;
            } else {
                j++;
            }
        }
        System.out.println(Arrays.toString(modifiedArray));
        return modifiedArray;
    }
}
