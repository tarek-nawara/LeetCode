public class DivideTwoNumbers {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final long res = solver.divide(-2147483648, -1);
        System.out.println(res);
    }

    private static class Solution {
        public int divide(int dividend, int divisor) {
            int sign = 1;
            if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) sign = -1;
            if (divisor == 0) return Integer.MAX_VALUE;
            long newDividend = Math.abs((long)dividend);
            long newDivisor = Math.abs((long)divisor);
            if (newDividend == 0 || (newDividend < newDivisor)) return 0;
            long ans = longDivision(newDividend, newDivisor);
            if (ans > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            return (int)(ans * sign);
        }

        private long longDivision(long dividend, long divisor) {
            if (dividend < divisor) return 0;
            long sum = divisor;
            long mul = 1;
            while ((sum + sum) <= dividend) {
                sum += sum;
                mul += mul;
            }
            return mul + longDivision(dividend - sum, divisor);
        }
      }
}
