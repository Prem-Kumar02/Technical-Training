public class findMaxMin {
  public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int minIdx = 0, maxIdx = 0;
        int minEl = nums[0], maxEl = nums[0];

        // Find indices of min and max elements
        for (int i = 0; i < n; i++) {
            if (nums[i] < minEl) {
                minEl = nums[i];
                minIdx = i;
            }
            if (nums[i] > maxEl) {
                maxEl = nums[i];
                maxIdx = i;
            }
        }

        // Ensure minIdx < maxIdx for simplicity
        if (minIdx > maxIdx) {
            int temp = minIdx;
            minIdx = maxIdx;
            maxIdx = temp;
        }

        // 3 possible ways:
        // 1. Remove from left side up to maxIdx
        int left = maxIdx + 1;
        // 2. Remove from right side up to minIdx
        int right = n - minIdx;
        // 3. Remove min from left and max from right
        int both = (minIdx + 1) + (n - maxIdx);

        return Math.min(left, Math.min(right, both));
    }

    public static void main(String[] args) {
        findMaxMin solution = new findMaxMin();
        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};
        int result = solution.minimumDeletions(nums);
        System.out.println("Minimum deletions required: " + result);
    }
}
