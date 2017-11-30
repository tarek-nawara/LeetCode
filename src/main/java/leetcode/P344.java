package leetcode;

public class P344 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final String result = solver.reverseString("hello");
        System.out.println(result);
    }

    private static class Solution {
        public String reverseString(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; --i) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
}
