import java.util.*;
class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n=stalls.length;
        int low=0;
        int high=stalls[n-1]-stalls[0];
        while(low<=high){
            int mid=(high+low)/2;
            if(canPlace(stalls,k,mid)==true){
                low=mid+1;
            } else{
                high=mid-1;
            }
        }
        return high;
        
    }
    public boolean canPlace(int[] stalls,int k,int dist){
        int cntCows=1,last=stalls[0];
        for(int i=1;i<stalls.length; i++){
            if(stalls[i]-last>=dist){
                cntCows++;
                last=stalls[i];
            }
            if(cntCows>=k) return true;
        }
        return false;
    }
}