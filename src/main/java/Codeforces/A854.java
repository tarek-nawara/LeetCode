package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A854 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(0, in, out);
        out.close();
    }

    private static class Solution {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            double maxFraction = 0.0;
            int resNum = 0;
            int resDen = 0;
            for (int i = 1; i <= n / 2; ++i) {
                int b = n - i;
                if (gcd(b, i) == 1) {
                    if (Double.compare(maxFraction, (double) i / b) < 0) {
                        maxFraction = (double) i / b;
                        resNum = i;
                        resDen = b;
                    }
                }
            }
            out.println(resNum + " " + resDen);
        }

        private int gcd(int a, int b) {
            while (b > 0) {
                int tmp = a;
                a = b;
                b = tmp % b;
            }
            return a;
        }
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(final InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
