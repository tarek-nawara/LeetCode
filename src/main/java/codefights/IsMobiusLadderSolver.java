package codefights;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class IsMobiusLadderSolver {
    public static void main(String[] args) throws IOException {
        Solution solver = new Solution();
        InputStream stream = IsMobiusLadderSolver.class.getClassLoader().getResourceAsStream("codefights/IsMobiusLadderSolver/test-20.json");

        JSONObject obj = new JSONObject(IOUtils.toString(stream, Charset.defaultCharset()));
        JSONArray a = obj.getJSONObject("input").getJSONArray("ladder");
        int[][] ladder = new int[a.length()][2];
        int n = a.length();
        for (int i = 0; i < a.length(); ++i) {
            final JSONArray jsonArray = a.getJSONArray(i);
            ladder[i][0] = jsonArray.getInt(0);
            ladder[i][1] = jsonArray.getInt(1);
        }
        final boolean res = solver.isMobiusLadder(n, ladder);
        System.out.println(res);
    }

    private static class Solution {
        private static class Vertex {
            int color;
            List<Vertex> adj = new ArrayList<>();

            boolean bipartiteCheck() {
                boolean res = true;
                for (Vertex v : adj) {
                    if (v.color == this.color) {
                        res = false;
                    } else if (v.color == 0) {
                        v.color = 3 - color;
                        res = res && v.bipartiteCheck();
                    }
                }
                return res;
            }
        }

        boolean isMobiusLadder(int n, int[][] ladder) {
            Vertex[] vs = new Vertex[n];
            for (int i = 0; i < vs.length; ++i) {
                vs[i] = new Vertex();
            }
            for (int i = 0; i < ladder.length; ++i) {
                int a = ladder[i][0];
                int b = ladder[i][1];
                vs[a].adj.add(vs[b]);
                vs[b].adj.add(vs[a]);
            }
            int components = 0;
            boolean isBipartite = true;
            for (int i = 0; i < n; ++i) {
                if (vs[i].color == 0) {
                    ++components;
                    vs[i].color = 1;
                    isBipartite = isBipartite && vs[i].bipartiteCheck();
                }
            }
            if (components != 1) {
                return false;
            }
            if (n > 2) {
                for (int i = 0; i < n; ++i) {
                    if (vs[i].adj.size() != 3) return false;
                }
            }
            if (n % 4 == 2) return isBipartite;
            else return !isBipartite;
        }
    }
}
