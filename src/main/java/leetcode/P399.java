package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P399 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        final double[] res = solver.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));
    }

    private static class Solution {
        private class Edge {
            double weight;
            Vertex to;

            Edge(double weight, Vertex to) {
                this.weight = weight;
                this.to = to;
            }
        }

        private class Vertex {
            private static final int INVALID = -1;
            private static final int VALID = 1;

            int id;
            List<Edge> outgo = new ArrayList<>();

            Vertex(int id) {
                this.id = id;
            }

            double[] divide(Vertex target, boolean[] vis) {
                vis[this.id] = true;
                if (this == target) return new double[]{VALID, 1};
                for (Edge edge : outgo) {
                    if (vis[edge.to.id]) continue;
                    double[] vRes = edge.to.divide(target, vis);
                    if (vRes[0] == 1) {
                        return new double[]{VALID, edge.weight * vRes[1]};
                    }
                }
                return new double[]{INVALID, -1};
            }
        }

        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            List<Vertex> vs = new ArrayList<>();
            int idCount = 0;
            Map<String, Vertex> vertexMapping = new HashMap<>();
            for (int i = 0; i < equations.length; ++i) {
                if (!vertexMapping.containsKey(equations[i][0])) {
                    Vertex a = new Vertex(idCount++);
                    vertexMapping.put(equations[i][0], a);
                }
                if (!vertexMapping.containsKey(equations[i][1])) {
                    Vertex b = new Vertex(idCount++);
                    vertexMapping.put(equations[i][1], b);
                }
                Vertex a = vertexMapping.get(equations[i][0]);
                Vertex b = vertexMapping.get(equations[i][1]);
                a.outgo.add(new Edge(values[i], b));
                b.outgo.add(new Edge(1.0 / values[i], a));
            }
            double[] res = new double[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                boolean[] vis = new boolean[idCount];
                if (!(vertexMapping.containsKey(queries[i][0]) && vertexMapping.containsKey(queries[i][1]))) {
                    res[i] = -1;
                } else if (queries[i][0].equals(queries[i][1])) {
                    res[i] = 1;
                } else {
                    Vertex source = vertexMapping.get(queries[i][0]);
                    Vertex target = vertexMapping.get(queries[i][1]);
                    final double[] divisionResult = source.divide(target, vis);
                    res[i] = divisionResult[1];
                }
            }
            return res;
        }
    }
}
