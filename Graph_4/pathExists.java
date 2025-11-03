import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public boolean dfs(int node, int destination,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        if(node==destination) return true;

        for(int neighbour:adj.get(node)){
            if(vis[neighbour]==-1){
                if(dfs(neighbour,destination,vis,adj)==true) return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
        return dfs(source,destination,vis,adj);
    }
}