package OOPfirst;

public class Dog extends Animals{
    protected static int dogsCount = 0;
    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
        dogsCount++;
    }
}
