package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P133 {

    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public class Solution {
        Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) return null;
            else if (nodes.containsKey(node.label)) return nodes.get(node.label);
            final List<UndirectedGraphNode> clonedNeighbors = new ArrayList<>();
            List<Integer> selfCycle = new ArrayList<>();
            for (int i = 0; i < node.neighbors.size(); ++i) {
                if (node.neighbors.get(i).label == node.label) {
                    selfCycle.add(i);
                    continue;
                }
                clonedNeighbors.add(cloneGraph(node.neighbors.get(i)));
            }
            UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
            for (int i = 0; i < selfCycle.size(); ++i) clonedNeighbors.add(selfCycle.get(i), clonedNode);
            clonedNode.neighbors = clonedNeighbors;
            nodes.put(node.label, clonedNode);
            return clonedNode;
        }
    }
}
