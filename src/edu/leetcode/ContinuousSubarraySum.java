package edu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int k = 5;
        Solution solver = new Solution();
        final boolean res = solver.checkSubarraySum(a, k);
        System.out.println(res);
    }

    private static class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> sums = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                if (k != 0) sum %= k;
                Integer prevMod = sums.get(sum);
                if (prevMod != null) {
                    if (i - prevMod > 1) return true;
                } else {
                    sums.put(sum, i);
                }
            }
            return false;
        }
    }
}
