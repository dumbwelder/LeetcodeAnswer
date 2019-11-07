package jingdong.test3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
            }
            int count = 1;
            int index = h[0];
            for (int i = 1; i < n; i++) {
                if(h[i]>=index){
                    index = h[i];
                    count ++;
                }

            }
            System.out.println(count);
        }
    }
}
