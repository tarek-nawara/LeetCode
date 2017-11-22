package edu.leetcode;

import java.util.Arrays;

public class P575 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final int res = solver.distributeCandies(new int[]{1,1,1,1,2,2,2,3,3,3});
        System.out.println(res);
    }

    private static class Solution {
        public int distributeCandies(int[] candies) {
            int brother = 0;
            int sister = 0;
            Arrays.sort(candies);
            for (int i = 0; i < candies.length; i = skip(candies[i], i, candies)) {
                ++sister;
            }
            brother = candies.length - sister;
            if (sister < brother) {
                return sister;
            }
            int diff = sister - brother;
            return sister - (diff) / 2;
        }

        private int skip(int val, int idx, int[] a) {
            while (idx < a.length && a[idx] == val) ++idx;
            return idx;
        }
    }
}
