package ReflectionAPI;

public class Cat {
    private String name;

    Cat(){}
    public Cat(String name){
        this.name = name;
    }

    private void privateMeow(){
        System.out.println("private meow!");
    }
}
