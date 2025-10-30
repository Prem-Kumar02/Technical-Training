
public class majorityEl {
  public int majorityElement(int[] nums) {
        int cnt=1;
        int el=nums[0];
        for(int i=1; i<nums.length; i++){
            if(cnt==0){
                el=nums[i];
            }
            if(nums[i]==el){
                cnt++;
            } else{
                cnt--;
            }
        }
        return el;
    }
}
