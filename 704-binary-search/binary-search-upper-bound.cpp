class Solution {
public:
    int search(vector<int>& nums, int target) {
        if (nums.empty())
            return -1;
    
        size_t l = 0;
        size_t m = nums.size() / 2;
        size_t r = nums.size();

        while (l < r) {
            if (nums[m] <= target)
                l = m + 1;
            else
                r = m;
            
            m = (l + r) / 2;
        }

        if (l > 0 && nums[(l - 1)] == target)
            return l - 1;
        else
            return -1;
    }
};