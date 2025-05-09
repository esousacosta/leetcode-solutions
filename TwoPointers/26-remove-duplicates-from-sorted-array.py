class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0

        # This is not needed. It is simply
        # an attempt to optimize a specific edge case.
        if nums[0] == nums[-1]:
            return 1

        l = 0

        for r in range(1, len(nums)):
            if nums[r] != nums[l]:
                nums[l + 1] = nums[r]
                l += 1

        return l + 1
