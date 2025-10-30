import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class intersectionOfArr {
  public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n=nums1.length;
        int m=nums2.length;
        int i=0,j=0;
        Set<Integer> st=new HashSet<>();
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                i++;
            } else if(nums1[i]>nums2[j]){
                j++;
            } else{
                st.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[st.size()];
        int idx = 0;
        for (int num : st) {
            result[idx++] = num;
        }

        return result;
    }  
}
