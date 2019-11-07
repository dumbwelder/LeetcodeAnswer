package Java8Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaDemo1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
        names.sort((a, b) -> b.compareTo(a));

        System.out.println(names);

    }
}
