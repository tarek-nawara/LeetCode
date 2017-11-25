package edu.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class P503 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums = {100,1,11,1,120,111,123,1,-1,-100};
        final int[] res = solver.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }

    private static class Tuple2<T, U> {
        final T first;
        final U second;

        public Tuple2(T first, U second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
            return Objects.equals(first, tuple2.first) &&
                    Objects.equals(second, tuple2.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    private static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Map<Tuple2<Integer, Integer>, Integer> greaterMap = new HashMap<>();
            Stack<Tuple2<Integer, Integer>> stack = new Stack<>();
            for (int i = 0; i < 2 * nums.length; ++i) {
                int idx = i % nums.length;
                while (!stack.isEmpty() && stack.peek().first < nums[idx]) {
                    final Tuple2<Integer, Integer> topElem = stack.pop();
                    if (greaterMap.containsKey(topElem)) continue;
                    greaterMap.put(topElem, nums[idx]);
                }
                stack.push(new Tuple2<>(nums[idx], idx));
            }
            int[] res = new int[nums.length];
            for (int i = 0; i < res.length; ++i) {
                res[i] = greaterMap.getOrDefault(new Tuple2<>(nums[i], i), -1);
            }
            return res;
        }
    }
}
