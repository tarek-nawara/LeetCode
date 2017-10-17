package edu.leetcode;

public class PalindromicNumber {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final boolean res = solver.isPalindrome(11211);
        System.out.println(res);
    }

    private static class Solution {
        public boolean isPalindrome(int x) {
            x = Math.abs(x);
            int rev = 0;
            int original = x;
            while (x > 0) {
                rev *= 10;
                rev += (x % 10);
                x /= 10;
            }
            return rev == original;
        }
    }
}
