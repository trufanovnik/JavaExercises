package StreamAPI;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {
        //Найти наиболее часто встречающееся слово
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Two");
        list.add("Three");
        list.add("Three");
        list.add("Three");

        Map<String, Long> wordCount = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        String mostFrequentWord = wordCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("Наиболее встречающееся слово: " + mostFrequentWord);
        System.out.println("------------------------");

        //Найти среднюю зарплату сотрудников
        Employee[] employees = new Employee[] {
                new Employee("Bob", 45, 1350.3f),
                new Employee("Alex", 24, 1000.0f),
                new Employee("Nick", 20, 930.5f),
                new Employee("John", 51, 1750.9f),
                new Employee("Howard", 37, 1400.0f)
                };
        Float employeesAverageSalary = Stream.of(employees)
                .map(s -> s.getSalary()).reduce(0f, (a,b) -> a+b/employees.length);
        System.out.println("Средняя зарплата сотрудников: " + employeesAverageSalary);
        System.out.println("------------------------");
    }
}

class Employee{
    private String name;
    private Integer age;
    private Float salary;

    public Employee(String name, Integer age, Float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Float getSalary() {
        return salary;
    }
}