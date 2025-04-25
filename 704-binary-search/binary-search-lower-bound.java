class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int l = 0;
        int m = nums.length / 2;
        int r = nums.length;

        while (l < r) {
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }

            m = (l + r) / 2;
        }

        if (l < nums.length && nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }
}