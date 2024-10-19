import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Streamm {
    public static void main(String...args) {
        List<String> fruits = List.of("A", "BB", "C");
        Stream<String> stream = fruits.stream();


        // stream.forEach((fruit) -> {
        //     System.out.println(fruit);
        // });

        stream
            .filter(fruit -> fruit.length() > 0)
            .map(fruit -> fruit.length())
            .map(fruitLen -> fruitLen * 2)
            .forEach(
                // (fruit) -> System.out.println(fruit)
                System.out::println
            );

        // List<Integer> temp = stream
        //     .map(fruit -> fruit.length())
        //     .collect(Collectors.toList());
    }
    
}
