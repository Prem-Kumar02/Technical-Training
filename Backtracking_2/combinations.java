import java.util.*;
class combinations {
    public void backtrack(int idx,int n, int k,List<List<Integer>> res, List<Integer> temp){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx; i<=n;i++){
            temp.add(i);
            backtrack(i+1,n,k,res,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(1,n,k,res,new ArrayList<>());
        return res;
    }
}
