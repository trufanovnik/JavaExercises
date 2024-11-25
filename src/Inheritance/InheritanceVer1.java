package Inheritance;

import java.util.ArrayList;

class Shape{
    double volume;

    Shape(double volume){
        this.volume = volume;
    }

    public double getVolume(){
        return volume;
    }
}

class SolidOfRevolution extends Shape{
    public double radius;

    SolidOfRevolution(double volume, double radius){
        super(volume);
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
}

class Cylinder extends SolidOfRevolution{
    double height;

    Cylinder(double radius, double height){
        super(Math.PI * radius * radius * height, radius);
        this.height = height;
    }
}

class Ball extends SolidOfRevolution{
    Ball(double radius){
        super(Math.PI * Math.pow(radius, 3) * 4 / 3, radius);
        this.radius = radius;
    }
}
class Pyramid extends Shape{
    double s;
    double h;

    Pyramid(double s, double h){
        super(h * s * 4 / 3);
        this.s = s;
        this.h = h;
    }
}

class Box extends Shape{
    double available;
    ArrayList<Shape> shapes = new ArrayList<>();

    Box(double available){
        super(available);
        this.available = available;

    }
    public boolean add(Shape shape){
        if (available >= shape.getVolume()){
            shapes.add(shape);
            available -= shape.getVolume();
            return true;
        }else {
            return false;
        }
    }
}

public class InheritanceVer1 {
    public static void main(String[] args) {
        Box box = new Box(100);
        Shape pyramid = new Pyramid(5, 3);
        SolidOfRevolution ball = new Ball(2);
        SolidOfRevolution cylinder = new Cylinder(10, 26);

        System.out.println(box.add(pyramid));
        System.out.println(box.add(ball));
        System.out.println(box.add(cylinder));
    }
}
