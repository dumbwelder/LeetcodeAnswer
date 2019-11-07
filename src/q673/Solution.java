package q673;

import java.util.Arrays;

public class Solution {
    //由于遍历了j前面的所有数，因此结果有三种：
    //1.比前面的所有数都小,length[j]=1,
    //2.nums[j]>=当前nums[i]
    //2.1 length[i]>=length[j],则更新length[j]=length[i]+1;count[j]=counts[i];
    //2.2 length[i]+1=length[j],则更新counts[j] += counts[i];
    public int findNumberOfLIS(int[] nums) {
        if (nums == null) return -1;

        int len = nums.length;
        if (len <= 1) return len;
        int[] count = new int[len];
        int[] length = new int[len];
        int max = 0;
        Arrays.fill(count, 1);
        for (int curNum = 0; curNum < len; curNum++) {
            for (int preNum = 0; preNum < curNum; preNum++) {
                if (nums[curNum] > nums[preNum]) {
                    if (length[curNum] == length[preNum] + 1) {
                        count[curNum] += count[preNum];
                    } else if (length[curNum] <= length[preNum]) {
                        length[curNum] = length[preNum] + 1;
                        count[curNum] = count[preNum];
                    }
                }
            }
            max = Math.max(max, length[curNum]);
        }

        int reslut = 0;
        for (int i = 0; i < len; i++) {
            if (length[i] == max) {
                reslut += count[i];
            }
        }
        return reslut;
    }
}
