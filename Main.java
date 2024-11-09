import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is Java 8 program to print non duplicatate charcter from settings strings");

        String str = "settings";

        String[] str1 = str.split("");



        Map<String, Long>    map =  Arrays.stream(str.split("")).
              collect(Collectors.groupingBy(s -> s, Collectors.counting()));


      map.entrySet().stream().filter(s -> s.getValue()==1).forEach(e -> System.out.println(e.getKey()));

      // To Maintain order

        System.out.println("------------------------");


        Map<String, Integer> freqMap= new HashMap<>();

        for(String s: str1){
            freqMap.put(s, freqMap.getOrDefault(s, 0)+1);
        }

        Arrays.stream(str1).filter(e -> freqMap.get(e)==1).forEach(System.out::println);

        //To Convert String to A Map and Printing it

        System.out.println("------------------------------------");

        Map<String, Long> strMap = Arrays.stream(str1).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        strMap.entrySet().stream().forEach(System.out::println);


        System.out.println("2nd largest number of Array");

        int[] arr = {91, 20, 10,4,100, 204, 33, 98};

        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).
                findFirst().ifPresent(System.out::println);
    }
}
