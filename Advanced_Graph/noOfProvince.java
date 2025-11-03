import java.util.*;
class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adjls,int[] vis){
        vis[node]=1;
        for(Integer it: adjls.get(node)){
            if(vis[it]==0){
                dfs(it,adjls,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int cnt=0;
        int n=isConnected.length;
        int[] vis=new int[n];
        ArrayList<ArrayList<Integer>> adjls=new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjls.add(new ArrayList<>());
        }

        for(int i=0 ;i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }

        for(int i=0; i<n; i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,adjls,vis);
            }
        }
        return cnt;
    }
}