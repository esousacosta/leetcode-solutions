class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int l = 0;
        int m = nums.length / 2;
        int r = nums.length;

        while (l < r) {
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }

            m = (l + r) / 2;
        }

        if (l > 0 && nums[l - 1] == target) {
            return l - 1;
        } else {
            return -1;
        }
    }
}