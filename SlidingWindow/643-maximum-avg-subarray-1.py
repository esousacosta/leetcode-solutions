class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        if not nums:
            return 0

        s = sum(nums[:k])
        maxSum = s

        for i in range(k, len(nums)):
            s += nums[i] - nums[i - k]
            if s > maxSum:
                maxSum = s

        return maxSum / k
