import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Axel on 20/01/2017.
 */
public class TestMainClass {

    // 1. Variable Lambda Expression
    final static String salutation = "Hello ";
    public static void main(String[] args) {

        // 1. Lambda expression
        System.out.println("---- 1. Lambda expression ----");
        GreetingService greetService1 = message -> System.out.println(salutation + message);
        greetService1.sayMessage("Axel");

        // 2. Test ForEach and :: (Constructors using new operator Treeset::new, Static methods, Instance methods)
        System.out.println("---- 2. forEach ----");
        List names = new ArrayList();
        names.add("Axel");
        names.add("Java 8");
        names.forEach(System.out::println);

        // 3. Generating Streams
        // stream() -Returns a sequential stream considering collection as its source.
        // parallelStream() - Returns a parallel Stream considering collection as its source.
        System.out.println("---- 3. Generating Streams ----");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !strings.isEmpty()).collect(Collectors.toList());
        System.out.println("filter: "+filtered);

        // 4. Map
        // The ‘map’ method is used to map each element to its corresponding result. The following code segment prints unique squares of numbers using map
        System.out.println("---- 4. Map ----");
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        List<Integer> squarelist = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
        System.out.println("SquareMap: "+squarelist);

        // 5. filter
        // The ‘filter’ method is used to eliminate elements based on a criteria. The following code segment prints a count of empty strings using filter.
        System.out.println("---- 5. filter ----");
        List<String> stringsFilter = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = stringsFilter.stream().filter(string -> string.isEmpty()).count();
        System.out.println("Count: "+count);

        // 6. limit
        // The ‘limit’ method is used to reduce the size of the stream. The following code segment shows how to print 10 random numbers using limit.
        System.out.println("---- 6. limit ----");
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        // 7. Sorted
        // The ‘sorted’ method is used to sort the stream. The following code segment shows how to print 10 random numbers in a sorted order.
        System.out.println("---- 7. Sorted ----");
        Random randomSorted = new Random();
        randomSorted.ints().limit(10).sorted().forEach(System.out::println);

        // 8. Collectors
        // Collectors are used to combine the result of processing on the elements of a stream. Collectors can be used to return a list or a string.
        System.out.println("---- 8. Collector ----");
        List<String> stringsCollector = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filteredCollectors = stringsCollector.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filteredCollectors);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);

        // 9. Statistics
        // statistics collectors are introduced to calculate all statistics when stream processing is being done
        System.out.println("---- 9. Statistics ----");
        List<Integer> numbersStat = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbersStat.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
