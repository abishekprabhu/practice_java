import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        //String to int()
        List<String> numbers = Arrays.asList("1","2","3");
        IntStream stringToInteger = numbers.stream().mapToInt(Integer::parseInt);
        int[] numberArray = stringToInteger.toArray();
        System.out.println(Arrays.toString(numberArray));


        List<Integer> num1 = Arrays.asList(1,2,43,5,6,4);
        Stream<Integer> output1 =num1.stream().filter((Integer val)-> val>=3).peek(System.out::println);
        System.out.println(output1.toList());

        Object[] filteredNumber = num1.stream().filter((Integer val)-> val > 3)
                .toArray();
        System.out.println(Arrays.stream(filteredNumber).toList());

        Integer[] filteredInteger = num1.stream().filter((Integer val) -> val > 2)
                .toArray(Integer[]::new);

        System.out.println(Arrays.asList(filteredInteger));

        List<?> maxValue = num1.stream().reduce(Integer::max).stream().toList();
        Optional<Integer> sumValue = num1.stream().reduce(Integer::sum);
        Optional<Integer> minValue = num1.stream().reduce(Integer::divideUnsigned);
        Optional<Integer> reducedValue = num1.stream().reduce(Integer::rotateRight);

        System.out.println(maxValue);
        System.out.println(sumValue);
        System.out.println(minValue);
        System.out.println(reducedValue);

        BiFunction<String, String, String> strJoiner = (s1,s2)-> s1 + " " + s2;
        System.out.println(strJoiner.apply("Abishek","Prabhu"));
    }
}
