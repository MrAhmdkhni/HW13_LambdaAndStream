package question_2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Amir", "Hatef", "Mehran",
                "Mojtaba", "Mohammad", "Ali", "Davood", "Reza", "Mohsen"));

        Map<Integer, List<String>> namesByMap = new HashMap<>(); //????????????

        Function<String, Integer> function = word -> word.length();

        namesByMap = names.stream().collect(Collectors.groupingBy(function));
        // equal above
        // namesByMap = names.stream().collect(Collectors.groupingBy(word -> word.length()));

        System.out.println(namesByMap.values());
        System.out.println(namesByMap);

        for (List value: namesByMap.values()) {
            System.out.println(value.size() +" = "+ value);
        }
    }
}
