import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        int n = nums.length;

        for (int t = 0; t < n - 2; t++) {
            if (nums[t] > 0) break;

            if (t != 0 && nums[t] == nums[t - 1]) continue;

            int target = -nums[t];
            Set<Integer> seen = new HashSet<>();
            for (int i = t + 1; i < n; i++) {
                int complement = target - nums[i];
                
                if (seen.contains(complement)) {
                    uniqueTriplets.add(Arrays.asList(nums[t], complement, nums[i]));
                }

                seen.add(nums[i]);
            
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        output.addAll(uniqueTriplets);
        return output;
    }
}