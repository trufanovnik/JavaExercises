package Generic;

import Generic.Fruit.Apple;
import Generic.Fruit.Fruit;
import Generic.Fruit.Orange;
import Generic.Storage.Box;

public class MyAppGeneric {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> appleBox = new Box<>(10);
        Box<Orange> orangeBox = new Box<>(15);

        appleBox.putFruit(apple);
        orangeBox.putFruit(orange);

        appleBox.compare(orangeBox);

        Box<Apple> appleBox1 = new Box<>(2);
        System.out.println("Вес коробки ИЗ: " + appleBox.getWeight());
        System.out.println("Вес коробки В: " + appleBox1.getWeight());
        appleBox.moveFruitsToAnotherBox(appleBox1);
        System.out.println("Пересыпаем ...........");
        System.out.println("Вес коробки ИЗ: " + appleBox.getWeight());
        System.out.println("Вес коробки В: " + appleBox1.getWeight());
    }
}
