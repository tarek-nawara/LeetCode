package edu.leetcode;

public class P58 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final int result = solver.lengthOfLastWord("hello world");
        System.out.println(result);
    }

    private static class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() == 0) return 0;
            String[] split = s.trim().split(" ");
            return split[split.length - 1].length();
        }
    }
}
