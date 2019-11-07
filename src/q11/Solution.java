package q11;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

    public int maxArea1(int[] height) {
        int len = height.length;
        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                res = Math.max(res, (i - j) * Math.min(height[i], height[j]));
            }
        }
        return res;
    }
}
