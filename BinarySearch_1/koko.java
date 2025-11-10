class Solution {
    public boolean canEat(int[] piles,int h, int mid){
        int cnt=0;
        for(int i=0; i<piles.length; i++){
            cnt+=Math.ceil((double)piles[i]/mid);
        }
        if(cnt<=h) return true;

        return false;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=Integer.MIN_VALUE;
        for(int i=0;i<piles.length; i++){
            low=Math.min(low,piles[i]);
            high=Math.max(high,piles[i]);
        }
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(canEat(piles,h,mid)==true){
                ans=mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return ans;
    }
}