package edu.leetcode;

public class P461 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final int res = solver.hammingDistance(Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(res);
    }

    private static class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
}
