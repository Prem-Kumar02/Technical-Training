class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int xorSum=0;
        for(int i=0; i<=n; i++){
            xorSum^=i;
        }
        for(int num: nums){
            xorSum^=num;
        }
        return xorSum;
    }
}