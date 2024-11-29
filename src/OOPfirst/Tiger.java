package OOPfirst;

public class Tiger extends Animals{
    protected static int tigersCount = 0;
    public Tiger(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
        tigersCount++;
    }
}
