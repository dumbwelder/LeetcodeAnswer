package q189;

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int n = k % len;
        int count = 0;
        for (int start = 0; count < len; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + n) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while (start!=current);

        }

    }
}
