import java.util.ArrayList;
import java.util.List;

public class printSubset {
  class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        generateSubsets(0,nums,new ArrayList<>(), res);
        return res;
    }
    public void generateSubsets(int idx,int[] nums,List<Integer> temp,List<List<Integer>> res){
        if(idx==nums.length){
            res.add(temp);
            return;
        }
        temp.add(nums[idx]);
        generateSubsets(idx+1,nums,temp,res);
        temp.remove(temp.size()-1);
        generateSubsets(idx+1,nums,temp,res);
    }
}
}
