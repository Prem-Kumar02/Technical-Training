import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mpp=new HashMap<>();
        List<Integer>[] freq=new List[nums.length+1];
        for(int i=0; i<freq.length; i++){
            freq[i]=new ArrayList<>();
        }
        for(int n:nums){
            mpp.put(n,mpp.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res=new int[k];
        int idx=0;
        for(int i=freq.length-1;i>=0 && idx<k; i--){
            for(int n:freq[i]){
                res[idx++]=n;
                if(idx==k) return res;
            }
        }
        return res;
    }
}