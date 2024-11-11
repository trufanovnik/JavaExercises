package Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(1.0f, 2.0f, 3.0f);
        Vector vector1 = new Vector(2f, 2f, 2f);
        System.out.println(Arrays.toString(Vector.createVectors(5)));
    }
}
