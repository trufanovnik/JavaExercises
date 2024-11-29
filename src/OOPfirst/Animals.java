package OOPfirst;

abstract class Animals {
    protected static int animalsCount = 0;
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;

    public Animals(String name,int maxRunDistance, int maxSwimDistance) {
        animalsCount++;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    void run(int distance){
        if (maxRunDistance >= distance){
            System.out.println(name + ' ' + "пробежал" + ' ' + distance + "метров.");
        } else {
            System.out.println("Слишком большая дистанция для " + name +
                    ' ' + "! Максимум:" + maxRunDistance + "метров.");
        }
    }
    void swim(int distance){
        if (maxSwimDistance >= distance){
            System.out.println(name + ' ' + "проплыл" + ' ' + distance + "метров.");
        } else {
            System.out.println("Слишком большая дистанция! Максимум:" + maxSwimDistance + "метров.");
        }
    }
}
