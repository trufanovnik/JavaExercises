package Inheritance;

import java.util.ArrayList;

interface ShapeV3 extends Comparable<ShapeV3>{
    double getVolumeV3();

    @Override
    default int compareTo(ShapeV3 otherShape){
        return Double.compare(getVolumeV3(), otherShape.getVolumeV3());
    }
}
abstract class SolidV3 implements ShapeV3{
    protected double radius;

    SolidV3(double radius){
        this.radius = radius;
    }

    public double getRadiusV3(){
        return radius;
    }
}

class BallV3 extends SolidV3{
    BallV3(double radius){
        super(radius);
    }
    public double getVolumeV3(){
        return (Math.PI * Math.pow(radius, 3) * 4 / 3);
    }
}

class BoxV3 implements ShapeV3{
    private ArrayList<ShapeV3> shapes = new ArrayList<>();
    private double availableV3;
    private double volume;

    BoxV3(double available){
        this.availableV3 = available;
        this.volume = available;
    }

    public boolean addV3(ShapeV3 shape) {
        if (availableV3 >= shape.getVolumeV3()) {
            shapes.add(shape);
            availableV3 -= shape.getVolumeV3();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getVolumeV3(){
        return volume;
    }
}

public class InheritanceVer3 {
    public static void main(String[] args) {
        BoxV3 boxV3 = new BoxV3(100);
        BallV3 ballV3 = new BallV3(2.2);

        System.out.println(boxV3.addV3(ballV3));
        System.out.println(boxV3.addV3(ballV3));
        System.out.println(boxV3.addV3(ballV3));
        System.out.println(boxV3.addV3(ballV3));
    }
}
