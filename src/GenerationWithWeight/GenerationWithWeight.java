package GenerationWithWeight;

public class GenerationWithWeight {
    private int[] values;
    private int[] weights;
    private int min;
    private int max;

    public GenerationWithWeight(int[] values, int[] weights) {
        this.values = values;
        this.weights = weights;
    }

    public void maxMinWeight(){
        min = weights[0];
        max = weights[0];
        for (int element : weights) {
            if (max < element)
                max = element;
            if (min > element)
                min = element;
        }
    }

    public int createRandom(){
        maxMinWeight();
        int target = (int) (min + Math.random()*(max - min));
        return target;
    }

    public int returnRandomValue(){
        int target = createRandom();
        int i;
        for (i = 0; i < weights.length; i++) {
            if(weights[i] >= target)
                break;
        }
        return values[i];
    }
}
