package Generic.Fruit;

public abstract class Fruit {
    float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public abstract float getFruitWeight();
}
