package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P448 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        final List<Integer> res = solver.findDisappearedNumbers(nums);
        System.out.println(res);
    }

    private static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                int idx = Math.abs(nums[i]) - 1;
                if (nums[idx] > 0) nums[idx] *= -1;
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > 0) res.add(i + 1);
            }
            return res;
        }
    }
}
