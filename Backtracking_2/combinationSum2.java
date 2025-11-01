import java.util.*;

class combinationSum2 {
    public void generateSeq(int[] candidates, int target, int index,List<List<Integer>> set,ArrayList<Integer> l){
        if(target==0){
            set.add(new ArrayList<>(l));
            return;
        }
        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;

            l.add(candidates[i]);
            generateSeq(candidates,target-candidates[i],i+1,set,l);

            l.remove(l.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> set=new ArrayList<>();
        Arrays.sort(candidates);
        ArrayList<Integer> l=new ArrayList<>();
        generateSeq(candidates,target,0,set,l);
        return set;
    }
}
