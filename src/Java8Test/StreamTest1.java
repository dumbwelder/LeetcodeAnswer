package Java8Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {
    public static void main(String[] args) {
//        method1();
        method2();
    }

    public static void method1() {
        Integer[] myArray = {1, 2, 3};
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(myList);
    }

    public static void method2() {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
//filter/map/sorted/any、all、noneMatch/count/reduce
/*        stringList
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);*/
/*        stringList
                .stream()
                .sorted()
                .filter((s)->s.startsWith("a"))
                .forEach(System.out::println);*/
/*        stringList
                .stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);*/


        System.out.println(stringList);
    }
}
