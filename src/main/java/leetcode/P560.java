package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P560 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        Solution solver = new Solution();
        final int res = solver.subarraySum(nums, 2);
        System.out.println(res);
    }

    private static class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> seenSum = new HashMap<>();
            seenSum.put(0, 1);
            int sum = 0;
            int res = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                res += seenSum.getOrDefault(sum - k, 0);
                seenSum.put(sum, seenSum.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }
}
