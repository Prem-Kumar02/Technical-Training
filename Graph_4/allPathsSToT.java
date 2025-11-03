import java.util.*;
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, graph, path, ans);
        return ans;
    }

    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> ans) {
        path.add(node);
        int n = graph.length;

        // Base case: reached target node
        if (node == n - 1) {
            ans.add(new ArrayList<>(path));  // add copy of path
        } else {
            // Explore all neighbors
            for (int next : graph[node]) {
                dfs(next, graph, path, ans);
            }
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}