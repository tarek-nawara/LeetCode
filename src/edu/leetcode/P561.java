package edu.leetcode;

import java.util.Arrays;

public class P561 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final int res = solver.arrayPairSum(new int[]{1, 4, 3, 2});
        System.out.println(res);
    }

    private static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length; i += 2) {
                res += nums[i];
            }
            return res;
        }
    }
}
