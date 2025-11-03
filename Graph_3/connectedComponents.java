import java.util.*;

class Solution {
    public void dfs(int v, List<List<Integer>> adj, boolean[] visited) {
        visited[v] = true;

        for (int u : adj.get(v)) {
            if (!visited[u]) {
                dfs(u, adj, visited);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        // Step 2: Count connected components
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }

        return count;
    }
}
