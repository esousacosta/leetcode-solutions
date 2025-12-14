import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // This map maps a seen value to its index in the array
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (seen.containsKey(target - num)) {
                return new int[] { seen.get(target - num), i };
            }

            seen.put(num, i);
        }

        return null;
    }
}