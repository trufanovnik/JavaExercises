package GenerationWithWeight;

public class Main {
    public static void main(String[] args) {
        GenerationWithWeight gww = new GenerationWithWeight(new int[]{3, 6, 12, 15}, new int[]{9, 15, 35, 47});
        System.out.println(gww.returnRandomValue());
    }
}
