class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums:
            return 0

        l = 0

        for r in range(0, len(nums)):
            if nums[r] != val:
                nums[l] = nums[r]
                l += 1

        # This one starts with no elements in the
        # valid range, thus I don't need to sum 1
        # like in the remove duplicated (leetcode pb 26)
        return l
