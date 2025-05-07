import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TypesOfFunctionalInterfaceExample {
    public static void main(String[] args) {
        Consumer<String> consumer = (input)-> System.out.println("Consumed" + input);
        consumer.accept("Consumer takes single input returns no output");

        Supplier<String> supplier = ()-> "Supplier returns only output";
        System.out.println(supplier.get());

        //Function takes single input and return output.
        Function<Integer,String> function = (number)-> "Number is" + number;
        System.out.println(function.apply(19));

        //Predicate Returns only boolean type output.
        Predicate<Integer> predicate = (n) ->
            n%2 == 0;

        System.out.println(predicate.test(10));
        System.out.println(predicate.test(9));
    }
}
