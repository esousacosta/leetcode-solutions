package HasingAndArrays.ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>(Arrays.asList(nums));

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }
}