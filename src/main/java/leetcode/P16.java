package leetcode;

import java.util.Arrays;

public class P16 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums = {};
        final int res = solver.threeSumClosest(nums, 1);
        System.out.println(res);
    }

    private static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int res = 0;
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int curSum = nums[i] + nums[left] + nums[right];
                    if (curSum == target) return curSum;
                    else if (curSum < target) {
                        ++left;
                    } else {
                        --right;
                    }
                    if (Math.abs(curSum - target) < diff) {
                        res = curSum;
                        diff = Math.abs(curSum - target);
                    }
                }
            }
            return res;
        }
    }
}
