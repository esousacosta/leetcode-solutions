class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        aux = {}
        for i in range(len(nums)):
            subproblem = target - nums[i]
            if subproblem in aux:
                return [i, aux[subproblem]]
            aux[nums[i]] = i