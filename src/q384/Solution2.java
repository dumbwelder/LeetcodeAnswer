package q384;

import java.util.Random;

class Solution2 {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution2(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution2 s = new Solution2(nums);
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

