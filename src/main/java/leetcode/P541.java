package leetcode;

public class P541 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final String result = solver.reverseStr("abcdefg", 2);
        System.out.println(result);
    }

    private static class Solution {
        public String reverseStr(String s, int k) {
            char[] a = s.toCharArray();
            for (int i = 0; i <= s.length() / (2 * k); ++i) {
                reverseCharArray(a, 2 * k * i, Math.min(2 * k * i + k - 1, s.length() - 1));
            }
            return new String(a);
        }

        private void reverseCharArray(char[] a, int start, int end) {
            for (int i = 0; i < (end - start + 1) / 2; ++i) {
                char temp = a[start + i];
                a[start + i] = a[end - i];
                a[end - i] = temp;
            }
        }
    }
}
