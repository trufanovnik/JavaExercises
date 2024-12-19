package Collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainAppCollection {
    public static void main(String[] args) {
        /*
        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
        вывести список уникальных слов, из которых состоит массив.
        Посчитать, сколько раз встречается каждое слово.
        */
        HashMap<String, Integer> countMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        String[] array = {"Раз", "раз", "два", "три", "три", "три", "четыре", "пять", "пять", "шесть", "семь"};
        for (String el: array){
            wordSet.add(el);
            if (countMap.containsKey(el)){
                countMap.put(el, countMap.get(el) + 1);
            }else {
                countMap.put(el, 1);
            }
        }
        System.out.println(wordSet);
        System.out.println(countMap);

        PhoneBook.add("Nik", "+1111111");
        PhoneBook.add("Nik", "+2222222");
        PhoneBook.add("Nik", "+3333333");
        PhoneBook.add("Kin", "+4444444");
        PhoneBook.get("Nik");
        PhoneBook.get("Kin");
        PhoneBook.get("NONE");
    }
}
        /*
        Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
        телефонных номеров. В этот телефонный справочник с помощью метода add() можно
        добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
        учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        тогда при запросе такой фамилии должны выводиться все телефоны.
         */
class PhoneBook {
    private static HashMap<String, Set<String>> pB = new HashMap<>();

    public static void add(String name, String number){
        if (pB.containsKey(name)){
            pB.get(name).add(number);
        }else {
            Set<String> setOfNumbers = new HashSet<>();
            setOfNumbers.add(number);
            pB.put(name, setOfNumbers);
        }
    }
    public static void get(String name){
        if (pB.containsKey(name)){
            System.out.println(pB.get(name));
        }
    }
}
