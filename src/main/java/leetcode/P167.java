package leetcode;

import java.util.Arrays;

public class P167 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        Solution solver = new Solution();
        final int[] res = solver.twoSum(numbers, 9);
        System.out.println(Arrays.toString(res));
    }

    private static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int curSum = numbers[left] + numbers[right];
                if (curSum == target) return new int[]{left + 1, right + 1};
                else if (curSum > target) --right;
                else ++left;
            }
            return null;
        }
    }
}
