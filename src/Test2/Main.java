package Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = 0;
            int b = 0;
            int c = 0;
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            set.add(1);
            for (int i = 0; i < m; i++) {

                a = sc.nextInt();
                b = sc.nextInt();
                c = sc.nextInt();

                if (c == 1) {
                    if (set.contains(a)) {
                        set.add(b);
                        while (map.containsKey(b)) {
                            int oldValue = b;
                            set.add(map.get(b));
                            b = map.get(b);
                            map.remove(oldValue);

                        }
                    } else if (set.contains(b)) {
                        set.add(a);
                        while (map.containsKey(a)) {
                            int oldValue = a;
                            set.add(map.get(a));
                            a = map.get(a);
                            map.remove(oldValue);
                        }
                    } else {
                        if (map.containsKey(a)) {
                            map.put(map.get(a), b);
                        } else {
                            map.put(a, b);
                        }

                        if (map.containsKey(b)) {
                            map.put(map.get(b), a);
                        } else {
                            map.put(b, a);

                        }
                    }
                }
            }
            System.out.println(set.size() - 1);

        }

    }
}

