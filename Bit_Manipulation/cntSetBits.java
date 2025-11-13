class Solution {
    public static int countSetBits(int n) {
        int count=0;
        for(int i=1; i<=n; i++){
            int cnt=0;
            int x=i;
            while(x!=0){
                x=(x & (x-1));
                cnt++;
            }
            count+=cnt;
        }
        
        return count;
        
    }
}