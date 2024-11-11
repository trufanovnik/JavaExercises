package Vector;

import java.util.Random;

public class Vector {
    private float x = 0.0f;
    private float y = 0.0f;
    private float z = 0.0f;

    public Vector(){}

    public Vector(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public static Vector[] createVectors(int n){
        Vector[] arrayOfVectors = new Vector[n];
        Random r = new Random();
        int counter = 0;

        while ( counter  < n ) {
            float x = r.nextFloat() * n;
            float y = r.nextFloat() * n;
            float z = r.nextFloat() * n;
            if (Math.sqrt(x * x + y * y + z * z) < n) {
                arrayOfVectors[counter] = new Vector(x, y, z);
                counter++;
            }
        }
        return arrayOfVectors;
    }

    public float vectorLength(){
        return (float) Math.sqrt(x*x + y*y + z*z);
    }

    public float scalarProduct(Vector v){
        return x*v.getX() + y*v.getY() + z*v.getZ();
    }

    public Vector vectorsProduct(Vector v){
        float firstCoordinate = y * v.getZ() - z * v.getY();
        float secondCoordinate = z * v.getX() - x * v.getZ();
        float thirdCoordinate = x * v.getY() - y * v.getZ();
        return new Vector(firstCoordinate, secondCoordinate, thirdCoordinate);
    }

    public float angleVectors(Vector v){
        return scalarProduct(v)/(Math.abs(vectorLength())*Math.abs(v.vectorLength()));
    }

    public Vector additionVectors(Vector v){
        float firstCoordinate = x + v.getX();
        float secondCoordinate = y + v.getY();
        float thirdCoordinate = z + v.getZ();
        return new Vector(firstCoordinate, secondCoordinate, thirdCoordinate);
    }

    public Vector subtractionVectors(Vector v){
        float firstCoordinate = x - v.getX();
        float secondCoordinate = y - v.getY();
        float thirdCoordinate = z - v.getZ();
        return new Vector(firstCoordinate, secondCoordinate, thirdCoordinate);
    }
}
