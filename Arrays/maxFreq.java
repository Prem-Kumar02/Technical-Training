

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class maxFreq {
  public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Collections.max(freq.values());

        int total = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) total += f;
        }
        return total;

    }
    public static void main(String[] args) {
        maxFreq solution = new maxFreq();
        int[] nums = {1, 3, 2, 3, 4, 1, 3};
        int result = solution.maxFrequencyElements(nums);
        System.out.println("Total elements with maximum frequency: " + result);
    }
}
