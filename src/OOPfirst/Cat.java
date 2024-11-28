package OOPfirst;

public class Cat extends Tiger{
    public Cat(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
    }

    @Override
    void swim(int distance) {
        System.out.println(name + ' ' + "Не умеет плавать :(");
    }
}
