package OOPSecond;

public class Cat implements Actions{
    private String name;
    private double maxJumpHeight;
    private double maxRunDistance;

    Cat(String name ,double maxJumpHeight, double maxRunDistance){
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }
    @Override
    public boolean jump(double height){
        if (maxJumpHeight >= height){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean run(double distance){
        if (maxRunDistance >= distance){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public String toString(){
        return name;
    }
}
