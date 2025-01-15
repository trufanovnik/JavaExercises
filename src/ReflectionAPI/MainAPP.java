package ReflectionAPI;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainAPP {
    public static void main(String[] args){

        System.out.println("Рекурсивный вызов суперкласса:");
        getSuperRecursive(ArithmeticException.class);
        System.out.println("-------------------------");

        System.out.println("Доступ и изменение приватного поля:");
        Cat cat = new Cat("BARSIK");
        Class catClass = Cat.class;
        Field[] catFields = catClass.getDeclaredFields();
        Method[] catMethods = catClass.getDeclaredMethods();
        try {
            for (Field o : catFields){
                o.setAccessible(true);
                System.out.println(o.get(cat));
                o.set(cat, "Котик");
                System.out.println(o.get(cat));
            }
            System.out.println("-------------------------");

            System.out.println("Вызов приватного метода:");
            catMethods[0].setAccessible(true);
            catMethods[0].invoke(cat);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------");

        System.out.println("Создание нового экземпляра класса:");
        try {
            //Для дефолтного конструктора
            Cat cat1 = (Cat)catClass.newInstance();
            Field cat1Name = catClass.getDeclaredField("name");
            cat1Name.setAccessible(true);
            cat1Name.set(cat1, "Cat1");
            System.out.println("Имя нового кота: " + cat1Name.get(cat1));
            //Для определенного контруктора (в параметрах укажем классы аргументов)
            Cat cat2 = (Cat)catClass
                    .getConstructor(String.class)
                    .newInstance("Cat2");
            Field cat2Name = catClass.getDeclaredField("name");
            cat2Name.setAccessible(true);
            System.out.println("Имя нового кота: " + cat2Name.get(cat2));

        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getSuperRecursive(Class first){
        if(first.getSuperclass() != null){
            System.out.println(first.getSuperclass().getSimpleName());
            Class next = first.getSuperclass();
            getSuperRecursive(next);
        }
    }
}
