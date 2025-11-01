import java.util.*;
class combinationSum {
    public void backtrack(int sum,int idx,int[] arr, int t,List<List<Integer>> res,ArrayList<Integer> temp){
        if(sum==t){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum>t || idx==arr.length) return;
        sum+=arr[idx];
        temp.add(arr[idx]);
        backtrack(sum,idx,arr,t,res,temp);

        sum-=arr[idx];
        temp.remove(temp.size()-1);
        backtrack(sum,idx+1,arr,t,res,temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        int sum=0;
        backtrack(sum,0,candidates,target,res,new ArrayList<>());
        return res;
    }
}
