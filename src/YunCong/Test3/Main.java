package YunCong.Test3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int candies = in.nextInt();
        int num_people = in.nextInt();
        int[] res = new int[num_people];
        for (int i = 1; candies > 0; i++) {
            if (candies >= i) {
                res[(i - 1) % num_people] += i;
                candies -= i;
            } else {
                res[(i - 1) % num_people] += candies;
                candies = 0;
            }
        }

        System.out.print("[");
        for (int i = 0; i < num_people; i++) {
            System.out.print(res[i]);
            if (i < num_people - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
/*
7
4
[1,2,3,1]
 */