package MaxMinAverage;

public class MaxMinAverage {
    InitArray initArray = new InitArray();
    float[] array = initArray.fillArray();

    float min, max, average;

    {
        min = array[0];
        max = array[0];
        average = 0.0f;
    }

    public MaxMinAverage() {
        for (float element : array) {
            if (max < element)
                max = element;
            if (min > element)
                min = element;
            average += element / array.length;
        }
    }

    public void showMaxMinAverage(){
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + average);
    }
}
