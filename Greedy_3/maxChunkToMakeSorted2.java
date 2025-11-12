class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int[] prefixMax=new int[n];
        int[] suffixMin=new int[n];
        prefixMax[0]=arr[0];
        suffixMin[n-1]=arr[n-1];

        for(int i=1;i<n; i++){
            prefixMax[i]=Math.max(prefixMax[i-1],arr[i]);
        }
        for(int i=n-2;i>=0; i--){
            suffixMin[i]=Math.min(suffixMin[i+1],arr[i]);
        }
        int cnt=0;
        for(int i=0;i<n; i++){
            int preMax=i>0?prefixMax[i-1]:-1;
            int sufMin=suffixMin[i];

            if(preMax<=sufMin){
                cnt++;
            }
        }
        return cnt;
        
    }
}