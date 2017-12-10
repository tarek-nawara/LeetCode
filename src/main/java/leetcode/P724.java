package leetcode;

import java.util.Arrays;

public class P724 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums = {1, 7, 3, 6, 5, 6};
        final int res = solver.pivotIndex(nums);
        System.out.println(res);
    }

    private static class Solution {
        public int pivotIndex(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int[] prefix = prefixSum(nums);
            int[] suffix = suffix(nums);
            for (int i = 0; i < nums.length; ++i) {
                if (prefix[i] == suffix[i]) return i;
            }
            return -1;
        }

        private int[] prefixSum(int[] nums) {
            int[] prefix = new int[nums.length];
            prefix[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                prefix[i] = prefix[i - 1] + nums[i];
            }
            return prefix;
        }

        private int[] suffix(int[] nums) {
            int[] suffix = new int[nums.length];
            suffix[suffix.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; --i) {
                suffix[i] = suffix[i + 1] + nums[i];
            }
            return suffix;
        }
    }
}
