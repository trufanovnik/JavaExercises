package Generic.Storage;

import Generic.Fruit.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit>{
    private final float boxCapacity;
    private float freeVolume;
    private ArrayList<T> fruits = new ArrayList<>();

    public Box(float boxCapacity){
        this.boxCapacity = boxCapacity;
        freeVolume = boxCapacity;
    }

    public ArrayList<T> getFruits() {return fruits;}
    public float getWeight(){return (boxCapacity - freeVolume);}
    public float getFreeVolume(){return freeVolume;}

    public void putFruit(T fruit){
        if (freeVolume >= fruit.getFruitWeight()){
            fruits.add(fruit);
            freeVolume = freeVolume - fruit.getFruitWeight();
        }else {
            System.out.println("В коробке недостаточно места!");
        }
    }

    public boolean compare(Box<?> another){
        if (this.getWeight() == another.getWeight()) {
            System.out.println("Коробки одинакогового веса");
            return true;
        }
        System.out.println("Коробки разного веса");
        return false;
    }

    public void moveFruitsToAnotherBox(Box<T> another){
        if (another.getFreeVolume() >= this.getWeight()){
            another.getFruits().addAll(this.getFruits());
            another.freeVolume -= this.getWeight();
            this.freeVolume = this.boxCapacity;
            this.getFruits().clear();
        }else {
            System.out.println("В коробке недостаточно места.");
        }
    }
}
