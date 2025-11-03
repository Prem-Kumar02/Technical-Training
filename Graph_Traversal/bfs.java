import java.util.*;
class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n=adj.size();
        ArrayList<Integer> ans=new ArrayList<>();
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        vis[0]=1;
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int neighbour:adj.get(node)){
                if(vis[neighbour]!=-1) continue;
                q.offer(neighbour);
                vis[neighbour]=1;
            }
        }
        return ans;
        
    }
}