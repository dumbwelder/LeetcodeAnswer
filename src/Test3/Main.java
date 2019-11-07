package Test3;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int d,h,m1,m2,result;
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean isPossible = true;
            int[][] record = new int[m][2];
            for(int i =0;i<m;i++){
                record[i][0] = sc.nextInt();
                record[i][1] = sc.nextInt();
            }
            d = record[0][0];
            h = record[0][1];
            m1 = d-1+h;
            int last_d = d;
            int last_h = h;
            for(int i =1;i<m;i++){
                d = record[i][0];
                h = record[i][1];
                int higher = (h+last_h+d-last_d)/2;
                if(higher<Math.max(h,last_h)){
                    isPossible = false;
                    break;
                }
                if(higher>m1)
                    m1 =higher;
                last_h = h;
                last_d = d;
            }
            m2 =n-d+h;
            result = Math.max(m1,m2);
            if(!isPossible)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(result);
        }
        sc.close();
    }
}