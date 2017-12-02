package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class A2 {
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
            Map<String, Map<Integer, Integer>> contest = new HashMap<>();
            Map<String, Integer> scores = new HashMap<>();
            int n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                String name = in.next();
                int score = in.nextInt();
                if (!contest.containsKey(name)) {
                    contest.put(name, new HashMap<>());
                    scores.put(name, 0);
                }
                int currentScore = scores.get(name) + score;
                scores.put(name, currentScore);
                if (!contest.get(name).containsKey(currentScore)) {
                    contest.get(name).put(currentScore, i);
                }
            }
            int maxScore = 0;
            List<String> candidates = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                if (maxScore < entry.getValue()) {
                    candidates.clear();
                    maxScore = entry.getValue();
                    candidates.add(entry.getKey());
                } else if (maxScore == entry.getValue()) {
                    candidates.add(entry.getKey());
                }
            }
            String winner = "";
            int minIndex = Integer.MAX_VALUE;
            for (String candidate : candidates) {
                int winIndex = getWinIndex(maxScore, contest.get(candidate));
                if (minIndex > winIndex) {
                    minIndex = winIndex;
                    winner = candidate;
                }
            }
            out.println(winner);
        }

        private int getWinIndex(int score, Map<Integer, Integer> scoresIndices) {
            int minIndex = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : scoresIndices.entrySet()) {
                if (score <= entry.getKey()) {
                    if (minIndex > entry.getValue()) {
                        minIndex = entry.getValue();
                    }
                }
            }
            return minIndex;
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
