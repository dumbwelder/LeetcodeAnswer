package YunCong.Test2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String arr1 = in.nextLine();
        arr1 = arr1.substring(1, arr1.length() - 1);
        Set<Integer> res = new TreeSet<>();
        for (String num : arr1.split(",")) {
            res.add(Integer.parseInt(num.trim()));
        }

        String arr2 = in.nextLine();
        arr1 = arr2.substring(1, arr2.length() - 1);
        Set<Integer> res2 = new TreeSet<>();
        for (String num : arr1.split(",")) {
            int val = Integer.parseInt(num.trim());
            if (res.contains(val)) {
                res2.add(val);
            }
        }

        System.out.print('[');
        Iterator ite = res2.iterator();
        while(ite.hasNext()){
            System.out.print(ite.next());
            if (ite.hasNext()){
                System.out.print(",");
            }
        }
        System.out.print(']');
    }

}
/*
[1,2,2,1,3]
[2,2,3]
 */