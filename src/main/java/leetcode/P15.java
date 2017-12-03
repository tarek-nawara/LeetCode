package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        final List<List<Integer>> res = solver.threeSum(nums);
        System.out.println(res);
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length;) {
                res.addAll(findTriples(i, nums[i], nums));
                ++i;
                while (i < nums.length && nums[i] == nums[i - 1]) ++i;
            }
            return res;
        }

        private List<List<Integer>> findTriples(int start, int target, int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int left = start + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + target;
                if (sum == 0) {
                    res.add(Arrays.asList(target, nums[left], nums[right]));
                    ++left;
                    --right;
                    while (left < nums.length && left < right && nums[left] == nums[left - 1]) ++left;
                    while (right >= 0 && right > left && nums[right] == nums[right + 1]) --right;
                } else if (sum > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
            return res;
        }
    }
}
