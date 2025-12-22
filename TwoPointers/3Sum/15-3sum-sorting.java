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

        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        for (int t = 0; t < n - 2; t++) {

            // Skip repeated targets
            if (t != 0 && nums[t] == nums[t - 1]) continue;

            // positive numbers realm, we cannot find a sum that is negative
            // moving forward
            if (nums[t] > 0) break;

            int l = t + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[l] + nums[r] + nums[t];

                if (sum == 0) {
                    output.add(Arrays.asList(nums[l], nums[r], nums[t]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return output;
    }
}