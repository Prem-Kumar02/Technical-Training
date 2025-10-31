public class pivotIdx {
  public static int pivotIndex(int[] nums) {
    int totalsum=0;
    for(int i=0; i<nums.length; i++){
      totalsum+=nums[i];
    }
    return findPivot(nums, 0, 0, totalsum);
  }
  public static int findPivot(int[] nums, int idx, int leftSum,int totalsum){
    if(idx==nums.length) return -1;
    if(leftSum==totalsum-leftSum-nums[idx]) return idx;
    return findPivot(nums, idx+1, leftSum+nums[idx], totalsum);
  }
  public static void main(String[] args) {
    int[] arr = {1, 7, 3, 6, 5, 6};
    System.out.println(pivotIndex(arr));
  }  
}
