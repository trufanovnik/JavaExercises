package DictionaryWithMap;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DictionaryWithMap {
    public static void main(String[] args) {
        HashMap<Character, Integer> dictionary = new HashMap<>();
        FileInputStream fis;
        InputStreamReader isr;
        String filePath = "src/DictionaryWithMap/text.txt";
        int b;
        try {
            fis = new FileInputStream(filePath);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            while ((b = isr.read()) != -1){
                char ch = Character.toLowerCase((char)b);
                if (ch == ' ') {
                    ch = '_';
                } else if (ch == '\n') {
                    ch = '\\';
                }
                if(dictionary.containsKey(ch)){
                    dictionary.put(ch, dictionary.get(ch) + 1);
                }else{
                    dictionary.put(ch, 1);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(dictionary.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<Character, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
