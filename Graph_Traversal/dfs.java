import java.util.*;
class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans,boolean[] vis){
        vis[node]=true;
        ans.add(node);
        
        for(int u:adj.get(node)){
            if(!vis[u]){
                dfs(u,adj,ans,vis);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans=new ArrayList<>();
        int v=adj.size();
        boolean[] vis=new boolean[v];
        dfs(0,adj,ans,vis);
        return ans;
        
    }
}