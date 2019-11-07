package LeetCode42;

import java.util.Stack;
//单调递减栈，即比栈顶元素小入栈，比栈顶元素大出栈；入栈前的元素即为比它小的第一个元素
public class DecrStack {
    private static Stack<Integer> stack = new Stack();

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr1 = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                //System.out.print(stack.pop());
                stack.pop();
            }
            if (stack.size() == 0) {
                arr1[i] = 0;
            } else {
                arr1[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        //System.out.println(stack);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+1 + "   ");
        }
        System.out.println();
        for (int i : arr) {
            System.out.print(i + "   ");

        }
        System.out.println();
        for (int i : arr1) {
            System.out.print(i + "   ");
        }
    }

}
