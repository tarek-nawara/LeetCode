package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P496 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        final int[] res = solver.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    private static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> greaterMap = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums2.length; ++i) {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    greaterMap.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; ++i) {
                res[i] = greaterMap.getOrDefault(nums1[i], -1);
            }
            return res;
        }
    }
}
