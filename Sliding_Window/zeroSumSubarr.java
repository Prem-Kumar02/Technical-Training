import java.util.*;
class Solution {
    public int findSubarray(int[] arr) {
        Map<Integer,Integer>mpp=new HashMap<>();
        int cnt=0;
        int preSum=0;
        mpp.put(0,1);
        for(int i=0;i<arr.length;i++){
            preSum+=arr[i];
            if(mpp.containsKey(preSum)){
                cnt+=mpp.get(preSum);
            }
            mpp.put(preSum,mpp.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}
