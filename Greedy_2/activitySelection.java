import java.util.*;
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        List<int[]> meetings=new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meetings.add(new int[]{finish[i],start[i]});
        }
        meetings.sort(Comparator.comparingInt(a -> a[0]));
        int result=0;
        int lastEnd=-1;
        for(int[]m :meetings){
            if(m[1]>lastEnd){
                result++;
                lastEnd=m[0];
            }
        }
        return result;
    }
}
