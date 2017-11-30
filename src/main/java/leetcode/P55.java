package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P55 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[][] tests = {{2,3,1,1,4}, {3,2,1,0,4}};
        final List<Boolean> result = Arrays.stream(tests).map(solver::canJump).collect(Collectors.toList());
        System.out.println(result);
    }

    private static class Solution {
        byte[] mem;
        public boolean canJump(int[] nums) {
            int n = nums.length;
            mem = new byte[n];
            Arrays.fill(mem, (byte)-1);
            return nonRecSolve(nums);
        }

        private boolean solve(int idx, int[] nums) {
            if (idx >= nums.length) return false;
            if (idx == nums.length - 1) return true;
            if (mem[idx] != -1) return mem[idx] == 1;
            for (int i = 1; i <= nums[idx]; ++i) {
                if (solve(idx + i, nums)) {
                    mem[idx] = 1;
                    return true;
                }
            }
            mem[idx] = 0;
            return false;
        }

        private boolean nonRecSolve(int[] nums) {
            return false;
        }
    }
}
