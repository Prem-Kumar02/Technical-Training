import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mpp=new HashMap<>();
        int[] res=new int[2];
        for(int i=0;i<nums.length; i++){
            int rem=target-nums[i];
            if(mpp.containsKey(rem)){
                res[0]=i;
                res[1]=mpp.get(rem);
                break;
            }
            mpp.put(nums[i],i);
        }
        return res;
    }
}