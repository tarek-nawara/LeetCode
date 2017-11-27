package edu.leetcode;

import java.util.Objects;

public class P521 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        String a = "abc";
        String b = "cdc";
        final int res = solver.findLUSlength(a, b);
        System.out.println(res);
    }

    private static class Solution {
        public int findLUSlength(String a, String b) {
            if (Objects.equals(a, b)) return -1;
            return Math.max(a.length(), b.length());
        }
    }
}
