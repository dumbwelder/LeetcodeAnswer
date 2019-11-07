package pingduoduo.Test3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();
        float x = sc.nextFloat();
        float y = sc.nextFloat();
        float once = calOnce(x, y);
    }

    private static float calOnce(float x, float y) {
        float res = 0f;
        for (int i = 0; x <= 1; i++) {
            res += i*x;
            x += y;
        }
        return res;
    }

}
/*
([(][()]]()
 */