package leetcode;

import java.util.Stack;

public class P682 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final int res = solver.calPoints(new String[]{"5", "2", "C", "D", "+"});
        System.out.println(res);
    }

    private static class Solution {
        public int calPoints(String[] ops) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < ops.length; ++i) {
                switch (ops[i]) {
                    case "+":
                        int first = stack.pop();
                        int second = stack.pop();
                        stack.push(second);
                        stack.push(first);
                        stack.push(first + second);
                        break;
                    case "C":
                        stack.pop();
                        break;
                    case "D":
                        stack.push(stack.peek() * 2);
                        break;
                    default:
                        stack.push(Integer.parseInt(ops[i]));
                }
            }
            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            return sum;
        }
    }
}
