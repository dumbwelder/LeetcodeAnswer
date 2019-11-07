package q384;

import java.util.Random;

public class Solution {
    private int arr[];
    private int[] original;

    public Solution(int[] nums) {
        this.arr = nums;
        this.original = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        arr = original;
        original = original.clone();
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random r = new Random();
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int j = r.nextInt(arr.length-i);
            temp = arr[i];
            arr[i] = arr[i + j];
            arr[(i + j)] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution s = new Solution(nums);
        show(s.shuffle());
        show(s.reset());
        show(s.shuffle());
    }

    public static void show(int[] nums) {
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
