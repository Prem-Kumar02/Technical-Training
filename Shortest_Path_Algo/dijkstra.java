import java.util.*;
class Solution {
    // Function to implement Dijkstra's Algorithm
    public int[] dijkstra(int V, List<List<int[]>> adj, int src) {
        // Distance array initialized to large value
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        // Min-heap storing {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        // Distance to source is 0
        dist[src] = 0;

        // Push source into heap
        pq.add(new int[]{0, src});

        // Process nodes until heap is empty
        while (!pq.isEmpty()) {
            // Extract node with minimum distance
            int[] cur = pq.poll();
            int d = cur[0];
            int node = cur[1];

            // Skip if outdated distance
            if (d > dist[node]) continue;

            // Traverse all neighbors
            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                int wt = edge[1];

                // Relaxation check
                if (dist[node] + wt < dist[next]) {
                    // Update distance
                    dist[next] = dist[node] + wt;

                    // Push into heap
                    pq.add(new int[]{dist[next], next});
                }
            }
        }
        return dist;
    }
}