package OOPfirst;

public class Cat extends Tiger{
    protected static int catsCount = 0;
    public Cat(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
        tigersCount--;
        catsCount++;
    }

    @Override
    void swim(int distance) {
        System.out.println(name + ' ' + "Не умеет плавать :(");
    }
}
