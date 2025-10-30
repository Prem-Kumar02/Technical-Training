public class removeDuplicates {
  public int removeDuplicates(int[] nums) {
        int k=1;
        for(int i= 1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        removeDuplicates solution = new removeDuplicates();
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int k = solution.removeDuplicates(nums);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
