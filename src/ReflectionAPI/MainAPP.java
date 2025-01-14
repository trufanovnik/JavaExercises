package ReflectionAPI;

public class MainAPP {
    public static void main(String[] args){
        getSuperRecursive(ArithmeticException.class);
    }

    public static void getSuperRecursive(Class first){
        if(first.getSuperclass() != null){
            System.out.println(first.getSuperclass().getSimpleName());
            Class next = first.getSuperclass();
            getSuperRecursive(next);
        }
    }
}
