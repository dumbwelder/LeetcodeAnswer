package jingdong.test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int countOut = 0;
            ArrayList<Integer> outArray = new ArrayList<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            Map<Integer, ArrayList<Integer>> relationMap = new HashMap<>();
            int[] count = new int[2 * n + 1];
            for (int i = 0; i < m; i++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();

                count[num1]++;
                count[num2]++;

                if (!relationMap.containsKey(num1)) {
                    ArrayList arr = new ArrayList<Integer>();
                    arr.add(num2);
                    relationMap.put(num1, arr);
                } else {
                    relationMap.get(num1).add(num2);
                }
                if (!relationMap.containsKey(num2)) {
                    ArrayList arr = new ArrayList<Integer>();
                    arr.add(num1);
                    relationMap.put(num2, arr);
                } else {
                    relationMap.get(num2).add(num1);
                }
            }

            int max = -1;
            while (true) {
                max = 0;
                int index = 0;
                for (int i = 1; i < 2 * n + 1; i++) {

                    if (max < count[i]) {
                        max = count[i];
                        index = i;
                    }
                }
                if(max==0) break;

                outArray.add(index);
                countOut++;
                count[index] = 0;
                for (int i : relationMap.get(index)) {
                    relationMap.get(i).remove((Object) index);
                    count[i]--;
                }
            }

            System.out.println(countOut);
            for (int i : outArray){
                System.out.print(i+" ");
            }
        }
        sc.close();
    }
}
