package q412;

import java.util.*;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList();
        Map<Integer, String> m = new LinkedHashMap<>();
        m.put(3, "Fizz");
        m.put(5, "Buzz");
        for (int i = 1; i <= n; i++) {
            String str = "";
            for (Map.Entry e : m.entrySet()) {
                if (i % (Integer) e.getKey() == 0) {
                    str += e.getValue();
                }
            }
            if (str.equals("")) {
                str += i;
            }
            res.add(str);
        }
        return res;
    }
}