package OOPfirst;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animals> animals = new ArrayList<>();

        int countCats = 0;
        int countTigers = 0;
        int countDogs = 0;

        animals.add(new Cat("Barsik", 200, 0));
        animals.add(new Dog("Bobik", 500, 10));
        animals.add(new Tiger("Sherkhan", 350, 20));
        animals.add(new Cat("Pasha", 350, 20));
        animals.add(new Dog("Dusya", 350, 20));
        animals.add(new Dog("Gerda", 400, 10));

        for (Animals animal : animals){
            switch (animal){
                case Dog d -> ++countDogs;
                case Cat c -> ++countCats;
                case  Tiger t -> ++countTigers;
                default -> throw new IllegalStateException("Unexpected value: " + animal);
            }
            animal.run(180);
            animal.swim(10);
        }
        System.out.println("Кол-во собак: " + countDogs);
        System.out.println("Кол-во котов: " + countCats);
        System.out.println("Кол-во тигров: " + countTigers);
    }
}
