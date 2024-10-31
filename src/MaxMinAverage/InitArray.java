package MaxMinAverage;

public class InitArray {
    float[] myArray = new float[10];

    public float[] fillArray(){
        for(int i = 0; i < myArray.length; i++) {
            myArray[i] = (float) Math.random();
        }
        return myArray;
    }
}
