package LeetCode42;

import java.util.Stack;

//找到上一次弹出的位置间夹了多少位
public class Solve {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Stack<Integer> s = new Stack();
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {

            while (!s.isEmpty()&&arr[s.peek()]<arr[i]){
                int h =arr[s.peek()];
                s.pop();
                if(s.isEmpty()) break;

                int ditance = i-s.peek()-1;
                int min = Math.min(arr[s.peek()],arr[i]);
                sum = sum +ditance*(min-h);
            }

            s.push(i);
        }
        System.out.println(sum);
    }
}
