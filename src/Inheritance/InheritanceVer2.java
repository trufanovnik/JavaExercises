package Inheritance;

//использование абстрактного класса
import java.util.ArrayList;

abstract class ShapeV2{
    public abstract double getVolumeV2();
}
abstract class SolidOfRevolutionV2 extends ShapeV2{
    protected double radius;

    SolidOfRevolutionV2(double radius){
        this.radius = radius;
    }
    public double getRadiusV2(){
        return radius;
    }
}

class BallV2 extends SolidOfRevolutionV2{

    @Override
    public double getVolumeV2() {
        return Math.PI * Math.pow(radius, 3) * 4 / 3;
    }

    BallV2(double radius){
        super(radius);
    }
}

class BoxV2 extends ShapeV2{
    private double availabelV2;
    private double volumeV2;
    ArrayList<ShapeV2> shapesV2 = new ArrayList<>();

    BoxV2(double availabelV2){
        this.availabelV2 = availabelV2;
        this.volumeV2 = availabelV2;
    }

    public boolean addV2(ShapeV2 shapeV2){
        if(availabelV2 >= shapeV2.getVolumeV2()){
            shapesV2.add(shapeV2);
            availabelV2 -= shapeV2.getVolumeV2();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getVolumeV2() {
        return volumeV2;
    }
}

public class InheritanceVer2 {
    public static void main(String[] args) {
        BoxV2 boxV2 = new BoxV2(100);
        BallV2 ballV2 = new BallV2(2.2);

        System.out.println(boxV2.addV2(ballV2));
        System.out.println(boxV2.addV2(ballV2));
        System.out.println(boxV2.addV2(ballV2));
        System.out.println(boxV2.addV2(ballV2));
    }
}
