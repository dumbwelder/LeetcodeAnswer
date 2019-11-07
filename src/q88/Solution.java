package q88;

import jdk.nashorn.internal.runtime.NumberToString;

import javax.print.attribute.standard.NumberUpSupported;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2==null||nums2.length==0) return;
        int index1 = 0;
        for (int i = 0; i < m; i++) {
            if (nums1[index1] > nums2[0]) {
                int temp = nums1[index1];
                nums1[index1] = nums2[0];
                int j = 1;
                while (j<n){
                    if (nums2[j] < temp) {
                        nums2[j-1] = nums2[j];
                    } else {
                        nums2[j-1] = temp;
                        break;
                    }
                    j++;
                }
                if (j==n){
                    nums2[j-1] = temp;
                }
            }
            index1++;
        }
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
    }
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        int m = 1;
        int n = 0;
        new Solution().merge(nums1,m,nums2,0);
        for (int i:nums1){
            System.out.print(i);
        }

    }
}
