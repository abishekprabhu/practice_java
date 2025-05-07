import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Widgets> widget = createWidgets();

        Set<Widgets> rowRed = widget.stream().filter(e->e.getColor().equals("Red")).collect(Collectors.toSet());
        Function<Widgets,Integer> weightExtractor = widgets -> widgets.getWeight();
        Set<Integer> redweight = widget.stream().filter(e->e.getColor().equals("Red")).map(weightExtractor).collect(Collectors.toSet());
        System.out.println(rowRed);
        System.out.println(redweight);

        final int max = widget.stream().peek(System.out::println).filter(w-> w.getWeight()>69).mapToInt(Widgets::getWeight).max().getAsInt();
        System.out.println(max);



        List<String> strings = Arrays.asList("apple", "Orange", "apple", "Kiwi", "banana", "apple", "banana");

        // first method:
        Map<String, Long> duplicates = strings.stream()
                .filter(e -> Collections.frequency(strings,e)>1)
                .peek(System.out::println)
                // .filter(ent -> Collections.frequency(strings, ent) > 1)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting())) // Group and count each
                // string
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Filter for duplicates
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); // Collect into a
        // map

        System.out.println("Duplicate values with their counts: " + duplicates);
        // same answer 2nd method

        Map<String, Long> duplicate = strings.stream().filter(ent -> Collections.frequency(strings, ent) > 1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Duplicate values with their counts: " + duplicate);

        // 3rd method same answer but additionaly used in sorted entry set and
        // collections.

        Map<String, Long> duplicated = strings.stream()
            //    .filter(s -> Collections.frequency(strings, s) > 1) // Filter elements that appear more
                // than once
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Group and
                // count
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue()) // Sort by count, default asending
                // if you want to sorted desending
                // .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder))
                // if you want to compare by key using below method
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue

                        // not needed below is binary operators.
                        // (e1, e2) -> e1, // Handle duplicates (not needed here but required by toMap)
                        // LinkedHashMap::new // Preserve the sorted order
                ));

        System.out.println("Duplicate values with their counts (sorted by count): " + duplicated);

        // only print the duplicated value without counting.
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        Set<String> duplicat = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(duplicat); // Output: [apple, banana]

        // fetch the string using certain condition and that string is upper case
        List<String> upperstring = Arrays.asList("Apple", "Apple", "Avacado", "Banana");
        List<String> resultupperstring = upperstring.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Uppercase output with starts with A: " + resultupperstring);

        // list of integer comparator
        List<Integer> numbers = Arrays.asList(23, 45, 67, 21, 34);
        Optional<Integer> max1 = numbers.stream().max((a, b) -> a.compareTo(b));

        System.out.println("Compare the maximum number : " + max1.get());

        // print the list of string as reverse order
        numbers = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Reverse order integer : " + numbers);

        // findfirst()
        Optional<String> findFirst = upperstring.stream().findFirst();
        System.out.println("Find first value : " + findFirst.get());

        // findAny()
        Optional<String> findany = upperstring.stream().findAny();
        System.out.println("Find Any value : " + findany.get());

        // reduce is used to perform aggregation operations (like sum, product) on
        // The reduce method takes a binary operator to combine two elements.
        // elements of the stream.
        List<Integer> number = Arrays.asList(1, 2, 8, 4);
        int sum = number.stream().reduce(0, Integer::sum);
        int sumss = number.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sumss);
        System.out.println(sum); // Output: 10

        // reduce method also perform as double object and string data type also.
        String resultStr = upperstring.stream().reduce((accumulator, results) -> accumulator + results)
                .orElse("");
        System.out.println("Sum of string : " + resultStr);

        // with special charators
        resultStr = upperstring.stream().reduce((accumulator, results) -> accumulator + " , " + results)
                .orElse("");
        System.out.println("Sum of string : " + resultStr);

        // finding longest word
        resultStr = upperstring.stream().reduce((a, b) -> a.length() > b.length() ? a : b).orElse("");
        System.out.println("longest of string : " + resultStr);

        // also we can use joining instead of reduce method in string functions only
        resultStr = upperstring.stream().collect(Collectors.joining(", "));
        System.out.println("longest of string : " + resultStr);
        // output: Apple, Apple, Avacado, Banana

        // mapping
        upperstring = upperstring.stream().map(String::toUpperCase).collect(Collectors.toList());
        // flat map

        System.out.println("Mapping to change upper case of string : " + upperstring);

        // count the each charactors in string value using stream//ithuve list of string
        // na using filter and entry set or frequency
        String cha = "Kalaivani";
        Map<Character, Long> charcount = cha.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // only
                // without
                // sorting
                // sorting not working..need to check
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Charators with count in single string : " + charcount);

        // skip and limit method
        List<Integer> num = number.stream().skip(4).limit(2).collect(Collectors.toList());
        System.out.println(num);

        // partion a list of numbers into add or even.
        Map<Boolean, List<Integer>> partitioned = number.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned);
        partitioned.get(true); //for even number.
        partitioned.get(false);// for odd number.

        // we can create infinite stream or list using generated or iterated
        Stream<Integer> ints = Stream.iterate(1, n -> n + 1);

        List<Integer> iteratevalue = ints.limit(10).collect(Collectors.toList());
        System.out.println(iteratevalue);

        // To find a common employee list usring stream and set
        // we also merge the two sets and we can find the duplicate using gorup by and
        // collections frequency
        List<String> list1 = Arrays.asList("Kalaivani", "kannan", "Raja", "Geetha");
        List<String> list2 = Arrays.asList("Kalaivani", "kannan", "Chandur", "Harsha");

        List<String> finallist = list2.stream()
                .filter(emp -> list1.contains(emp))
                .collect(Collectors.toList());

        System.out.println("Final join to list and fetch the common : " + finallist);

        // combine two list and remove duplicates by id na
        // List<Employee> combinedList = Stream.concat(list1.stream(), list2.stream())
        // .collect(Collectors.toMap(
        // Employee::getId, // Use Employee `id` as key
        // emp -> emp, // Use the Employee object as the value
        // (emp1, emp2) -> emp1 // If duplicate, keep the first occurrence
        // )).values().stream().collect(Collectors.toList());

        // System.out.println("Combined List without duplicates: " + combinedList);

        List<String> finals = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());

        List<String> finalss = finals.stream().filter(ent -> (Collections.frequency(finals, ent) == 1))
                .collect(Collectors.toList());
        System.out.println("Combine two list and without duplicates : " + finalss);

        // above using distinct
        // .sorted(Comparator.comparing(Employee::getSalary)) for comparing the salery.

        finalss = finals.stream().distinct()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
        System.out.println("Combine two list and remove duplicates : " + finalss);

        // for get maximum salery
        // double maxSalary = Stream.concat(list1.stream(), list2.stream())
        // .mapToDouble(Employee::getSalary)
        // .max()
        // .orElse(0);

        // Below using get the two possible values by using partitioningBy
        // Map<Boolean, List<Employee>> partitioned = Stream.concat(list1.stream(),
        // list2.stream())
        // .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 80000));

        // System.out.println("Employees with Salary > 80000: " +
        // partitioned.get(true));
        // System.out.println("Employees with Salary <= 80000: " +
        // partitioned.get(false));

        // duplicate id employee salery summ.
        // Map<Integer, Double> salaryById = Stream.concat(list1.stream(),
        // list2.stream())
        // .collect(Collectors.toMap(
        // Employee::getId,
        // Employee::getSalary,
        // Double::sum // Sum salaries for duplicate ids
        // ));

        // System.out.println("Salary by ID with Duplicates Merged: " + salaryById);

        // flat map using to convert single stream from list of list or list of arrays.
        List<String[]> listOfArrays = Arrays.asList(
                new String[] { "red", "blue" },
                new String[] { "green", "yellow" },
                new String[] { "black", "white" });

        List<String> flatList = listOfArrays.stream()
                .flatMap(Arrays::stream) // Flattens the array into a single stream
                .collect(Collectors.toList());

        System.out.println(flatList);

        // we can split and flating the array using flatmap
        List<String> sentences = Arrays.asList("Hello world", "Java streams", "FlatMap example");

        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" "))) // Split and flatten
                .collect(Collectors.toList());

        System.out.println(words);

        //lexicographal
        String s = "welcometojava";
        int k = 3;
        List<String> finalresult = new ArrayList<>();

        //largest
        String largest = "";
        for (int i = 0; i <= s.length() - k; i++) {
            int end = i + k;
            String substr = s.substring(i, end);
            if (largest.compareTo(substr) < 0) {
                largest = substr;
            }
            finalresult.add(substr);

        }
        //smallest:
        String smallest = largest;
        for (int i = 0; i <= s.length() - k; i++) {
            int end = i + k;
            String substr = s.substring(i, end);
            if (smallest.compareTo(substr) > 0) {
                smallest = substr;
            }
        }

        //lexicographical after make the list sorting.
        for (int i = 0; i < finalresult.size(); i++) {
            for (int j = i + 1; j < finalresult.size(); j++) {
                if (finalresult.get(i).compareTo(finalresult.get(j)) > 0) {
                    String temp = finalresult.get(i);
                    finalresult.set(i, finalresult.get(j));
                    finalresult.set(j, temp);
                }
            }
        }

        System.out.println(finalresult);

        System.out.println(smallest + "\n" + largest);
    }

    private static List<Widgets> createWidgets(){
        return Arrays.asList(new Widgets("Red",80), new Widgets("Red",70),new Widgets("Blue",90),
                new Widgets("Orange",30), new Widgets("yellow",70)
                );
    }

    
}