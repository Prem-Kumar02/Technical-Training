import java.util.ArrayList;
import java.util.Arrays;
public class subset2 {
  public void genSubsets(int idx,int[] arr,ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList<>(temp));
    
        for(int i=idx;i<arr.length; i++){
            if(i!=idx && arr[i]==arr[i-1]) continue;
            temp.add(arr[i]);
            genSubsets(i+1,arr,temp,res);
            temp.remove(temp.size()-1);
        }
    }
    public ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        genSubsets(0,arr,new ArrayList<>(),res);
        return res;
    }
}

