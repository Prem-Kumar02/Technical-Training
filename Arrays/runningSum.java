

public class runningSum {
  public int[] runningSum(int[] nums) {
        int preSum=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
            preSum+=nums[i];
            nums[i]=preSum;
        }
        return nums;
    }
  public static void main(String[] args) {
        runningSum solution = new runningSum();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.runningSum(nums);
        System.out.print("Running sum: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
