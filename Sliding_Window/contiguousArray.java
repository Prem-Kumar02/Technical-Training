import java.util.*;
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> mpp=new HashMap<>();
        int maxi=0;
        int curSum=0;
        mpp.put(0,-1);
        for(int i=0;i<nums.length;i++){
            curSum+=(nums[i]==1)?1:-1;
            if(mpp.get(curSum)!=null){
                maxi=Math.max(maxi,i-mpp.get(curSum));
            } else{
                mpp.put(curSum,i);
            }
        }
        return maxi;
    }
}