package StreamAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
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
        System.out.println(mostFrequentWord);
    }
}