import java.util.ArrayList;
import java.util.List;

public class permutations {
  public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> tempList, boolean[] used, List<List<Integer>> res) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(nums, tempList, used, res);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void backtrackSwap(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            res.add(tempList);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrackSwap(nums, start + 1, res);
            swap(nums, start, i);
        }
    }
}
