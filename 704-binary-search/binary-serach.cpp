class Solution {
 public:
  int search(vector<int>& nums, int target) {
    if (nums.empty()) return -1;
    size_t l = 0;
    size_t m = nums.size() / 2;
    size_t r = nums.size() - 1;
    while (true) {
      if (nums[m] == target) return m;
      if (target < nums[l] || target > nums[r]) return -1;
      if (target > nums[m])
        l = m + 1;
      else
        r = m - 1;

      m = l + (r - l) / 2;
    }
  }
};