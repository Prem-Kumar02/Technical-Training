class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int cnt=0;
        int curMax=-1;
        for(int i=0;i<n;i++){
            curMax=Math.max(curMax,arr[i]);
            if(curMax==i) cnt++;
        }
        return cnt;
    }
}