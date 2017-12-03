package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        Solution solver = new Solution();
        final int[] res = solver.twoSum(numbers, 9);
        System.out.println(Arrays.toString(res));
    }

    private static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> available = new HashMap<>();
            for (int i = 0; i < numbers.length; ++i) {
                int rem = target - numbers[i];
                if (available.containsKey(rem)) return new int[]{available.get(rem), i};
                else available.put(numbers[i], i);
            }
            return null;
        }
    }
}
