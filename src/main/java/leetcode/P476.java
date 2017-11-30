package leetcode;

public class P476 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final int res = solver.findComplement(5);
        System.out.println(res);
    }

    private static class Solution {
        public int findComplement(int num) {
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                int mod = num % 2;
                sb.append(mod == 1 ? 0 : 1);
                num /= 2;
            }
            return Integer.parseInt(sb.reverse().toString(), 2);
        }
    }
}
