class Solution {
    public int search(int[] nums, int target) {
        int f = 0;
        int l = nums.length - 1;
        int m = (f + l) / 2;

        while (f < l) {
            if (nums[m] == target) {
                return m;
            }

            if (nums[m] < target) {
                f = m + 1;
            } else {
                l = m - 1;
            }

            m = (l + f) / 2;
        }

        return nums[m] == target ? m : -1;
    }
}