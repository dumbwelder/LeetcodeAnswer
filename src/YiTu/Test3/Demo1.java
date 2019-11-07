package YiTu.Test3;

//从n个数里挑m个数，有多少种组合，并输出，
public class Demo1 {
    public void pick(int nums[], int m) {
        int n = nums.length;
        pick(nums, 0, m, "");
    }

    private void pick(int[] nums, int i, int m, String s) {
        if (m == 0) {
            System.out.println(s);
        } else {
            for (int j = i; j < nums.length; j++) {
                pick(nums, j + 1, m - 1, s + nums[j]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int m = 4;
        new Demo1().pick(nums, m);
    }

}
