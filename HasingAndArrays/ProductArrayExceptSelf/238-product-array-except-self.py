class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        nLen = len(nums)
        output = [1] * nLen

        # prefix calculations
        for i in range(1, nLen):
            output[i] = output[i - 1] * nums[i - 1]

        # suffix caculations with helper variable that
        # accumulates the products up to the current index (exclusive)
        cumul = 1
        for i in range(nLen - 2, -1, -1):
            cumul *= nums[i + 1]
            output[i] *= cumul

        return output
